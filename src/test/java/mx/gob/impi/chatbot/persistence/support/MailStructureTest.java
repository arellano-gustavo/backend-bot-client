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
 * Modulo:      MailStructureTest
 * Tipo:        CLASE
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 25 de Septiembre de 2019 (09_47)
 * Version:     1.0-SNAPSHOT
 * .
 * Test de MailValidator
 *
 * Historia:    .
 *              20190925_0947 Creación de la prueba unitaria
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar las direcciones de correo
 * electronico mediante 'MailValidator'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
// Include my Ref, please:
// https://howtodoinjava.com/regex/java-regex-validate-email-address/
public class MailStructureTest {
    private static final Logger logger = LoggerFactory.getLogger(MailStructureTest.class);

    private MailValidator me = new MailValidator();

    /**
     * Prueba la validacion de la estructura de las
     * direcciones de correo electronico
     */
    @Test
    public void pba(){
        logger.info("Running my test for Mail Structure ******************");
        List<String> emails = new ArrayList<>();
        emails.add("user@domain.com");
        emails.add("user@domain.co.in");
        emails.add("user.name@domain.com");
        emails.add("user_name@domain.com");
        emails.add("username@yahoo.corporate.in");

        //Invalid emails
        emails.add(".username@yahoo.com");
        emails.add("username@yahoo.com.");
        emails.add("username@yahoo..com");
        emails.add("username@yahoo.c");
        emails.add("username@yahoo.corporate");

        assertTrue(me.validateMailStructure(emails.get(0)));

    }
}
