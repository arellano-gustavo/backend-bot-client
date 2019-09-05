/*
 *    Proyecto: Chatbot Ultra
 *       Fecha: 05/09/2019
 *       Autor: David Corza
 * Descripción: test de sesrvico de administración del chatbot
 */
package mx.qbits.kepler.lco.service;

import mx.gob.impi.chatbot.engine.model.login.LogInRequest;
import mx.gob.impi.chatbot.engine.service.TextClientSrvAdmin;
import mx.gob.impi.chatbot.engine.service.TextClientSrvAdminImpl;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * test de sesrvico de administración del chatbot
 * @author David Corza
 */
public class TestTextClientSrvAdminImpl {
    private final static Logger logger = Logger.getLogger(TestTextClientSrvImpl.class);
    
    /**
     *
     */
    @Test
    public void pba1() {
        TextClientSrvAdmin tcs = new TextClientSrvAdminImpl();        
       LogInRequest obj = new LogInRequest();
       obj.setEmail("prueba@prueba.com");
       obj.setContra("1234");
        String response = tcs.response(obj);
        logger.info(response);
        assertTrue(true); 
    }
}
