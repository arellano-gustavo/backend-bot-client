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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jasypt.util.text.BasicTextEncryptor;
import org.mybatis.spring.SqlSessionFactoryBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
/*
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
*/
import org.springframework.context.annotation.PropertySource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * <p>Descripción:</p>
 * Configuracion del DataSource
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
//@EnableConfigurationProperties(DataConfig.class)
//@EnableEncryptableProperties
@Configuration
//@PropertySource("classpath:application.properties")
//@ConfigurationProperties(prefix = "mail")
public class DataConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataConfig.class);

    // https://www.baeldung.com/spring-value-annotation
    // https://www.baeldung.com/configuration-properties-in-spring-boot
    
    @Value("${login.url-backend}")
    private String template;
    private String user;
    private String password;
    private String jdbcUrl;
    private String driverClass;

    private Properties properties = new Properties();

    /**
     * Constructor default de la clase.
     */
    public DataConfig() {
        super();
        logger.info("This is the url for our application dot properties: " + this.template + "<-----------");
        logger.info("Calculando ambiente para C3P0 ....");
        String[] actPro = System.getProperty("spring-boot.run.profiles","").split(",");
        String activeProfile = "";
        
        if(actPro[0]!=null && actPro[0].trim().length()>0) {
        	activeProfile = "-"+actPro[0];
        	logger.info("Active profile: [" + actPro[0] + "] <------- Current profile !!!!");
        	logger.info("Usung prefix for C3P0 !!!");
        } else {
        	logger.error("Couldn't use any profile... Using Profile by default !!!!");
        }
        
        //activeProfile="-impi";

        InputStream stream =
                DataConfig
                .class
                .getClassLoader()
                .getResourceAsStream("c3p0"+activeProfile+".properties");
        try {
            properties.load(stream);
            logger.info("Properties have been loaded");
        } catch (IOException e1) {
            logger.error(e1.getMessage());
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
        if("password".equals(name)) {
        	if(data.startsWith("ENC(")) {
        		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        		textEncryptor.setPassword(name);
        		String pass = data.substring(4, data.length()-1);
        		return textEncryptor.decrypt(pass);
        	}
        	return data;
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
            cpds.setDriverClass(getProp("driverClass"));
            cpds.setJdbcUrl(getProp("jdbcUrl"));
            cpds.setUser(getProp("user"));
            cpds.setPassword(getProp("password"));
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
  //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    
    
    
    
    
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
}
