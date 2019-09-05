/*
 *    Proyecto: Chatbot Ultra
 *       Fecha: 05/09/2019
 *       Autor: David Corza
 * Descripción: test de sesrvico de administración del chatbot
 */
package mx.gob.impi.chatbot.engine.service;

import mx.gob.impi.chatbot.engine.model.login.LogInRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class TextClientSrvAdminImplIT {
    
    /**
     *
     */
    public TextClientSrvAdminImplIT() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of response method, of class TextClientSrvAdminImpl.
     */
    @Test
    public void testResponse() {
        System.out.println("response");
        LogInRequest challenge = new LogInRequest();
        challenge.setEmail("prueba@prueba.com");
        challenge.setContra("1234");
        TextClientSrvAdminImpl instance = new TextClientSrvAdminImpl();
        String expResult = "";
        String result = instance.response(challenge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("fallo");
    }
    
}
