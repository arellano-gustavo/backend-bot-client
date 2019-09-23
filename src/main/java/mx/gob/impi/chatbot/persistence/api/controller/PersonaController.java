package mx.gob.impi.chatbot.persistence.api.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.persona.PersonaPojo;
import mx.gob.impi.chatbot.persistence.api.service.PersonaService;

@RestController
@Api(value = "persona")
@RequestMapping(value = "/api/personas")
public class PersonaController {
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
            return personaService.getAll();
        }
}
