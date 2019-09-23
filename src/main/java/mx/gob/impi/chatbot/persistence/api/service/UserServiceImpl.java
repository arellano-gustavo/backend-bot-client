package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByMail(String mail) {
        return userMapper.getUserByMail(mail);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUserByToken(String token) {
        return userMapper.getUserBySecurityToken(token);
    }

    @Override
    public MainControllerResponse save(User user) {
        userMapper.insert(user);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public MainControllerResponse update(User user) {
        userMapper.update(user);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public MainControllerResponse registerUsuarioArea(Integer idUsuario, Integer idArea) {
        // TODO Auto-generated method stub
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public MainControllerResponse registerUsuarioRol(Integer idUsuario, Integer idRol) {
        // TODO Auto-generated method stub
        return new MainControllerResponse("message", "longMessage", true);
    }

}
