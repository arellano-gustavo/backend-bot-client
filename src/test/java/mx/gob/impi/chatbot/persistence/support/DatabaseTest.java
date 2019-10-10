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

import java.sql.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar la conexion a la base de datos
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
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

    /**
     * Prueba la conexion a la base de datos
     */
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
