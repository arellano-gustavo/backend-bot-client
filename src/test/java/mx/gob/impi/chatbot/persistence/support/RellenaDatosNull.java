package mx.gob.impi.chatbot.persistence.support;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.PageBoundaries;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;
import mx.gob.impi.chatbot.persistence.api.service.CustomDigestEncoderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RellenaDatosNull {
    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomDigestEncoderService customDigestEncoderService;

    
    /*
    public void rellena() {
    	PageBoundaries pb = new PageBoundaries(0, 0, "id", true);
    	List<User> lista = userMapper.getAll(pb);
    	for(User u : lista) {
    		String usr = "x"+System.currentTimeMillis()+"x";
    		if(u.getId()==null) u.setId(1);
    		if(u.isBloquedAccount()) u.setBloquedAccount(false);
    		if(u.isDisabled()) u.setDisabled(false);
    		if(u.isExpiredAccount()) u.setExpiredAccount(false);
    		if(u.isExpiredCredential()) u.setExpiredCredential(false);
    		if(u.getBloquedDate()==null) u.setBloquedDate(new Date(0));
    		if(u.getCreationDate()==null) u.setCreationDate(new Date(0));
    		if(u.getFailedAtemptCounter()>0) u.setFailedAtemptCounter(0);
    		if(u.getFullName()==null) u.setFullName("Provisional " + System.currentTimeMillis());
    		if(u.getLastAccessDate()==null) u.setLastAccessDate(new Date(System.currentTimeMillis()));
    		if(u.getLastPasswordUpdateDate()==null) u.setLastPasswordUpdateDate(new Date(System.currentTimeMillis()));
    		if(u.getMail()==null) u.setMail("correo_"+System.currentTimeMillis()+"_ok@aol.com");
    		String pass = customDigestEncoderService.digest(usr, usr);
    		if(u.getPassword()==null) u.setPassword(pass);
    		if(u.getSecretAnswer()==null) u.setSecretAnswer("x");
    		if(u.getSecretQuestion()==null) u.setSecretQuestion("x");
    		if(u.getSecurityToken()==null) u.setSecurityToken("xyz");
    		if(u.getUsr()==null) u.setUsr(usr);
    		logger.info("Actualizando el Usuario: "+u.getUsr());
    		userMapper.update(u);
    	}
    	List<User> lista2 = userMapper.getAll(pb);
    	for(User u : lista2) {
    		logger.info(u.getFullName());
    	}
    	assert(true);
    }
    */
    @Test
    public void ok() {
        	int[] data =
        			{33,
        			34,
        			35,
        			36,
        			44,
        			45,
        			46,
        			47,
        			48,
        			49,
        			50,
        			51,
        			105,
        			107,
        			112,
        			116,
        			123,
        			131,
        			152,
        			153,
        			154,
        			155,
        			156,
        			164,
        			187};
        	for(int i=0; i<data.length; i++)  {
        		User u = userMapper.getUserById(data[i]);
        		int nuevo = data[i] + 1373;
        		u.setUsr(nuevo+"");
        		String password = customDigestEncoderService.digest("clave", nuevo+"");
				u.setPassword(password);
				u.setMail("usuario_"+nuevo+"@gmail.com");
				userMapper.update(u);
        	}
    }
}
