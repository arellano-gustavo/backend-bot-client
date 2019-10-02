package mx.gob.impi.chatbot.persistence.api.service;

public interface JwtManagerService {
    String createToken(String username);
    boolean verifyToken(String jwt, String user);
}
