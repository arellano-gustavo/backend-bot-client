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
 * Modulo:      UserArea
 * Tipo:        clase
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

import mx.gob.impi.chatbot.persistence.api.db.UserAreaMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserArea;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Implementacion del servicio de UserArea
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class UserAreaServiceImpl implements UserAreaService {
	private static final Logger logger = LoggerFactory.getLogger(UserAreaServiceImpl.class);
	
    @Autowired
    private UserAreaMapper userAreaMapper;

    @Override
    public List<UserArea> getAll() {
        return userAreaMapper.getAll();
    }

    @Override
    public MainControllerResponse save(Integer idUser, Integer idArea) {
        try {
        	userAreaMapper.insert(idUser, idArea);
            return new MainControllerResponse("user.id is "+idUser + " and rol.id is " + idArea, "Object UserArea inserted on DB", true);
        } catch(RuntimeException  rte) {
        	String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error in UserRolService.save", msg, false);
        }
    }

    @Override
    public MainControllerResponse delete(int idUser, int idArea) {
        try {
        	userAreaMapper.delete(idUser, idArea);
            return new MainControllerResponse("user.id is "+idUser + " and rol.id is " + idArea, "Object UserArea Deleted on DB", true);
        } catch(RuntimeException  rte) {
        	String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error in UserRolService.save", msg, false);
        }
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
