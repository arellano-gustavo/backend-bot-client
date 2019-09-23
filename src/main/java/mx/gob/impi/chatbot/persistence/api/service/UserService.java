package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User getUserByMail(String mail);
    User getUserByName(String name);
    User getUserByToken(String token);
    MainControllerResponse save(User user);
    MainControllerResponse update(User user);
    MainControllerResponse registerUsuarioArea(Integer idUsuario, Integer idArea);
    MainControllerResponse registerUsuarioRol(Integer idUsuario, Integer idRol);
}
