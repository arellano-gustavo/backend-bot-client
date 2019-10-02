package mx.gob.impi.chatbot.persistence.api.service;

import java.io.IOException;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.auth.oauth2.ServiceAccountCredentials;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

public class DialogflowServiceImpl<TEntity, TReques> implements DialogflowService<TEntity, TReques> {
	
	DialogflowCredentials credentials;
	
	
	public DialogflowServiceImpl(){
		
		this.credentials = new DialogflowCredentials();
		
	}
	
	public String getProjectId(String area){
		return ((ServiceAccountCredentials)this.credentials.getBagCredentials().get(area)).getProjectId();
	}
	
	public String getToken(String area) {
		try {
			credentials.getBagCredentials().get(area).refreshIfExpired();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.credentials.getBagCredentials().get(area).getAccessToken().getTokenValue();
	}
	/*
	public Dialogflow getClient(String area) {
		return credentials.getBagClients().get(area);
	}
	*/
	
	
	public TEntity execute(EntityItem<TReques> requestPost, TEntity responseEntity, MainControllerResponse response){
		
		TReques requestEntity = requestPost.getItem();
        
        @SuppressWarnings("unchecked")
		Class<TEntity> responseClass = (Class<TEntity>) responseEntity.getClass();        
        
		DialogflowRequest<TEntity> dialogflowRequest =  getRequestPost(requestPost.getAreaId(), requestPost.getMethod(), requestPost.getUriTemplate(), requestEntity, responseClass);
                
        String token = getToken(requestPost.getAreaId());
        
        com.google.api.client.http.HttpHeaders headers = new com.google.api.client.http.HttpHeaders();
        headers.setAuthorization("Bearer " + token);
        headers.setContentType("application/json");
        dialogflowRequest.setRequestHeaders(headers);
        
        try {
			responseEntity = (TEntity) dialogflowRequest.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			response.setLongMessage(e.toString());
			response.setMessage("Error");
			response.setSucceed(false);
			e.printStackTrace();
		}
        
        return responseEntity;
	}

	public DialogflowRequest<TEntity> getRequestPost(String area, String method, String uriTemplate, TReques requestEntity,
			Class<TEntity> responseClass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public TEntity execute(EntityItem<TReques> requestGet, MainControllerResponse response){
		return execute((EntityItem<TReques>)requestGet, null, response);		
	}

	@Override
	public TEntity List(EntityItem<TReques> requestGet, MainControllerResponse response) {		
		requestGet.setMethod("GET");
		TEntity entity = execute(requestGet, response);
		return entity;
	}
		
	@Override
	public MainControllerResponse Create(EntityItem<TReques> requestPost) {
		MainControllerResponse response = new MainControllerResponse("Creado", "Creado", true);
		requestPost.setMethod("POST");
		execute(requestPost, response);
		return response;
	}
	
	@Override
	public TEntity Get(EntityItem<TReques> requestGet, MainControllerResponse response) {
		
		requestGet.setMethod("GET");
		TEntity entity = execute(requestGet, response);
		//TEntity response = new TEntity("Recuperado", entity);
		return entity;
	}
	
	@Override
	public MainControllerResponse Update(EntityItem<TReques> requestPut) {
		MainControllerResponse response = new MainControllerResponse("Actualizado", "Actualizado", true);
		requestPut.setMethod("PATCH");
		execute(requestPut, response);
		return response;
	}
	
	@Override
	public MainControllerResponse Delete(EntityItem<TReques> requestDelete) {
		MainControllerResponse response = new MainControllerResponse("Borrado", "Borrado", true);
		requestDelete.setMethod("DELETE");
		execute(requestDelete, response);
		return response;
	}
}
