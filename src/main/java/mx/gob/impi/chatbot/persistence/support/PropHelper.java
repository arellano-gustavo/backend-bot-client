package mx.gob.impi.chatbot.persistence.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.impi.chatbot.persistence.config.DataConfig;

public class PropHelper {
    private static final Logger logger = LoggerFactory.getLogger(PropHelper.class);
    
    private Properties properties = new Properties();
    private BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
    
    private static PropHelper instance = null;

    public static PropHelper getInstance(String configLocation, String basePropertiesName) throws IOException {
        if(instance==null) {
            instance = new PropHelper(configLocation, basePropertiesName);
        }
        return instance;
    }
    public static PropHelper getInstance() throws IOException {
        if(instance==null) {
            throw new IOException("Use the getInstance(String, String) first");
        }
        return instance;
    }
    
    public String getCurrentFirstProfile() {
        String[] actPro = System.getProperty("spring-boot.run.profiles","").split(",");
        String activeProfile = "";

        if(actPro[0]!=null && actPro[0].trim().length()>0) {
            activeProfile = "-"+actPro[0];
            logger.info("Active profile: [" + actPro[0] + "] <------- Current profile !!!!");
        } else {
            logger.error("Couldn't use any profile... Using Profile by default !!!!");
        }
        
        //activeProfile="-impi";
        //activeProfile="";
        return activeProfile; // Lleva un "-" al principio
    }
    
    private PropHelper(String configLocation, String basePropertiesName) throws IOException {
        // calculate paths
        String activeProfile = this.getCurrentFirstProfile();
        String fullProfileName = basePropertiesName+activeProfile+".properties";
        logger.info("fullProfileName: "+fullProfileName);
        logger.info("configLocation: "+configLocation);
        
        
        // load from classpath or file
        if(configLocation.trim().length()<1) {
            logger.info("Loading properties form classpath");
            InputStream stream =
                DataConfig
                .class
                .getClassLoader()
                .getResourceAsStream(fullProfileName);
            properties.load(stream);
            logger.info("Properties have been loaded from the classpath");
        } else {
            logger.info("Loading properties form filesystem");
            configLocation = configLocation.substring(5);
            File fr = new File(configLocation+fullProfileName);
            InputStream fis = new FileInputStream(fr);
            properties.load(fis);
            logger.info("Properties ("+basePropertiesName+activeProfile+") have been loaded from the config directory: " + configLocation);
        }
    }
    
    public Properties getAllProps() {
        return this.properties;
    }
    
    /**
     * Regresa la propiedad solicitada
     * @param name Cadena con el nombre de la propiedad
     *             que se quiere recuperar
     * @return Cadena con la propiedad recuperada
     */
    public String getProp(String name) {
        String data = properties.get(name).toString();
        return unEncrypt(data);
    }
    
    private String unEncrypt(String encriptedData) {
    	if(encriptedData.startsWith("ENC(")) {
	        String pureData = encriptedData.substring(4, encriptedData.length()-1);
	        textEncryptor.setPassword("gustavo");
	        return textEncryptor.decrypt(pureData);
    	}
    	return encriptedData;
    }
}
