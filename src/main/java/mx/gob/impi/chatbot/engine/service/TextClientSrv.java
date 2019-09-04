package mx.gob.impi.chatbot.engine.service;

import mx.gob.impi.chatbot.engine.model.ChatbotRequest;
import mx.gob.impi.chatbot.engine.model.login.LogInRequest;

public interface TextClientSrv {
    String response(String area, String challenge, String idUsuario);
    String response(ChatbotRequest challenge);
    String response(LogInRequest data);
}