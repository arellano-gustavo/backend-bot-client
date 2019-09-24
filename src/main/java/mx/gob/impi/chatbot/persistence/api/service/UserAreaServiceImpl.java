package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.gob.impi.chatbot.persistence.api.db.UserAreaMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserArea;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

public class UserAreaServiceImpl implements UserAreaService {
    @Autowired
    private UserAreaMapper userAreaMapper;

    @Override
    public List<UserArea> getAll() {
        return userAreaMapper.getAll();
    }

    @Override
    public MainControllerResponse save(Integer idUser, Integer idArea) {
        userAreaMapper.insert(idUser, idArea);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public MainControllerResponse delete(Integer idUser, Integer idArea) {
        userAreaMapper.delete(idUser, idArea);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public List<UserArea> getUserAreaByIdUser(Integer idUser) {
        return userAreaMapper.getByIdUser(idUser);
    }

    @Override
    public List<UserArea> getUserAreaByIdArea(Integer idArea) {
        return userAreaMapper.getByIdArea(idArea);
    }

}
