package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.gob.impi.chatbot.persistence.api.db.UserRolMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserRol;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

public class UserRolServiceImpl implements UserRolService {
    @Autowired
    private UserRolMapper userRolMapper;

    @Override
    public List<UserRol> getAll() {
        return userRolMapper.getAll();
    }

    @Override
    public MainControllerResponse save(Integer idUser, Integer idArea) {
        userRolMapper.insert(idUser, idArea);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public MainControllerResponse delete(Integer idUser, Integer idArea) {
        userRolMapper.delete(idUser, idArea);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public List<UserRol> getUserRolByIdUser(Integer idUser) {
        return userRolMapper.getByIdUser(idUser);
    }

    @Override
    public List<UserRol> getUserRolByIdArea(Integer idArea) {
        return userRolMapper.getByIdRol(idArea);
    }

}
