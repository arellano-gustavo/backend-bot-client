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
 * Modulo:      CustomDigestEncoderTest
 * Tipo:        CLASE 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Miercoles 25 de Septiembre de 2019 (18_17)
 * Version:     1.0-SNAPSHOT
 * .
 * Test de CustomDigestEncoderTest
 *
 * Historia:    .
 *              20190925_1817 Creación de la prueba unitaria
 *
 *
 */package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import org.slf4j.*;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.gob.impi.chatbot.persistence.api.service.CustomDigestEncoderService;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar la conexion el servicio 'CustomDigestEncoderService'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest 
public class CustomDigestEncoderTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomDigestEncoderTest.class);
    
    // Load the 'real' bean, instead a mock (we need to combine 2 annotations)
    //@InjectMocks
    @Autowired
    private CustomDigestEncoderService customDigestEncoderService;
    
    /**
     * Prueba los metodos de creacion del hash de una cadena
     */
    @Test
    public void testDigest() {
        String message = getHashedSaltedPassword("algo", "tavo");
        logger.info(message);
        assertTrue("No coincide el hash", "e837610ac8f8c3b51ca980bccf60c6411ba63bc50f01df5751d81cde1955b29c".equals(message));

        message = getHashedSaltedPassword("algo", "root");
        logger.info(message);
        assertTrue("No coincide el hash", "628e854b4b74f508267228648293fc880164c46c1113b0e9643b81079d3ccd08".equals(message));
    }
    
    private String getHashedSaltedPassword(String password, String user) {
        return customDigestEncoderService.digest(password, user);
    }
}
