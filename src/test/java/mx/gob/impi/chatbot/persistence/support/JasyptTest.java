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
 * Modulo:      JasyptTest
 * Tipo:        CLASE
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 27 de Septiembre de 2019 (19_26)
 * Version:     1.0-SNAPSHOT
 * .
 * Test de JasyptTest
 *
 * Historia:    .
 *              20190927_1926 Creación de la prueba unitaria
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.assertTrue;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar el resultado de 'BasicTextEncryptor'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTest {
    private final static Logger logger = LoggerFactory.getLogger(JasyptTest.class);

    @Value("${welcome.message}")
    private String welcome;

    @Test
    public void encryptorTest(){
        logger.info("WELCOME: -------------------------------------------->"+welcome+"<---------------------");
        assertTrue("No coincide el password", "Password@1".equals(welcome));
    }

    @Test
    public void encript() {
        String jasyptPassword = "password";
        String cadenaOculta ="UrbiEtOrbi1";

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(jasyptPassword);

        String myEncryptedText = textEncryptor.encrypt(cadenaOculta);
        logger.info("Cadena encriptada:"+myEncryptedText);

        String plainText = textEncryptor.decrypt(myEncryptedText);
        logger.info("Cadena des-encriptada:"+plainText);

        assertTrue("Las cadenas no fueros iguales", cadenaOculta.equals(plainText));
    }
}
