package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.gob.impi.chatbot.persistence.api.db.RolMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.Rol;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

public class RolServiceImpl implements RolService {
    @Autowired
    private RolMapper rolMapper;

    @Override
    public List<Rol> getAll() {
        return rolMapper.getAll();
    }

    @Override
    public Rol getRolById(Integer id) {
        return rolMapper.getRolById(id);
    }

    @Override
    public MainControllerResponse save(Rol rol) {
        rolMapper.insert(rol);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public MainControllerResponse update(Rol rol) {
        rolMapper.update(rol);
        return new MainControllerResponse("message", "longMessage", true);
    }

}
