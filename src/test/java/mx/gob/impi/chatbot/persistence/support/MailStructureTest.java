package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import java.util.*;


import org.slf4j.*;
import org.junit.Test;

// Include my Ref, please:
// https://howtodoinjava.com/regex/java-regex-validate-email-address/
public class MailStructureTest {
    private static final Logger logger = LoggerFactory.getLogger(MailStructureTest.class);
    
    private MailValidator me = new MailValidator();
    
    @Test
    public void pba(){
        logger.info("Running my test");
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
