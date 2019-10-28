package mx.qbits.kepler.lco.service;

import org.apache.log4j.Logger;
import org.junit.Test;

import mx.gob.impi.chatbot.engine.service.TextClientSrv;
import mx.gob.impi.chatbot.engine.service.TextClientSrvImpl;
import mx.gob.impi.chatbot.engine.utils.Support;

import static org.junit.Assert.*;
import java.util.Properties;
import java.util.Set;
import mx.gob.impi.chatbot.engine.model.ChatbotRequest;

/**
 *
 * @author Administrador
 */
public class TestTextClientSrvImpl {
    private final static Logger logger = Logger.getLogger(TestTextClientSrvImpl.class);
    
    /**
     *
     */
    @Test
    public void pba1() {
        TextClientSrv tcs = new TextClientSrvImpl();
        ChatbotRequest objReq = new ChatbotRequest();
        objReq.setArea("1");
        objReq.setChallenge("Hola");
        objReq.setUid("1");
        String response = tcs.response(objReq);
        logger.info(response);
        assertTrue(true); 
    }
    
    /**
     *
     */
    @Test
    public void pba2() {
        String ch = Support.getChallenge("{'abc':'def'}");
        boolean exp = ch.equals("def");
        System.out.println(exp+"<-------------------");
        assertTrue(exp);
    }
    
    /**
     *
     */
    @Test
    public void pba3() {
        Properties mapa = Support.loadProps();
        Set<Object> keySet = mapa.keySet();
        for(Object key : keySet) {
            String value = mapa.get(key.toString()).toString();
            System.out.println(value);
        }
    }

}
