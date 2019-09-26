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

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import mx.gob.impi.chatbot.persistence.api.model.domain.*;
import mx.gob.impi.chatbot.persistence.api.service.*;

@RestController
@Api(value = "auth")
@RequestMapping(value = "/api/chatbot/auth")
public class AuthController {
	@Autowired
    private LoginService loginService;
    
//LOGIN
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
    @ApiOperation(
        value = "AuthController::request-restore",
        notes = "Solicita la recuperación de la clave de un usuario")
    @RequestMapping(
        value = "/request-restore.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse requestRestore(@RequestBody String mail) {
        return null;
    }

// Cambia Clave (régular)
    @ApiOperation(
        value = "AuthController::change-password",
        notes = "Realiza el cambio de la clave de un usuario")
    @RequestMapping(
        value = "/change-password.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse changePassword(@RequestBody Login login) {
        return null;
    }
// valida token de seguridad
    @ApiOperation(
        value = "AuthController::validate-token",
        notes = "Valida la cadena que se envia para cambiar una clave")
    @RequestMapping(
        value = "/validate-token.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse validateToken(@RequestBody String token) {
        return null;
    }
}
