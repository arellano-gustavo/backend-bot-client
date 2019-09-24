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
 * Modulo:      Administracion
 * Tipo:        Controller
 * Autor:       Gustavo Adolfo Arellano Sandoval (GAA)
 * Fecha:       Lunes 23 de Septiembre de 2019
 * Version:     0.0.1
 * .
 * Clase controller de los servicios rest 
 * para la administracion de los usuarios
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import mx.gob.impi.chatbot.persistence.api.model.domain.*;
import mx.gob.impi.chatbot.persistence.api.service.*;

@RestController
@Api(value = "admin")
@RequestMapping(value = "/api/chatbot/admin")
public class AdminController {
    @Autowired
    private UserService usuarioService;
    @Autowired
    private RolService rolService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private UserAreaService userAreaService;
    @Autowired
    private UserRolService userRolService;
    
    // PONGAN ATENCIÓN !!!!
    /*
    2XX --> TODO OK
    3XX --> REDIRECCIÓN
    400 --> ME MANDASTE ALGO QUE NO PUEDO PROCESAR
    500 --> RECIBI ALGO ADECUADO Y CORRECTO, PERO LUEGO TUVE PROBLEMAS INTERNOS Y YA NO LOGRÉ PROCESAR NADA BIEN
    */

//selectAll
    @ApiOperation(
        value = "AdminController::getAllUsers",
        notes = "Regresa un arreglo de todas los usuarios en el sistema")
    @RequestMapping(
        value = "/all-users.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public List<User> getAllUsers() {
        return usuarioService.getAllUsers();
    }
    
    @ApiOperation(
        value = "AdminController::getAllRoles",
        notes = "Regresa un arreglo de todas los roles en el sistema")
    @RequestMapping(
        value = "/all-roles.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public List<Rol> getAllRoles() {
        return rolService.getAll();
    }
    
    @ApiOperation(
        value = "AdminController::getAllAreas",
        notes = "Regresa un arreglo de todas las areas en el sistema")
    @RequestMapping(
        value = "/all-areas.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public List<Area> getAllAreas() {
        return areaService.getAll();
    }
    
//selectById
    @ApiOperation(
        value = "AdminController::getUserById",
        notes = "Regresa un Usuario con base en su ID")
    @RequestMapping(
        value = "/get-user.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public User getUserById(Integer id) {
        return usuarioService.getUserById(id);
    }
    
    @ApiOperation(
        value = "AdminController::getRoleById",
        notes = "Regresa un Rol con base en su ID")
    @RequestMapping(
        value = "/get-rol.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public Rol getRolById(Integer id) {
        return rolService.getRolById(id);
    }
    
    @ApiOperation(
        value = "AdminController::getAreaById",
        notes = "Regresa una Area con base en su ID")
    @RequestMapping(
        value = "/get-area.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public Area getAreaById(Integer id) {
        return areaService.getAreaById(id);
    }
    
// getUserByMail, getUserByToken getUserByName
    @ApiOperation(
        value = "AdminController::getUserByMail",
        notes = "Regresa un Usuario con base en su Mail")
    @RequestMapping(
        value = "/get-user-by-mail.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public User getUserByMail(String mail) {
        return usuarioService.getUserByMail(mail);
    }
    
    @ApiOperation(
        value = "AdminController::getUserByName",
        notes = "Regresa un Usuario con base en su Name")
    @RequestMapping(
        value = "/get-user-by-name.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public User getUserByName(String name) {
        return usuarioService.getUserByName(name);
    }
    
    @ApiOperation(
        value = "AdminController::getUserByToken",
        notes = "Regresa una Usuario con base en su token de cambio de clave")
    @RequestMapping(
            value = "/get-user-by-token.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public User getUserByToken(String token) {
        return usuarioService.getUserByToken(token);
    }
    
//insert
    @ApiOperation(
            value = "AdminController::insert-user",
            notes = "Inserta un usuario al sistema")
        @RequestMapping(
            value = "/insert-user.json",
            method = POST,
            produces = "application/json; charset=utf-8")
        public MainControllerResponse insertUser(User user) {
            return usuarioService.save(user);
        }
    
    @ApiOperation(
        value = "AdminController::insert-rol",
        notes = "Inserta un rol al sistema")
    @RequestMapping(
        value = "/insert-rol.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertRol(Rol rol) {
        return rolService.save(rol);
    }
    
    @ApiOperation(
        value = "AdminController::insert-area",
        notes = "Inserta una area al sistema")
    @RequestMapping(
        value = "/insert-area.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertArea(Area area) {
        return areaService.save(area);
    }
    
//update
    @ApiOperation(
        value = "AdminController::update-area",
        notes = "Actualiza una area al sistema")
    @RequestMapping(
        value = "/update-area.json",
        method = PUT,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse updateArea(Area area) {
        return areaService.update(area);
    }
    
    @ApiOperation(
        value = "AdminController::update-rol",
        notes = "Actualiza una rol al sistema")
    @RequestMapping(
        value = "/update-rol.json",
        method = PUT,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse updateRol(Rol rol) {
        return rolService.update(rol);
    }
    
    @ApiOperation(
        value = "AdminController::update-user",
        notes = "Actualiza una usuario al sistema")
    @RequestMapping(
        value = "/update-user.json",
        method = PUT,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse updateUser(User user) {
        return usuarioService.update(user);
    }
    
//relaciona
    @ApiOperation(
        value = "AdminController::register-user-area",
        notes = "Asigna una area a un usuario")
    @RequestMapping(
        value = "/register-user-area.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertUsuarioArea(Integer idUser, Integer idArea) {
        return userAreaService.save(idUser, idArea);
    }
    
    @ApiOperation(
        value = "AdminController::register-user-rol",
        notes = "Actualiza una rol a un usuario")
    @RequestMapping(
        value = "/register-user-rol.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertUsuarioRol(Integer idUser, Integer idRol) {
        return userRolService.save(idUser, idRol);
    }
    
// elimina relacion
    @ApiOperation(
        value = "AdminController::remove-user-area",
        notes = "Remueve una area a un usuario")
    @RequestMapping(
        value = "/remove-user-area.json",
        method = DELETE,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse removeUsuarioArea(Integer idUser, Integer idArea) {
        return userAreaService.delete(idUser, idArea);
    }
    
    @ApiOperation(
        value = "AdminController::remove-user-rol",
        notes = "Remueve una rol a un usuario")
    @RequestMapping(
        value = "/remove-user-rol.json",
        method = DELETE,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse removeUsuarioRol(Integer idUser, Integer idRol) {
        return userRolService.delete(idUser, idRol);
    }

}
