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
 * Modulo:      MybatisTest
 * Tipo:        CLASE
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 27 de Septiembre de 2019 (18_11)
 * Version:     1.0-SNAPSHOT
 * .
 * Test de UserMapper
 *
 * Historia:    .
 *              20190927_1811 Creación de la prueba unitaria
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;
import mx.gob.impi.chatbot.persistence.api.service.CustomDigestEncoderService;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar el mapper de 'UserMapper'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomDigestEncoderService customDigestEncoderService;

    /**
     * Prueba los metodos de recuperacion de usuario
     */
    @Test
    public void whenFindByName_thenReturnEmployee() {
        User uu = userMapper.getUserByMail("arellano.gustavo@gmail.com");
        if(uu!=null) {
            logger.info(uu.getUsr());
        }

        List<User> all = userMapper.getAll();
        /* */
        User u1 = userMapper.getUserById(1);
        logger.info("u1:"+u1.getUsr());
        User u2 = userMapper.getUserByMail("arellano.gustavo@gmail.com");
        logger.info("u2:"+u2.getUsr());
        User u3 = userMapper.getUserByName("root");
        logger.info("u3:"+u3.getMail());
        //userMapper.getUserBySecurityToken("");
        /* */
        for(User u : all) {
            logger.info("User: "+u.toString());
        }

        /**/
        u1.setUsr("sexto");
        String pass = customDigestEncoderService.digest("hola", u1.getUsr());
        u1.setPassword(pass);
        u1.setMail("goose06@aol.com");
        u1.setFailedAtemptCounter(2);
        /**/

        //u1.setFailedAtemptCounter(2);
        //userMapper.fullInsert(u1);

        userMapper.updateFailure(u1);
        assert(true);
    }

}
