package mx.gob.impi.chatbot.persistence.api.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.dialogflow.v2.Dialogflow;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

public class DialogflowCredentials {
	
	private Map<String, GoogleCredentials> bagCredentials;
	private Map<String, Dialogflow> bagClients;
	
	public DialogflowCredentials() {
		this.bagCredentials = new HashMap<String, GoogleCredentials>();
		this.bagClients= new HashMap<String, Dialogflow>();
		/*
		//MARCAS
		Create("area1", "/Users/Felix/Downloads/impi-marcas-fppooy-2bb298a3d05e.json");
		//PORTAL
		Create("area2", "/Users/Felix/Downloads/impi-bot-htsggt-89aea42a10f2.json");
		//PATENTES
		Create("area3", "/Users/Felix/Downloads/newagent-yueqxh-9a4da2d7a395.json");
		*/
		
		//MARCAS
		Create("area1", "Marcas.json");
		//PORTAL
		Create("area2", "Portal.json");
		//PATENTES
		Create("area3", "Patentes.json");
	}	
	
	private void Create(String area, String path)
	{
		GoogleCredentials credentials = null;
		Dialogflow client;
		
		try {
			InputStream stream = 
					DialogflowCredentials
	                .class
	                .getClassLoader()
	                .getResourceAsStream(path);
			
			credentials = GoogleCredentials.fromStream(stream);//Administrador de la API de Dialogflow
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	if (credentials.createScopedRequired()) {
    	    credentials = credentials.createScoped(Collections.singletonList("https://www.googleapis.com/auth/dialogflow"));
    	}
    	
    	JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();

        com.google.api.client.http.HttpTransport transport = null;
		try {
			transport = GoogleNetHttpTransport.newTrustedTransport();
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		String projectId = ((ServiceAccountCredentials)credentials).getProjectId();
        
        client = new Dialogflow.Builder(transport, jacksonFactory, null).setApplicationName(projectId).build();
        
        this.bagCredentials.put(area, credentials);
		this.bagClients.put(area, client);
    	
	}

	public Map<String, GoogleCredentials> getBagCredentials() { 
    	return bagCredentials;
    }
	
	public Map<String, Dialogflow> getBagClients() { 
    	return bagClients;
    }
}
