/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.service
 * Modulo:      User
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Implementacion del servicio de User
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.Empleado;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.PageBoundaries;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserPagination;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * <p>Descripción:</p>
 * Implementacion del servicio de User
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        PageBoundaries pb = new PageBoundaries(0, 0, "id", true);
        return userMapper.getAll(pb);
    }
    @Override
    public UserPagination getAllUsers(PageBoundaries pb) {
        List<User> allUsers = null;
        if(pb.isAscending()) {
            allUsers = userMapper.getAll(pb);
        } else {
            allUsers = userMapper.getAllDesc(pb);
        }
        return paginate(allUsers, pb.getPage(), pb.getSize());
    }
    
    private UserPagination paginate(List<User> originalArray, Integer pageNumber, Integer pageSize) {
    	UserPagination emptyResponse = new UserPagination(0,new ArrayList<>());
        if(pageSize<1 || pageNumber<1) return emptyResponse;
        int a = pageSize * pageNumber - pageSize +1;
        int b = pageSize * pageNumber;
        int len = originalArray.size();
        if(a>len) return emptyResponse;
        if(b>len) b = len;
        int newLen = b-a+1;
        List<User> result = new ArrayList<>();
        for(int i = 0; i<newLen; i++) {
            result.add(originalArray.get(a+i-1));
        }
        return new UserPagination(len, result);
    }
    
    @Override
    public User findUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User findUserByMail(String mail) {
        return userMapper.getUserByMail(mail);
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User findUserByToken(String token) {
        return userMapper.getUserBySecurityToken(token);
    }

    @Override
    public MainControllerResponse save(User user) {
        try {
            userMapper.shortInsert(user);
            User u = userMapper.getUserByMail(user.getMail());
            return new MainControllerResponse(u.getId()+"", "Object User inserted on DB", true);
        } catch(RuntimeException  rte) {
        	String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error al insertar un nuevo Usuario en la base de datos debido a que el usuario o el correo están duplicados", msg, false);
        }
    }

    @Override
    public MainControllerResponse update(User user) {
        try {
            userMapper.update(user);
            return new MainControllerResponse("user.id is "+user.getId(), "Object User updated on DB", true);
        } catch(RuntimeException  rte) {
        	String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error al actualizar un Usuario existente en la base de datos debido a que el usuario o el correo están duplicados", msg, false);
        }
    }

    @Override
    public Empleado loadUserFromWs(Integer idEmpleado) {
    	String respuesta = null;
		String url = "http://192.168.10.108/ServicioSAP/SAPService.svc/basic/";
		String xmlString = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">" + 
	    		"<s:Body>" + 
	    		"<GetEmpleado xmlns=\"http://tempuri.org/\">" + 
	    		"<Numero_Personal>" + idEmpleado + "</Numero_Personal>" + 
	    		"<_Tipo_Empleado>TODOS</_Tipo_Empleado>" + 
	    		"</GetEmpleado>" + 
	    		"</s:Body>" + 
	    		"</s:Envelope>";		
		OkHttpClient client = new OkHttpClient();
		MediaType XML = MediaType.get("text/xml; charset=utf-8");		
		RequestBody body = RequestBody.create(xmlString, XML);
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
            
          //solo cuando este sin conexion se debe tener esta linea
            respuesta = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><GetEmpleadoResponse xmlns=\"http://tempuri.org/\"><GetEmpleadoResult xmlns:a=\"http://schemas.datacontract.org/2004/07/PE_SAPService\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"><a:Apellido_Materno>OSORIO</a:Apellido_Materno><a:Apellido_Paterno>RAMIREZ</a:Apellido_Paterno><a:Area_Adscripcion><a:Clave>10000531</a:Clave><a:Descripcion>COORDINACIÓN DEPARTAMENTAL DE DESARROLLO DE SISTEMAS DE MARCAS</a:Descripcion></a:Area_Adscripcion><a:CURP>RAOE800106HDFMSS09</a:CURP><a:Correo_Institucional>ESTEBAN.RAMIREZ@IMPI.GOB.MX</a:Correo_Institucional><a:Direccion><a:Clave>10000500</a:Clave><a:Descripcion>DIRECCIÓN DIVISIONAL DE SISTEMAS Y TECNOLOGÍA DE LA INFORMACIÓN</a:Descripcion><a:Subdireccion><a:Clave>10000530</a:Clave><a:Descripcion>SUBDIRECCIÓN DIVISIONAL DE DESARROLLO DE SISTEMAS</a:Descripcion></a:Subdireccion></a:Direccion><a:Estatus>ACTIVO</a:Estatus><a:Fecha_Alta_Tecnica>2013-10-01T00:00:00</a:Fecha_Alta_Tecnica><a:Fecha_Nacimiento>1980-01-06T00:00:00</a:Fecha_Nacimiento><a:Fecha_Ultima_Promocion>2018-03-01T00:00:00</a:Fecha_Ultima_Promocion><a:Grupo_Personal>OC</a:Grupo_Personal><a:Jefe><a:Apellido_Materno>ANGELES</a:Apellido_Materno><a:Apellido_Paterno>CONDE</a:Apellido_Paterno><a:Area_Adscripcion><a:Clave>10000531</a:Clave><a:Descripcion>COORDINACIÓN DEPARTAMENTAL DE DESARROLLO DE SISTEMAS DE MARCAS</a:Descripcion></a:Area_Adscripcion><a:CURP>COAE810325HDFNND03</a:CURP><a:Correo_Institucional>EDUARDO.CONDE@IMPI.GOB.MX</a:Correo_Institucional><a:Direccion i:nil=\"true\"/><a:Estatus>INACTIVO</a:Estatus><a:Fecha_Alta_Tecnica>2011-02-01T00:00:00</a:Fecha_Alta_Tecnica><a:Fecha_Nacimiento>1981-03-25T00:00:00</a:Fecha_Nacimiento><a:Fecha_Ultima_Promocion>2019-01-01T00:00:00</a:Fecha_Ultima_Promocion><a:Grupo_Personal>MM</a:Grupo_Personal><a:Jefe i:nil=\"true\"/><a:Lista_Inventario i:nil=\"true\"/><a:Nombre>EDUARDO</a:Nombre><a:Nombre_Completo>EDUARDO CONDE ANGELES</a:Nombre_Completo><a:Numero_Empleado>00001673</a:Numero_Empleado><a:Numero_Empleado_Entero>0</a:Numero_Empleado_Entero><a:Oficinal_Regional><a:Clave i:nil=\"true\"/><a:Descripcion i:nil=\"true\"/></a:Oficinal_Regional><a:Puesto><a:Clave>20000233</a:Clave><a:Descripcion>COORDINADOR DEPARTAMENTAL</a:Descripcion><a:Short>O33</a:Short></a:Puesto><a:RFC>COAE810325RZ0</a:RFC><a:Vacaciones i:nil=\"true\"/></a:Jefe><a:Lista_Inventario i:nil=\"true\"/><a:Nombre>ESTEBAN</a:Nombre><a:Nombre_Completo>ESTEBAN RAMIREZ OSORIO</a:Nombre_Completo><a:Numero_Empleado>00001996</a:Numero_Empleado><a:Numero_Empleado_Entero>1996</a:Numero_Empleado_Entero><a:Oficinal_Regional><a:Clave>ORDF</a:Clave><a:Descripcion>IMPI ARENAL</a:Descripcion></a:Oficinal_Regional><a:Puesto><a:Clave>20000250</a:Clave><a:Descripcion>ESPECIALISTA \"A\" EN PROPIEDAD INDUSTRIAL</a:Descripcion><a:Short>TE03</a:Short></a:Puesto><a:RFC>RAOE8001068C7</a:RFC><a:Vacaciones><a:Tomadas>3</a:Tomadas><a:Tomadas_Anterior>6</a:Tomadas_Anterior><a:Totales>10</a:Totales><a:Totales_Anterior>10</a:Totales_Anterior></a:Vacaciones></GetEmpleadoResult></GetEmpleadoResponse></s:Body></s:Envelope>";
    	    
		}
	    
	    System.out.println(respuesta);
	    
	    //se formatea para recuperar las propiedades
	    respuesta = respuesta.replace("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><GetEmpleadoResponse xmlns=\"http://tempuri.org/\">","");
		respuesta = respuesta.replace("</GetEmpleadoResponse></s:Body></s:Envelope>","");
		respuesta = respuesta.replace("<a:", "<").replace("</a:", "</");

		com.fasterxml.jackson.dataformat.xml.XmlMapper xmlMapper = new com.fasterxml.jackson.dataformat.xml.XmlMapper();
	    
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
