package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

public class CustomDigestEncoderTest {
    private static final Logger logger = Logger.getLogger(CustomDigestEncoderTest.class);
    @Test
    public void testDigest() {
        CustomDigestEncoder cde = new CustomDigestEncoder();
        String message = cde.digest("gus", "tavo");
        logger.info(message);
        assertTrue("No coincide el hash", "67daae98ed0c612857a716202f463356ffcf1a018ce140ab4a4bebc8eb274e6d".equals(message));
    }
}
