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
 * Paquete:     mx.gob.impi.chatbot.persistence.config
 * Modulo:      DataConfig
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Implementacion de la configuracion de DataSource
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.*;
import org.jasypt.util.text.BasicTextEncryptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * <p>Descripción:</p>
 * Configuracion del DataSource
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Configuration
@MapperScan("mx.gob.impi.chatbot.persistence.api.db")
public class DataConfig {

    // https://www.baeldung.com/spring-value-annotation
    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;
    
    @Value("${db.url}")
    private String url;
    
    @Value("${db.driver}")
    private String driver;
    
    private final static Logger logger = LoggerFactory.getLogger(DataConfig.class);
    
    private Properties properties = new Properties();
    
    /**
     * Constructor default de la clase.
     */
    public DataConfig() {
        super();
        InputStream stream = 
                DataConfig
                .class
                .getClassLoader()
                .getResourceAsStream("c3p0.properties");
        try {
            properties.load(stream);
            logger.info("Properties have been loaded"); 
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     * Regresa la propiedad solicitada
     * @param name Cadena con el nombre de la propiedad
     *             que se quiere recuperar
     * @return Cadena con la propiedad recuperada
     */
    private String getProp(String name) {
        String data = properties.get("c3p0."+name).toString();
        if("password".equals(name) && data.startsWith("ENC(")) {
            BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword(name);
            //String encr = textEncryptor.encrypt("gustavo");
            //System.out.println(encr); 
            String pass = data.substring(4, data.length()-1);
            String plainPassword = textEncryptor.decrypt(pass);
            return plainPassword;
        }
        return data;
    }
    
    /**
     * Crea pool de conexiones
     * @return Regresa el data source
     */
    @Bean
    public DataSource dataSource(){
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass( getProp("driverClass") );
            cpds.setJdbcUrl    ( getProp("jdbcUrl") );
            cpds.setUser       ( getProp("user") );
            cpds.setPassword   ( getProp("password") );
            return cpds;
        } catch(Exception e) {
            logger.info("No fué posible crear un datasource con C3P0: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Administrador de transaciones de base de datos
     * @return Objeto de tipo 'DataSourceTransactionManager'
     *         para administrar las transaciones de base de datos
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * Fabrica de sesiones de base de datos
     * @return Objeto de tipo 'SqlSessionFactoryBean' para
     *         conectarse a la base de datos
     * @throws Exception Objeto con la excepcion al intentar
     *                   crear la sesion de base de datos
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("mx.gob.impi.chatbot.persistence.api.db2");
        return sessionFactory;
    }
}
