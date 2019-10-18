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
 * Tipo:        interface
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

import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserRol;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de 'UserRol'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UserRolService {
    /**
     * Proporciona la lista de las relaciones UserRol registradas.
     *
     * @return Objeto de tipo 'List' con la totalidad de UserRol registrados.
     */
    List<UserRol> getAll();

    /**
     * Guarda en la base de datos el objeto de tipo 'UserRol' proporcionado.
     *
     * @param idUser Entero con el id de un Usuario.
     * @param idRol Entero con el id de un Rol.
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de guardado.
     */
    MainControllerResponse save(Integer idUser, Integer idRol);

    /**
     * Borra de la base de datos el objeto de tipo 'UserRol' proporcionado, si es que existe.
     *
     * @param idUser Entero con el id de un Usuario.
     * @param idRol Entero con el id de un Rol.
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de borrado.
     */
    MainControllerResponse delete(int idUser, int idRol);

    /**
     * Proporciona objetos de tipo 'UserRol' cuyo idUser es proporcionado.
     *
     * @param idUser Entero con el id (llave foranea) de un Usuario.
     * @return Objeto de tipo 'List' con la totalidad de UserRol registradas
     * con el idUser proporcionado.
     */
    List<UserRol> getUserRolByIdUser(Integer idUser);

    /**
     * Proporciona objetos de tipo 'UserRol' cuyo idRol es proporcionado.
     *
     * @param idRol Entero con el id (llave foranea) de un Rol.
     * @return Objeto de tipo 'List' con la totalidad de UserRol registradas
     * con el idRol proporcionado.
     */
    List<UserRol> getUserRolByIdRol(Integer idRol);
}
