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
 * Servicio de usuario
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
    /**
     * Proporciona la lista de la relacion UserArea registradas.
     *
     * @return Objeto de tipo 'List' con la totalidad de UserArea registradas.
     */
    List<UserArea> getAll();

    /**
     * Guarda en la base de datos el objeto de tipo 'UserArea' proporcionado.
     *
     * @param idUser Entero con el id de un Usuario.
     * @param idArea Entero con el id de un Area.
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de guardado.
     */
    MainControllerResponse save(Integer idUser, Integer idArea);

    /**
     * Borra de la base de datos el objeto de tipo 'UserArea' proporcionado, si es que existe.
     *
     * @param idUser Entero con el id de un Usuario.
     * @param idArea Entero con el id de un Area.
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de borrado.
     */
    MainControllerResponse delete(Integer idUser, Integer idArea);

    /**
     * Proporciona objetos de tipo 'UserArea' cuyo idUser es proporcionado.
     *
     * @param idUser Entero con el id (llave foranea) de un Usuario.
     * @return Objeto de tipo 'List' con la totalidad de UserArea registradas
     * con el idUser proporcionado.
     */
    List<UserArea> getUserAreaByIdUser(Integer idUser);

    /**
     * Proporciona objetos de tipo 'UserArea' cuyo idArea es proporcionado.
     *
     * @param idArea Entero con el id (llave foranea) de un Area.
     * @return Objeto de tipo 'List' con la totalidad de UserArea registradas
     * con el idArea proporcionado.
     */
    List<UserArea> getUserAreaByIdArea(Integer idArea);
}
