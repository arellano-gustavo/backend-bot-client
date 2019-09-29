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
 * Modulo:      Persona
 * Tipo:        Controller
 * Autor:       Gustavo Adolfo Arellano Sandoval (GAA)
 * Fecha:       Lunes 23 de Septiembre de 2019
 * Version:     0.0.1
 * .
 * Clase controller de los servicios rest 
 * para la administracion de las personas
 * registradas
 *
 * Historia:    .
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.gob.impi.chatbot.persistence.api.model.persona.PersonaPojo;
import mx.gob.impi.chatbot.persistence.api.service.PersonaService;

@RestController
@Api(value = "persona")
@RequestMapping(value = "/api/personas")
public class PersonaController {
    private final static Logger logger = LoggerFactory.getLogger(PersonaController.class);
    
    @Autowired
    private PersonaService personaService;

    @ApiOperation(
            value = "PersonaController::getAll",
            notes = "Regresa un arreglo de todas las personas en el sistema")
        @RequestMapping(
            value = "/all.json",
            method = GET,
            produces = "application/json; charset=utf-8")
        public PersonaPojo[] getAll() {
            logger.info("Calling PersonaController::getAll");
            return personaService.getAll();
        }
}
