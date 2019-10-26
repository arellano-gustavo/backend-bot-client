package mx.gob.impi.chatbot.persistence.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:c3p0.properties")
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
        BufferedReader inStream = new BufferedReader(
                new InputStreamReader( process.getInputStream()));  
        logger.info(inStream.readLine());
		

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
 
        info.put("loginUrlBackend", loginUrlBackend);
        info.put("loginUrlBackendPort", loginUrlBackendPort);
        info.put("loginUrlFrontend", loginUrlFrontend);
        info.put("loginUrlFrontendPort", loginUrlFrontendPort);
        
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
            return info;
        }
        Set<String> names = profile.stringPropertyNames();
        for(String name : names) {
        	info.put(name, profile.getProperty(name));
        }
        
        return info;
    }

    @Override
    public List<String> getLog(int last) {
    	List<String> lista = new ArrayList<>();
		try {
			List<String> allLines = Files.readAllLines(Paths.get("/log/chatbot.log"));
			int len = allLines.size();
			if(last<1) {
				return allLines;
			} 
			for(int i=Math.max(0, len-last); i<len; i++) {
				lista.add(allLines.get(i));
			}
			return lista;
		} catch (IOException e) {
			lista.add(e.getMessage());
			return lista;
		}
    }
}
