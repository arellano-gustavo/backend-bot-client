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
 * Modulo:      DatabaseTest
 * Tipo:        CLASE
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Miercoles 25 de Septiembre de 2019 (17_52)
 * Version:     1.0-SNAPSHOT
 * .
 * Test de conexion a la base de datos
 *
 * Historia:    .
 *              20190925_1752 Creación de la prueba unitaria
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * <p>Descripción:</p>
 * Clase de pruebas para validar la conexion a la base de datos
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class PlaneDatabaseTest {

    public static void main(String...argv) {
    	
        String username="sa";
        String password="gustavo";
        String url="jdbc:h2:tcp://api.kebblar.capital:1521/h2-data";
        String driver="org.h2.Driver";
    	
        /* * /
        username = "chatbot";
        password = "chatbot00";
        url = "jdbc:oracle:thin:@192.168.10.146:1521/impic";
        driver = "oracle.jdbc.driver.OracleDriver";
        /**/
    	
       Connection conn = null;
       try {
          Class.forName(driver).newInstance();
          conn = DriverManager.getConnection(url, username, password);
          if (conn != null) {
             System.out.println("Conexión a base de datos "+url+" ... Ok");
             Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery("select * from users");
             while(result.next()) {
            	 String mail = result.getString("mail");
            	 System.out.println(mail);
             }
             result.close();
             stmt.close();
             conn.close();
             assert(true);
          }
       } catch(Exception ex) {
          System.out.println(ex);
          assert(false);
       }
    }
}
