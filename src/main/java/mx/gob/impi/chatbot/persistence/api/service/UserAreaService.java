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
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de persona
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserArea;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de 'UserArea'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UserAreaService {
    List<UserArea> getAll();
    MainControllerResponse save(Integer idUser, Integer idArea);
    MainControllerResponse delete(Integer idUser, Integer idArea);
    
    List<UserArea> getUserAreaByIdUser(Integer idUser);
    List<UserArea> getUserAreaByIdArea(Integer idArea);
}
