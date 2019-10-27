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

import javax.sql.DataSource;

import org.jasypt.util.text.BasicTextEncryptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import mx.gob.impi.chatbot.persistence.support.PropHelper;

/**
 * <p>Descripción:</p>
 * Configuracion del DataSource
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Configuration
public class DataConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // https://www.baeldung.com/spring-value-annotation
    // https://www.baeldung.com/configuration-properties-in-spring-boot
    
    private PropHelper ph = null;

    /**
     * Constructor default de la clase.
     */
    public DataConfig() {
        logger.info("Calculando ambiente para C3P0 ....");
        
        // I COULDN´T GET THE REAL ONE :(
        String configLocation = "/configuration/";
        configLocation="";
        
        configLocation = System.getProperty("spring.config.location","");
        logger.info("Config location: --->" + configLocation + "<---"); 
        
        try {
            ph = PropHelper.getInstance(configLocation, "c3p0");
        } catch (IOException e) {
            logger.error("Error fatal al cargar las propiedades de c3p0: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Crea pool de conexiones
     * @return Regresa el data source
     */
    @Bean
    public DataSource dataSource(){
    	String pass = unEncrypt(ph.getProp("c3p0.password")); // gustavo
    	logger.info("Password: "+pass); 
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass(ph.getProp("c3p0.driverClass"));
            cpds.setJdbcUrl(    ph.getProp("c3p0.jdbcUrl"));
            cpds.setUser(       ph.getProp("c3p0.user"));
            cpds.setPassword(   pass);
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
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("mx.gob.impi.chatbot.persistence.api.db2");
        return sessionFactory;
    }
    private String unEncrypt(String encriptedData) {
    	if(encriptedData.startsWith("ENC(")) {
    		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
	        String pureData = encriptedData.substring(4, encriptedData.length()-1);
    		logger.info("encrypted data received: " + pureData);
	        textEncryptor.setPassword("gustavo");
	        String descrypted = textEncryptor.decrypt(pureData);
	        logger.info("decrypted data: "+descrypted);
	        return descrypted;
    	}
    	return encriptedData;
    }
}
