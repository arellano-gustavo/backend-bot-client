/*
 *    Proyecto: Chatbot Ultra
 *       Fecha: 05/09/2019
 *       Autor: David Corza
 * Descripción: Servicio para poder conectarse a DialogFlow y alimentar al bot.
 */
package mx.gob.impi.chatbot.engine.service;
import com.google.gson.Gson;
import mx.gob.impi.chatbot.engine.model.login.LogInRequest;
import mx.gob.impi.chatbot.engine.model.login.LogInResponse;
import org.apache.log4j.Logger;
/**
 * Implementación del servicio para administrar preguntas del chatbot.
 * @author David Corza
 */
public class TextClientSrvAdminImpl implements TextClientSrvAdmin{
    private final static Logger logger = Logger.getLogger(TextClientSrvImpl.class);
    
    public String response(LogInRequest challenge) {
        logger.info("LLama Servicio...");
        logger.info("Información recibida del usuario: "+ challenge.getEmail());
        LogInResponse respuesta = new LogInResponse();
            if (challenge.getContra().equals("Demo")) 
            {
                respuesta.setIdsuario("1");
                respuesta.setUsuario("Demo");
            }
            else                
            {
                 respuesta.setIdsuario("-1");
                respuesta.setUsuario("No Autorizado");
            }           
           Gson gson = new Gson();
       String result = gson.toJson(respuesta);        
        logger.info("Sending Servicio LonIn -->" + challenge + "<--");
        return result;
    }
}
