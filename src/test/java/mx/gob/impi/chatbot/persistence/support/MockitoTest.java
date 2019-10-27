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
 * Modulo:      MockitoTest
 * Tipo:        CLASE
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 27 de Septiembre de 2019 (19_24)
 * Version:     1.0-SNAPSHOT
 * .
 * Test de UserService
 *
 * Historia:    .
 *              20190927_1924 Creación de la prueba unitaria
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import mx.gob.impi.chatbot.persistence.api.model.domain.User;
import mx.gob.impi.chatbot.persistence.api.service.UserService;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar los servicios de  'UserService'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoTest {
	private static final Logger logger = LoggerFactory.getLogger(MockitoTest.class);
	
    @MockBean
    private UserService userService;

    @Before
    public void setUp() {
    	logger.info("Before the test");
        User gus = new User("goose", "xyz", "gus@hotmail.com");
        Mockito.when(userService.findUserByName("goose"))
          .thenReturn(gus);
    }

    @Test
    public void whenFindByName_thenReturnEmployee() {
    	logger.info("Actual test");
        // given
        User user = userService.findUserByName("goose");
        // and
        User tavo = new User("goose", "xyz", "gus@aol.com");
        // when
        String password = user.getPassword();
        // then
        assertTrue("Error al comprobar el password", tavo.getPassword().equals(password));
        // and
        assertFalse("Error al comprobar el password", !tavo.getPassword().equals(password));
    }

}
