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
 * Modulo:      UserRol
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de UserRol
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

import mx.gob.impi.chatbot.persistence.api.db.UserRolMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserRol;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Implementacion del servicio de UserRol
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class UserRolServiceImpl implements UserRolService {
    private static final Logger logger = LoggerFactory.getLogger(UserRolServiceImpl.class);
    
    @Autowired
    private UserRolMapper userRolMapper;

    @Override
    public List<UserRol> getAll() {
        return userRolMapper.getAll();
    }

    @Override
    public MainControllerResponse save(Integer idUser, Integer idRol) {
        try {
            userRolMapper.insert(idUser, idRol);
            return new MainControllerResponse("user.id is "+idUser + " and rol.id is " + idRol, "Object UserRol inserted on DB", true);
        } catch(RuntimeException  rte) {
            logger.error(rte.getMessage());
            return new MainControllerResponse("Error in UserRolService.save", rte.getMessage(), false);
        }
    }

    @Override
    public MainControllerResponse delete(Integer idUser, Integer idRol) {
    	try {
    		userRolMapper.delete(idUser, idRol);
            return new MainControllerResponse("user.id is "+idUser + " and rol.id is " + idRol, "Object UserRol deleted on DB", true);
        } catch(RuntimeException  rte) {
            logger.error(rte.getMessage());
            return new MainControllerResponse("Error in UserRolService.delete", rte.getMessage(), false);
        }
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
