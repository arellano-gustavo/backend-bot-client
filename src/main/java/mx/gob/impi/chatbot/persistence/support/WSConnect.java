package mx.gob.impi.chatbot.persistence.support;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.Empleado;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WSConnect {
    private static final Logger logger = LoggerFactory.getLogger(WSConnect.class);
    private XmlMapper xmlMapper = new XmlMapper();
    private static WSConnect instance = null;

    public static void main(String...argv) {
        WSConnect wsc = WSConnect.getInstance();
        Empleado empleado = wsc.loadUserFromWs(1996, "http://192.168.10.108/ServicioSAP/SAPService.svc/basic/");
        logger.info(empleado.getNombre());
    }

    private WSConnect(){}

    public static WSConnect getInstance() {
        if(instance==null) {
            instance = new WSConnect();
        }
        return instance;
    }

    public Empleado loadUserFromWs(Integer idEmpleado, String url) {
        Empleado defaultEmpleado = new Empleado("OSORIO", "RAMIREZ", "RAOE800106HDFMSS09", "ESTEBAN.RAMIREZ@IMPI.GOB.MX", "ACTIVO", "2013-10-01", "1980-01-06", "2018-03-01", "OC", "ESTEBAN", "RAOE8001068C7", "1996" , "00001996", "ESTEBAN RAMIREZ OSORIO");
        String[] actPro = System.getProperty("spring-boot.run.profiles","").split(",");
        for(String profile : actPro) {
            if(!"impi".equals(profile)) {
                logger.info("El perfil detectado NO es para el IMPI... Se retornará un usuario dummy");
                return defaultEmpleado;
            }
        }

        String respuesta = null;
        String xmlString = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<s:Body>" +
                "<GetEmpleado xmlns=\"http://tempuri.org/\">" +
                "<Numero_Personal>" + idEmpleado + "</Numero_Personal>" +
                "<_Tipo_Empleado>TODOS</_Tipo_Empleado>" +
                "</GetEmpleado>" +
                "</s:Body>" +
                "</s:Envelope>";
        OkHttpClient client = new OkHttpClient();
        MediaType xml = MediaType.get("text/xml; charset=utf-8");
        RequestBody body = RequestBody.create(xmlString, xml);
        Request request = new Request.Builder()
            .addHeader("SOAPAction", "http://tempuri.org/ISAPService/GetEmpleado")
            .addHeader("Content-Type", "text/xml; charset=utf-8")
            .url(url)
            .post(body)
            .build();
        try {
            Response response = client.newCall(request).execute() ;
            respuesta = response.body().string();
            response.close();
        } catch (IOException ioe) {
            String msg = ioe.toString();
            logger.error(msg);
            //solo cuando ocurra un error, se debe regresar este objeto:
            return defaultEmpleado;
        }

        //se formatea para recuperar las propiedades
        respuesta = respuesta.replace("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><GetEmpleadoResponse xmlns=\"http://tempuri.org/\">","");
        respuesta = respuesta.replace("</GetEmpleadoResponse></s:Body></s:Envelope>","");
        respuesta = respuesta.replace("<a:", "<").replace("</a:", "</");

        Empleado empleado = null;
        try {
            empleado = xmlMapper.readValue(respuesta, Empleado.class);
        } catch (JsonParseException | JsonMappingException je) {
            String msg = je.toString();
            logger.error(msg);
        } catch (IOException ioe) {
            String msg = ioe.toString();
            logger.error(msg);
        }
        return empleado;
    }
}
