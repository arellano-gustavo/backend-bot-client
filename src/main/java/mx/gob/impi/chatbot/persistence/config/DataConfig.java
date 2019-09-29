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

import javax.sql.DataSource;

import org.slf4j.*;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

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
    
    private final static Logger logger = LoggerFactory.getLogger(DataConfig.class);
    
    @Bean
    public DataSource dataSource() {
        /**/
        if(username==null) username="sa";
        if(password==null) password="gustavo";
        if(url==null) url="jdbc:h2:tcp://api.kebblar.capital:1521/h2-data";
        /**/
        // Conectando con la base de datos:
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername(username);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        logger.info("Coneccion establecida con la base de datos");

        /* * /
        //create a table and populate some data
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Creating tables");
        jdbcTemplate.execute("drop table users if exists");
        jdbcTemplate.execute("create table users(id serial, firstName varchar(255), lastName varchar(255), email varchar(255))");
        jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) values (?,?,?)", "Mikex", "Lanyon", "lanyonm@gmail.com");
        /* */
        return dataSource;
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
