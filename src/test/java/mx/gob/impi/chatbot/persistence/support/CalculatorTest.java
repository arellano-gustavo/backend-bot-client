package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import java.io.File;

import org.slf4j.*;
import org.junit.Test;

public class CalculatorTest {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorTest.class);
    
    @Test
    public void testSuma() {
        Calculator calc = new Calculator();
        logger.info("Probando el método estático 'suma' de FileUtils");
        //int result1 = calc.divide(2, 0);
        //assertTrue("Este es un mensaje de error 1", result1==0);
        
        int result2 = calc.divide(2, 2);
        assertTrue("Este es un mensaje de error 2", result2==1);
        
        int result3 = calc.divide(1, 2);
        assertTrue("Este es un mensaje de error 2", result3==0);
    }
    @Test
    public void ok() {
    	File file = new File(".");
    	String path = file.getAbsolutePath();
    	System.out.println(path+"/src/main/resources/emailTemplate.txt");
    	// /Users/garellano/development/code/impi-chatbot-admin/   
    	// src/main/resources/emailTemplate.txt
    	// file.getAbsolutePath() + "/src/main/resources/emailTemplate.txt"
    }
}
