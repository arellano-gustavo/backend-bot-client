package mx.gob.impi.chatbot.persistence.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

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
    
    private final static Logger logger = Logger.getLogger(DataConfig.class);
    
    @Bean
    public DataSource dataSource() {
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
