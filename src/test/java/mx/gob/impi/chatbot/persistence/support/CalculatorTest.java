package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

public class CalculatorTest {
    private static final Logger logger = Logger.getLogger(CalculatorTest.class);
    @Test
    public void testSuma() {
        Calculator calc = new Calculator();
        logger.info("Probando el método estático 'suma' de FileUtils");
        int result = calc.divide(2, 0);
        assertTrue("Este es un mensaje", result==0);
    }
}
