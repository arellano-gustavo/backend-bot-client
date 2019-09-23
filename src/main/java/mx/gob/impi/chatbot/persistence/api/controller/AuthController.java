package mx.gob.impi.chatbot.persistence.api.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    //@Autowired
    //private UserService usuarioService;
    
//LOGIN
    @ApiOperation(
        value = "AuthController::login",
        notes = "Firma a un usuario al sistema")
    @RequestMapping(
        value = "/login.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public LoginResponse login(String user, String password) {
        return null;
    }

// Recupera clave (forgot)
    @ApiOperation(
        value = "AuthController::request-restore",
        notes = "Solicita la recuperación de la clave de un usuario")
    @RequestMapping(
        value = "/request-restore.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse requestRestore(String mail) {
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
    public MainControllerResponse changePassword(User usr) {
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
    public MainControllerResponse validateToken(String token) {
        return null;
    }
}
