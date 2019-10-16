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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import mx.gob.impi.chatbot.persistence.api.model.domain.*;
import mx.gob.impi.chatbot.persistence.api.service.*;

/**
 * <p>Descripción:</p>
 * Implementacion del controlador de administracion
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
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
    2XX --> TODITITITO OK
    3XX --> REDIRECCIÓN
    400 --> ME MANDASTE ALGO QUE NO PUEDO PROCESAR
    500 --> RECIBI ALGO ADECUADO Y CORRECTO, PERO LUEGO TUVE PROBLEMAS INTERNOS Y YA NO LOGRÉ PROCESAR NADA BIEN
    */

    /**
     * Regresa una lista de todos los usuarios en el sistema 
     * debidamente paginados con base en el payload de 
     * request que determina el tamaño de la página, la 
     * longitud de la página, el campo por el que se va a 
     * ordenar y si el orden es ascendente o descendente.
     * <br/><br/>
     * En caso de que los parámetros proporcionados <b><i><label style='color:red;'>excedan</label><i></b> las 
     * dimensiones de la lista real de datos, este método es 
     * capaz de ajustar lo necesario para que la lista resultante 
     * sea suceptible de ser manipulada adecuadamente.
     * 
     * @param paginationParams Parámetros de paginación
     * 
     * @return Lista paginada de usuarios acorde a los parámetros de paginación dados.
     */
    @ApiOperation(
            value = "AdminController::getAllUsers",
            notes = "Regresa una lista de todos los usuarios en el sistema "
            		+ "debidamente paginados con base en el payload de "
            		+ "request que determina el tamaño de la página, la "
            		+ "longitud de la página, el campo por el que se va a "
            		+ "ordenar y si el orden es ascendente o descendente."
            		+ "<br/><br/>"
            		+ "En el caso de que los parámetros proporcionados "
            		+ "<b><i><label style='color:red;'>excedan</label><i></b> las "
            		+ "dimensiones de la lista real de datos, este método es "
            		+ "capaz de ajustar lo necesario para que la lista resultante "
            		+ "sea suceptible de ser manipulada adecuadamente.")
    @PostMapping( 
        value = "/all-users.json",
        produces = "application/json; charset=utf-8")
    public List<User> getAllUsers(@RequestBody PageBoundaries paginationParams) {
        return usuarioService.getAllUsers(paginationParams);
    }
    
    /**
     * Obtiene una lista de roles registrados en el sistema
     * @return Lista de tipo 'List<Rol>' con los roles del sistema
     */
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

    /**
     * Obtiene  una lista de roles registrado en el sistema
     * @return Lista de tipo 'List<Area>' con las areas del sistema
     */
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
    /**
     * Obtiene un usuario por medio de su id
     * @param id Identificador del usuario
     * @return Objeto de tipo 'User' relacionado a un identificador dado
     */
    @ApiOperation(
        value = "AdminController::getUserById",
        notes = "Regresa un Usuario con base en su ID")
    @RequestMapping(
        value = "/get-user.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public User getUserById(@RequestParam  int id) {
        return usuarioService.findUserById(id);
    }

    /**
     * Obtiene un rol por medio de su id
     * @param id Identificador del rol
     * @return Objeto de tipo 'Rol' relacionado a un identificador dado
     */
    @ApiOperation(
        value = "AdminController::getRoleById",
        notes = "Regresa un Rol con base en su ID")
    @RequestMapping(
        value = "/get-rol.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public Rol getRolById(@RequestParam  int id) {
        return rolService.getRolById(id);
    }

    /**
     * Obtiene un area por medio de su id
     * @param id Identificador del area
     * @return Objeto de tipo 'Area' relacionada a un identificador dado
     */
    @ApiOperation(
        value = "AdminController::getAreaById",
        notes = "Regresa una Area con base en su ID")
    @RequestMapping(
        value = "/get-area.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public Area getAreaById(@RequestParam  int id) {
        return areaService.getAreaById(id);
    }

// getUserByMail, getUserByToken getUserByName
    /**
     * Obtiene un usuario por medio de su mail
     * @param mail Cadena con el mail ingresado
     * @return Objeto de tipo 'User' relacionado con el mail dado
     */
    @ApiOperation(
        value = "AdminController::getUserByMail",
        notes = "Regresa un Usuario con base en su Mail")
    @RequestMapping(
        value = "/get-user-by-mail.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public User getUserByMail(@RequestParam  String mail) {
        return usuarioService.findUserByMail(mail);
    }

    /**
     * Obtiene un usuario por medio de su nombre.
     * @param name Cadena con el nombre de un usuario
     * @return Objeto de tipo 'User' relacionado con el name dado
     */
    @ApiOperation(
        value = "AdminController::getUserByName",
        notes = "Regresa un Usuario con base en su Name")
    @GetMapping(
        value = "/get-user-by-name.json",
        produces = "application/json; charset=utf-8")
    public User getUserByName(@RequestParam String name) {
        return usuarioService.findUserByName(name);
    }

    /**
     * Obtiene un usuario por medio de un token
     * @param token Cadena con el token asignado a un usuario
     * @return Objeto de tipo 'User' relacionado con el token dado
     */
    @ApiOperation(
        value = "AdminController::getUserByToken",
        notes = "Regresa una Usuario con base en su token de cambio de clave")
    @GetMapping(
        value = "/get-user-by-token.json",
        produces = "application/json; charset=utf-8")
    public User getUserByToken(@RequestParam String token) {
        return usuarioService.findUserByToken(token);
    }

//insert
    /**
     * Ingresa un nuevo usuario en el sistema.
     * 
     * @param user Objeto de tipo 'User' a registrar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la insercion
     */
    @ApiOperation(
            value = "AdminController::insert-user",
            notes = "Inserta un usuario al sistema.\nInforma de las posibles violaciones de integridad como llaves primarias duplicadas o indices únicos duplicados.")
        @PostMapping(
            value = "/insert-user.json",
            produces = "application/json; charset=utf-8")
        public MainControllerResponse insertUser(@RequestBody User user) {
            return usuarioService.save(user);
        }

    /**
     * Ingresa un rol en el sistema
     * @param rol Objeto de tipo 'Rol' a registrar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la insercion
     */
    @ApiOperation(
        value = "AdminController::insert-rol",
        notes = "Inserta un rol al sistema")
    @RequestMapping(
        value = "/insert-rol.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertRol(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    /**
     * Ingresa un area en el sistema
     * @param area Objeto de tipo 'Area' a registrar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la insercion
     */
    @ApiOperation(
        value = "AdminController::insert-area",
        notes = "Inserta una area al sistema")
    @RequestMapping(
        value = "/insert-area.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertArea(@RequestBody Area area) {
        return areaService.save(area);
    }

//update
    /**
     * Actualiza un area regustrada en el sistema
     * @param area Objeto de tipo 'Area' a actualizar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la actualizacion
     */
    @ApiOperation(
        value = "AdminController::update-area",
        notes = "Actualiza una area al sistema")
    @RequestMapping(
        value = "/update-area.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse updateArea(@RequestBody Area area) {
        return areaService.update(area);
    }

    /**
     * Actualiza un rol registrado en el sistema
     * @param rol Objeto de tipo 'Rol' a actualizar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la actualizacion
     */
    @ApiOperation(
        value = "AdminController::update-rol",
        notes = "Actualiza una rol al sistema")
    @RequestMapping(
        value = "/update-rol.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse updateRol(@RequestBody  Rol rol) {
        return rolService.update(rol);
    }

    /**
     * Actualiza un usuario en el sistema
     * @param user Objeto de tipo 'User' a actulizar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la actualizacion
     */
    @ApiOperation(
        value = "AdminController::update-user",
        notes = "Actualiza una usuario al sistema")
    @RequestMapping(
        value = "/update-user.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse updateUser(@RequestBody User user) {
        return usuarioService.update(user);
    }

//relaciona
    /**
     * Registra la relacion entre un usuario y un area
     * @param userArea Objeto con la relacion entre el usuario y un area
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la insercion
     */
    @ApiOperation(
        value = "AdminController::register-user-area",
        notes = "Asigna una area a un usuario")
    @RequestMapping(
        value = "/register-user-area.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertUsuarioArea(@RequestBody UserArea userArea) {
        return userAreaService.save(userArea.getIdUser(), userArea.getIdArea());
    }

    /**
     * Registra la relacion entre un usuario y un rol
     * @param userRol Objeto con la relacion entre el usuario y un rol
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la insercion
     */
    @ApiOperation(
        value = "AdminController::register-user-rol",
        notes = "Actualiza una rol a un usuario")
    @RequestMapping(
        value = "/register-user-rol.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertUsuarioRol(@RequestBody UserRol userRol) {
        return userRolService.save(userRol.getIdUser(), userRol.getIdRol());
    }

// elimina relacion
    /**
     * Elimina la relacion entre un usuario y un area
     * @param idUser Identificador del usuario
     * @param idArea Identificador del area
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la eliminacion
     */
    @ApiOperation(
        value = "AdminController::remove-user-area",
        notes = "Remueve una area a un usuario")
    @RequestMapping(
        value = "/remove-user-area.json",
        method = DELETE,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse removeUsuarioArea(@RequestBody Integer idUser, @RequestBody Integer idArea) {
        return userAreaService.delete(idUser, idArea);
    }

    /**
     * Elimina la relacion entre un usuario y un rol
     * @param idUser Identificador del usuario
     * @param idRol Identificador del rol
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la eliminacion
     */
    @ApiOperation(
        value = "AdminController::remove-user-rol",
        notes = "Remueve una rol a un usuario")
    @RequestMapping(
        value = "/remove-user-rol.json",
        method = DELETE,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse removeUsuarioRol(@RequestBody Integer idUser, @RequestBody Integer idRol) {
        return userRolService.delete(idUser, idRol);
    }


    /**
     * Obtiene un usuario desde un web service que nos ha dado el cliente, por medio de su id.
     * Si el ID no existe, regresa un usuario vacio.
     *
     * @param id Identificador del empleado del impi
     *
     * @return Objeto de tipo 'User' relacionado a un identificador dado
     */
    @ApiOperation(
        value = "AdminController::loadUserFromWs",
        notes = "Regresa un Usuario desde un WS del IMPI con base en su ID de Empleado con varios datos precargados, aunque no todos")
    @RequestMapping(
        value = "/load-user-from-ws.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public Empleado loadUserFromWs(@RequestParam  int id) {
        Empleado u = usuarioService.loadUserFromWs(id);
        if (u!=null) {
        	return u;
        }
        return new Empleado();
    }
}
