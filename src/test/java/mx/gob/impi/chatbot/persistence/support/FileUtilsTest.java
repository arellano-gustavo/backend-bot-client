package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

public class FileUtilsTest {
    private static final Logger logger = Logger.getLogger(FileUtilsTest.class);
    @Test
    public void testSuma() {
        logger.info("Probando el método estático 'suma' de FileUtils");
        int result = FileUtils.divide(2, 2);
        assertTrue("Este es un mensaje", result==1);
    }
}
