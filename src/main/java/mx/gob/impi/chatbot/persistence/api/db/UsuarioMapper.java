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
 * Paquete:     mx.gob.impi.chatbot.persistence.api.db
 * Modulo:      User
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad usuario 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import mx.gob.impi.chatbot.persistence.api.model.domain.User;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad usuario
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UsuarioMapper extends IMapper<User> {

    /**
     * Obtiene un usuario realizando la búsqueda con el nombre de pila.
     *
     * @param usuario Nombre de pila del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    User getUserByName(String usuario);

    /**
     * Obtiene un usuario realizando la búsqueda con el correo electrónico.
     *
     * @param correo Dirección de correo electrónico.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    User getUserByCorreo(String correo);

    /**
     * Obtiene un usuario realizando la búsqueda con el Id de seguridad.
     *
     * @param idSeguridad Id de seguridad del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    User getUserByIdSeguridad(String idSeguridad);

    /**
     * Elimina al usuario cuyo ID es el dado y también elimina a las 
     * dependencias que este tiene en la base de datos.
     *
     * @param idUser El id del usuario
     */
    void deleteFisicoA(int idUser);

    void deleteFisicoB(int idUser);

    void deleteFisicoC(int idUser);
}
