/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.service
 * Modulo:      User
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de area
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.impi.chatbot.persistence.api.db.AreaMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.Area;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Implementacion del servicio de Area
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class AreaServiceImpl implements AreaService {
    private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

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
        try {
            areaMapper.insert(area);
            return new MainControllerResponse("area.id is "+area.getId(), "Object Area inserted on DB", true);
        } catch(RuntimeException  rte) {
            String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error al insertar una nueva Area en la base de datos", msg, false);
        }
    }

    @Override
    public MainControllerResponse update(Area area) {
        try {
            areaMapper.update(area);
            return new MainControllerResponse("area.id is "+area.getId(), "Object Area updated on DB", true);
        } catch(RuntimeException  rte) {
            String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error al actualizar una Area existente en la base de datos", msg, false);
        }
    }

}
