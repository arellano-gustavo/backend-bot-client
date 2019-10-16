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
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de User
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.PageBoundaries;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de User
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UserService {
    /**
     * Proporciona la lista de User registrados, estén o no activos.
     * @return Objeto de tipo 'List' con la totalidad de User registrados.
     */
    List<User> getAllUsers();
    
    List<User> getAllUsersAsc(PageBoundaries pb);
    List<User> getAllUsersDesc(PageBoundaries pb); 

    /**
     * Proporciona un objeto de tipo 'User' cuyo id es proporcionado.
     *
     * @param id Entero con el id (llave primaria) de un User.
     * @return Objeto de tipo 'User' asociado al id proporcionado.
     */
    User findUserById(Integer id);

    /**
     * Proporciona un objeto de tipo 'User' cuyo mail es proporcionado.
     *
     * @param mail Correo del User que se busca
     * @return Objeto de tipo 'User' asociado al mail proporcionado.
     */
    User findUserByMail(String mail);

    /**
     * Proporciona un objeto de tipo 'User' cuyo name es proporcionado.
     *
     * @param name Nombre del User que se busca
     * @return Objeto de tipo 'User' asociado al name proporcionado.
     */
    User findUserByName(String name);

    /**
     * Proporciona un objeto de tipo 'User' cuyo token es proporcionado.
     *
     * @param token Cadena que identifica aun usuario previamente autenticado
     * @return Objeto de tipo 'User' asociado al token proporcionado.
     */
    User findUserByToken(String token);

    /**
     * Guarda en la base de datos el objeto de tipo 'User' proporcionado.
     *
     * @param user Objeto de tipo 'User' a almacenar.
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de guardado.
     */
    MainControllerResponse save(User user);

    /**
     * Actualiza en la base de datos el objeto de tipo 'User' proporcionado.
     *
     * @param user Objeto de tipo 'User' a actualizar.
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de actualzación.
     */
    MainControllerResponse update(User user);

    /**
     * Retorna un objeto de tipo 'User' que fue precargado por un
     * web service que nos ha dado el cliente con base sólo en el id del empleado.
     * Si el ID de empleado no existe, este método regresa 'null'.
     *
     * @param idEmpleado ID de un empleado del IMPI
     *
     * @return objeto User o en su caso, 'null' si el id del empleado no existe.
     */
    User loadUserFromWs(Integer idEmpleado);

}
