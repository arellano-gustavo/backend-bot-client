package mx.gob.impi.chatbot.persistence.api.service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2EntityType;

import mx.gob.impi.chatbot.persistence.api.db.EntityTypeRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

public class EntityTypeServiceImpl 
extends DialogflowServiceImpl<GoogleCloudDialogflowV2EntityType, GoogleCloudDialogflowV2EntityType>
implements EntityTypeService{

	@Override
	public DialogflowRequest<GoogleCloudDialogflowV2EntityType> getRequestPost(String method, String uriTemplate, GoogleCloudDialogflowV2EntityType requestEntity,
			Class<GoogleCloudDialogflowV2EntityType> responseClass) {
		DialogflowRequest<GoogleCloudDialogflowV2EntityType> dialogflowRequest =new EntityTypeRepository(client, method, uriTemplate, requestEntity, responseClass);
		return dialogflowRequest;
	}
	
	@Override
	public GoogleCloudDialogflowV2EntityType execute(EntityItem<GoogleCloudDialogflowV2EntityType> requestEnity, MainControllerResponse response){
		GoogleCloudDialogflowV2EntityType responseEntity = new GoogleCloudDialogflowV2EntityType();
		return execute(requestEnity, responseEntity, response);		
	}
	
	@Override
	public GoogleCloudDialogflowV2EntityType List(EntityItem<GoogleCloudDialogflowV2EntityType> requestGet, MainControllerResponse response) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes");		
		return super.List(requestGet, response);
	}
	
	@Override
	public MainControllerResponse Create(EntityItem<GoogleCloudDialogflowV2EntityType> requestPost) {
		requestPost.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes");		
		return super.Create(requestPost);
	}
	
	@Override
	public GoogleCloudDialogflowV2EntityType Get(EntityItem<GoogleCloudDialogflowV2EntityType> requestGet, MainControllerResponse response) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes/" + requestGet.getId());		
		return super.List(requestGet,  response);
	}
	
	@Override
	public MainControllerResponse Update(EntityItem<GoogleCloudDialogflowV2EntityType> requestPut) {
		requestPut.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes/" + requestPut.getId());
		return super.Update(requestPut);
	}
	
	@Override
	public MainControllerResponse Delete(EntityItem<GoogleCloudDialogflowV2EntityType> requestDelete) {
		requestDelete.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes/" + requestDelete.getId());
		return super.Delete(requestDelete);
	}
}
