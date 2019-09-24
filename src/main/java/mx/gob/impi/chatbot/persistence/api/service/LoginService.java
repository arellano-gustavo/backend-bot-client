package mx.gob.impi.chatbot.persistence.api.service;

import mx.gob.impi.chatbot.persistence.api.model.domain.LoginResponse;

public interface LoginService {
    LoginResponse login(String user, String password);
}
