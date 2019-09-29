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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.*;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

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
    
    @Bean
    public DataSource dataSource(){
        String driver   = properties.get("driverClass").toString();
        String user     = properties.get("user").toString();
        String password = properties.get("password").toString();
        String url      = properties.get("jdbcUrl").toString();
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            //cpds.setProperties(properties); // no sé porqué esto no sirve !!!!
            cpds.setDriverClass(driver);
            cpds.setJdbcUrl(url);
            cpds.setUser(user);
            cpds.setPassword(password);
            return cpds;
        } catch(Exception e) {
            return null;
        }
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("mx.gob.impi.chatbot.persistence.api.db2");
        return sessionFactory;
    }
}
