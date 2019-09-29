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

@RunWith(SpringRunner.class)
@SpringBootTest 
public class MybatisTest {
    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
    
    @Autowired
    private UserMapper userMapper;

    //@InjectMocks
    @Autowired
    private CustomDigestEncoderService customDigestEncoderService;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        List<User> all = userMapper.getAll();
        /* */
        User u1 = userMapper.getUserById(1);
        logger.info("u1:"+u1.getUsr());
        User u2 = userMapper.getUserByMail("tavo7@aol.com");
        logger.info("u2:"+u2.getUsr());
        User u3 = userMapper.getUserByName("root");
        logger.info("u3:"+u3.getMail());
        //userMapper.getUserBySecurityToken("");
        /* */
        for(User u : all) {
            logger.info("User: "+u.toString());
        }
        
        /** /
        u1.setUsr("sexto");
        String pass = customDigestEncoderService.digest("hola", u1.getUsr());
        u1.setPassword(pass);
        u1.setMail("goose06@aol.com");
        u1.setFailedAtemptCounter(2);
        /**/

        u1.setFailedAtemptCounter(9);
        //userMapper.fullInsert(u1);
        
        userMapper.updateFailure(u1);
        assert(true);
    }

}
