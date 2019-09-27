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
 * Modulo:      Persona
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Implementacion del servicio de Persona
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.impi.chatbot.persistence.api.db.EstadoMapper;
import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;
import mx.gob.impi.chatbot.persistence.api.model.estado.EstadoPojo;
import mx.gob.impi.chatbot.persistence.api.model.persona.PersonaPojo;
import mx.gob.impi.chatbot.persistence.support.MailEngine;

/**
 * <p>Descripción:</p>
 * Implementacion del servicio de Persona
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private LoginService loginService;

    
    @Override
    public PersonaPojo[] getAll() {
        System.out.println("pre");
        loginService.login("root", "algo1");
        System.out.println("post");
        
        PersonaPojo personas[] = new PersonaPojo[3];
        personas[0] = new PersonaPojo(71, "gus","are____");
        personas[1] = new PersonaPojo(72, "tavo","sabd");
        personas[2] = new PersonaPojo(73, "luis","perez");
        return personas;
    }
}
