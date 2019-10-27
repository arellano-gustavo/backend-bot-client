package mx.gob.impi.chatbot.persistence.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import mx.gob.impi.chatbot.persistence.config.DataConfig;

public class PropHelper {
    private static final Logger logger = LoggerFactory.getLogger(PropHelper.class);
    
    private Properties properties = new Properties();
    
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
    
    public PropHelper(String configLocation, String basePropertiesName) throws IOException {
        // calculate paths
        String activeProfile = this.getCurrentFirstProfile();
        String fullProfileName = basePropertiesName+activeProfile+".properties";
        logger.info("fullProfileName: --->"+fullProfileName+"<---");
        logger.info("configLocation: --->"+configLocation+"<---");
        
        
        // load from classpath or file
        if(configLocation.trim().length()<1) {
        	logger.warn("No config directory was especified. Using internal classpath config files");
        	loadPropsFromClasspath(fullProfileName);
        } else {
        	try {
        		logger.info("Using a config directory that was declared: " + configLocation);
        		loadPropsFromFileSystem(configLocation, fullProfileName, basePropertiesName, activeProfile);
        	} catch (IOException ioe) {
        		logger.error("Unable to load configuration fron provided conf dir. Falling back to local configuration, same profile.");
        		loadPropsFromClasspath(fullProfileName);
        	}
        }
    }
    private void loadPropsFromFileSystem(String configLocation, String fullProfileName, String basePropertiesName, String activeProfile) throws IOException {
        logger.info("Loading properties form filesystem");
        configLocation = configLocation.substring(5);
        File fr = new File(configLocation+fullProfileName);
        InputStream fis = new FileInputStream(fr);
        properties.load(fis);
        logger.info("Properties ("+basePropertiesName+activeProfile+") have been loaded from the config directory: " + configLocation);
    }
    
    private void loadPropsFromClasspath(String fullProfileName) throws IOException {
        logger.info("Loading properties form classpath");
        InputStream stream =
            DataConfig
            .class
            .getClassLoader()
            .getResourceAsStream(fullProfileName);
        properties.load(stream);
        logger.info("Properties have been loaded from the classpath");
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
        return properties.get(name).toString();
    }
    
}
