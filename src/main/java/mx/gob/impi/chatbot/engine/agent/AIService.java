/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.impi.chatbot.engine.agent;

import com.google.gson.Gson;
import io.vertx.core.json.Json;
import mx.gob.impi.chatbot.engine.model.login.LogInResponse;

/**
 *
 * @author Administrador
 */
public class AIService {
    private static AIService instance = null;
    public static AIService getInstance() {
        if (instance==null) {
            instance = new AIService();
        }
        return instance;
    }
       
    public String getWorker(String contra) {
        LogInResponse respuesta = new LogInResponse();
            if (contra.equals("Demo")) 
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
        return result;
    }
}
