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
 * Modulo:      Rol
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de rol
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

import mx.gob.impi.chatbot.persistence.api.db.RolMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.Rol;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Implementacion del servicio de Rol
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class RolServiceImpl implements RolService {
	private static final Logger logger = LoggerFactory.getLogger(RolServiceImpl.class);
	
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
        try {
        	rolMapper.insert(rol);
        	return new MainControllerResponse("rol.id is "+rol.getId(), "Object Rol inserted on DB", true);
        } catch(RuntimeException  rte) {
        	String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error al insertar un nuevo Rol en la base de datos", msg, false);
        }
    }

    @Override
    public MainControllerResponse update(Rol rol) {
        try {
        	rolMapper.update(rol);
        	return new MainControllerResponse("rol.id is "+rol.getId(), "Object Rol updated on DB", true);
        } catch(RuntimeException  rte) {
        	String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error al actualizar un Rol existente en la base de datos", msg, false);
        }
    }

}
