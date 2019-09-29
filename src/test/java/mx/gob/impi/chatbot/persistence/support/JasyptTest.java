package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest 
public class JasyptTest {
    private final static Logger logger = LoggerFactory.getLogger(JasyptTest.class);
    
    @Value("${welcome.message}")
    private String welcome;

    @Test
    public void encryptorTest(){
        logger.info("-------------------------------------------->"+welcome+"<---------------------");
        assertTrue("No coincide el password", "Password@1".equals(welcome));
    }
    
    @Test
    public void encript() {
        String jasyptPassword = "jasypt-password";
        String cadenaOculta ="Cadena a ocultar";
        
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(jasyptPassword);
        
        String myEncryptedText = textEncryptor.encrypt(cadenaOculta);
        logger.info("Cadena encriptada:"+myEncryptedText);
        
        String plainText = textEncryptor.decrypt(myEncryptedText);
        logger.info("Cadena encriptada:"+plainText);
        
        assertTrue("Las cadenas no fueros iguales", cadenaOculta.equals(plainText));
    }
}
