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
 * Paquete:     mx.gob.impi.chatbot.persistence.api.controller
 * Modulo:      Autorizacion
 * Tipo:        Controller
 * Autor:       Gustavo Adolfo Arellano Sandoval (GAA)
 * Fecha:       Lunes 23 de Septiembre de 2019
 * Version:     0.0.1
 * .
 * Clase controller de los servicios rest 
 * para la autenticacion y autorizacion
 * de los usuarios
 *
 * Historia:    .
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.gob.impi.chatbot.persistence.api.model.domain.Login;
import mx.gob.impi.chatbot.persistence.api.model.domain.LoginResponse;
import mx.gob.impi.chatbot.persistence.api.service.LoginService;

/**
 * <p>Descripción:</p>
 * Implementacion del controlador de autenticacion
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RestController
@Api(value = "auth")
@RequestMapping(value = "/api/chatbot/auth")
public class AuthController {
    
    @Autowired
    private LoginService loginService;
    


//LOGIN
    /**
     * Firma al usuario en el sistema con las credenciales proporcionadas
     * @param login Objeto  de tipo 'Login' con las credenciales proporcionadas por el usuario
     * @return Objeto de tipo 'LoginResponse' con el resultado de la autencicacion
     */
    @ApiOperation(
        value = "AuthController::login",
        notes = "Firma a un usuario al sistema")
    @RequestMapping(
        value = "/login.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody Login login) {
        return loginService.login(login.getUser(), login.getPassword());
    }

// Recupera clave (forgot)
    /**
     * Solictud del cambio de contraseña de un usuario por medio del mail dado 
     * @param mail Cadena con el mail del usuario al que se solicita cambiar la contraseña
     * @return Objeto de tipo 'LoginResponse' con el resultado de la solicitud 
     *         del cambio de contraseña
     */
    @ApiOperation(
        value = "AuthController::request-restore",
        notes = "Solicita la recuperación de la clave de un usuario")
    @PostMapping(
        value = "/request-restore.json",
        produces = "application/json; charset=utf-8")
    public LoginResponse requestRestore(@RequestParam String mail) {
        return loginService.requestRestore(mail);
    }

    /**
     * Cambio de contraseña de un usuario relaciona al token dado
     * @param securityToken Cadena con el el token relacionado al usuario
     *                         al que se quiere cambiar la contraseña
     * @param password Cadena con la nueva contraseña de un usuario dado
     * @return Objeto de tipo 'LoginResponse' con el resultado del cambio de contraseña
     */
    @ApiOperation(
            value = "AuthController::restore",
            notes = "Restaura la clave de un usuario")
        @GetMapping(
            value = "/restore-password.json",
            produces = "application/json; charset=utf-8")
        public LoginResponse restorePassword(String password, String securityToken) {
            if(securityToken!=null) {
                return loginService.restorePassword(password, securityToken);
            } else {
                return new LoginResponse("Unknown", false, "Invalid token for Change Password");
            }
        }

    
// Cambia Clave (régular)
    /**
     * Cambio de contraseña requerido por el sistema al
     * ingresar por primera vez en el sistema
     * @param jwt Cadena con el token de autorizacion de un usuario previamente autenticado
     * @param login Objeto de tipo 'Login' que contiene la nueva contraseña del usuario dado
     * @return Objeto de tipo 'LoginResponse' con el resultado del cambio de contraseña
     */
    @ApiOperation(
        value = "AuthController::change-password",
        notes = "Realiza el cambio de la clave de un usuario")
    @PostMapping(
        value = "/change-password.json",
        produces = "application/json; charset=utf-8")
    public LoginResponse changePassword(@RequestHeader("jwt") String jwt, @RequestBody Login login) {
        return loginService.changePassword(login.getUser(), login.getPassword(), jwt);
    }
    
    /**
     * This endpoint receives a string as a parameter sent in a GET request which is a token
     * that we will use to locate a user in our database and (if found) we will redirect the
     * request to a VueJS location.
     * 
     * @param token
     * @return
     */
    @GetMapping(value = "/check.json")
    public ResponseEntity<Void> proceedChangePasswordCheckRedirect(@RequestParam String token) {
    	String sTok = loginService.buildRestoreUrl(token);
        return ResponseEntity.status(HttpStatus.FOUND)
            .location(URI.create(sTok))
            .build();
    }
}
