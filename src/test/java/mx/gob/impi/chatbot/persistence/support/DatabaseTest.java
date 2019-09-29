package mx.gob.impi.chatbot.persistence.support;

import java.sql.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest 
public class DatabaseTest {
    private final static Logger logger = LoggerFactory.getLogger(DatabaseTest.class);
    
    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;
    
    @Value("${db.url}")
    private String url;
    
    @Value("${db.driver}")
    private String driver;
    
    @Test
    public void connect() {
       Connection conn = null;
       try {
          Class.forName(this.driver).newInstance();
          conn = DriverManager.getConnection(this.url, this.username, this.password);
          if (conn != null) {
             logger.info("Conexión a base de datos "+url+" ... Ok");
             conn.close();
             assert(true);
          }
       } catch(Exception ex) {
          System.out.println(ex);
          assert(false);
       }
    }
}
