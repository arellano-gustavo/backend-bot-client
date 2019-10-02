package mx.gob.impi.chatbot.persistence.api.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.dialogflow.v2.Dialogflow;
import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;

public class DialogflowServiceImpl<TEntity, TReques> implements DialogflowService<TEntity, TReques> {
	
	GoogleCredentials credentials;
	String projectId;
	Dialogflow client;	
	
	public DialogflowServiceImpl(){
		
		try {
			
			//MARCAS
			credentials = GoogleCredentials.fromStream(new FileInputStream("/Users/Felix/Downloads/impi-marcas-fppooy-2bb298a3d05e.json"));//Administrador de la API de Dialogflow
			
			//PORTAL
			//credentials = GoogleCredentials.fromStream(new FileInputStream("/Users/Felix/Downloads/impi-bot-htsggt-89aea42a10f2.json"));//Administrador de la API de Dialogflow
			
			//PATENTES
			//credentials = GoogleCredentials.fromStream(new FileInputStream("/Users/Felix/Downloads/newagent-yueqxh-9a4da2d7a395.json"));//Administrador de la API de Dialogflow
			
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
       
		this.projectId = ((ServiceAccountCredentials)credentials).getProjectId();
        
        this.client = new Dialogflow.Builder(transport, jacksonFactory, null).setApplicationName(this.projectId).build();
    	
	}
	
	public String getProjectId(){
		return this.projectId;
	}
	
	public String getToken() {
		try {
			credentials.refreshIfExpired();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.credentials.getAccessToken().getTokenValue();
	}
	
	public Dialogflow getClient() {
		return client;
	}
	
	
	
	public TEntity execute(EntityItem<TReques> requestPost, TEntity responseEntity){
		
		TReques requestEntity = requestPost.getItem();
        
        @SuppressWarnings("unchecked")
		Class<TEntity> responseClass = (Class<TEntity>) responseEntity.getClass();        
        
		DialogflowRequest<TEntity> dialogflowRequest =  getRequestPost(requestPost.getMethod(), requestPost.getUriTemplate(), requestEntity, responseClass);
                
        String token = getToken();
        
        com.google.api.client.http.HttpHeaders headers = new com.google.api.client.http.HttpHeaders();
        headers.setAuthorization("Bearer " + token);
        headers.setContentType("application/json");
        dialogflowRequest.setRequestHeaders(headers);
        
        try {
			responseEntity = (TEntity) dialogflowRequest.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return responseEntity;
	}

	public DialogflowRequest<TEntity> getRequestPost(String method, String uriTemplate, TReques requestEntity,
			Class<TEntity> responseClass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public TEntity execute(EntityItem<TReques> requestGet){
		return execute((EntityItem<TReques>)requestGet, null);		
	}

	@Override
	public TEntity List(EntityItem<TReques> requestGet) {
		requestGet.setMethod("GET");
		TEntity entity = execute(requestGet);
		//TEntity response = new TEntity("Listado", entity);
		return entity;
	}
		
	@Override
	public TEntity Create(EntityItem<TReques> requestPost) {
		requestPost.setMethod("POST");
		TEntity entity = execute(requestPost);
		//TEntity response = new TEntity("Creado", entity);
		return entity;
	}
	
	@Override
	public TEntity Get(EntityItem<TReques> requestGet) {
		requestGet.setMethod("GET");
		TEntity entity = execute(requestGet);
		//TEntity response = new TEntity("Recuperado", entity);
		return entity;
	}
	
	@Override
	public TEntity Update(EntityItem<TReques> requestPut) {
		requestPut.setMethod("PATCH");
		TEntity entity = execute(requestPut);
		//TEntity response = new TEntity("Actualizado", entity);
		return entity;
	}
	
	@Override
	public TEntity Delete(EntityItem<TReques> requestDelete) {
		requestDelete.setMethod("DELETE");
		TEntity entity = execute(requestDelete);
		//TEntity response = new TEntity("Borrado", entity);
		return entity;
	}
}
