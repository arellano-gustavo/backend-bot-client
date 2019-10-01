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
 * Fecha:       Viernes 24 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de login
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import mx.gob.impi.chatbot.persistence.api.model.domain.LoginResponse;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de 'login'
 * para autenticar al usuario
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface LoginService {
	/**
	 * Autentica al usuario por medio de las crendeciales proporcionadas
	 * 
	 * @param user Nombre del usuario que se quiere autenticar
	 * @param password Contraseña con la que se autentica al usuario
	 * 
	 * @return Objeto de tipo 'LoginResponse' con la respuesta de la
	 *  autenticacion de las credenciales y en caso de que las credenciales
	 *  sean valiadas se envia el JWT para la autorizacion del usuario
	 */
    LoginResponse login(String user, String password);

    /**
     * Para el usuario dado, cambia el antiguo password por el password dado.
     * 
     * @param user String usuario existente
     * @param password String, Nuevo Password
     * 
     * @param jwt String, jwt original
     * 
     * @return LoginResponse, con el dictamen del cambio
     */
    LoginResponse changePassword(String user, String password, String jwt);

    LoginResponse restorePassword(String securityToken, String password);

    LoginResponse requestRestore(String mail);
}
