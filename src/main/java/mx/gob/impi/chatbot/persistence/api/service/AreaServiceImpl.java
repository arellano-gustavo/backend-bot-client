package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.gob.impi.chatbot.persistence.api.db.AreaMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.Area;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAll() {
        return areaMapper.getAll();
    }

    @Override
    public Area getAreaById(Integer id) {
        return areaMapper.getAreaById(id);
    }

    @Override
    public MainControllerResponse save(Area area) {
        areaMapper.insert(area);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public MainControllerResponse update(Area area) {
        areaMapper.update(area);
        return new MainControllerResponse("message", "longMessage", true);
    }

}
