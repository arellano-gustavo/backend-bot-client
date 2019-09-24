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
    private ChatbotMailSender mail;
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public PersonaPojo[] getAll() {
        //List<EstadoPojo> estados = em.getAll();
        //EstadoPojo estado = estados.get(0);
        User user = new User();
        user.setId(1);
        user.setUsr("goose2");
        user.setPassword("algo2");
        user.setMail("gus2@aol.com");
        user.setCreationDate(new Date());
        user.setExpiredAccount(true);
        user.setBloquedAccount(false);
        user.setExpiredCredential(true);
        user.setDisabled(false);
        user.setFailedAtemptCounter(2);
        user.setBloquedDate(new Date());
        user.setSecretQuestion("secret qQQQQQQ");
        user.setSecretAnswer("secret A");
        user.setSecurityToken("vhjvhjvg");
        user.setSecurityTokenWindow(34567);
        user.setLastAccessDate(new Date());
        user.setLastPasswordUpdateDate(new Date()); 
        
        try{
            String from = "no-reply@kebblar.io";
            String to = "arellano.gustavo@gmail.com";
            String subject = "JavaMailSender";
            String body = "Just-Testing!";
            
            mail.sendMail(from, to, subject, body);
            //mail.addMessage("garellanos@ultrasist.com.nx", "ejemploito", "Hola mundo"); 
            //mail.sendAllMessages();
            // aqui conviene primero checar si no se está violando una regla de la base... p ej:
            /*
            User u1 = userMapper.getUserByName(user.getUsr());
            User u2 = userMapper.getUserByMail(user.getMail());
            User u3 = userMapper.getUserById(user.getId());

            userMapper.update(user);
            */
            User u1 = userMapper.getUserByName("tavo");
            u1.setMail("tavo7@aol.com");
            userMapper.update(u1);
        } catch(RuntimeException rte) {
            //String msg = rte.getMessage();
            String msg = rte.getCause().getLocalizedMessage();
            System.out.println(msg.length()); 
        }
        
        PersonaPojo personas[] = new PersonaPojo[3];
        personas[0] = new PersonaPojo(71, "gus","are____");
        personas[1] = new PersonaPojo(72, "tavo","sabd");
        personas[2] = new PersonaPojo(73, "luis","perez");
        return personas;
    }
}
