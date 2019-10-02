package mx.gob.impi.chatbot.persistence.api.service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2EntityType;

import mx.gob.impi.chatbot.persistence.api.db.EntityTypeRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;

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
	public GoogleCloudDialogflowV2EntityType execute(EntityItem<GoogleCloudDialogflowV2EntityType> requestEnity){
		GoogleCloudDialogflowV2EntityType responseEntity = new GoogleCloudDialogflowV2EntityType();
		return execute(requestEnity, responseEntity);		
	}
	
	@Override
	public GoogleCloudDialogflowV2EntityType List(EntityItem<GoogleCloudDialogflowV2EntityType> requestGet) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes");		
		return super.List(requestGet);
	}
	
	@Override
	public GoogleCloudDialogflowV2EntityType Create(EntityItem<GoogleCloudDialogflowV2EntityType> requestPost) {
		requestPost.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes");		
		return super.Create(requestPost);
	}
	
	@Override
	public GoogleCloudDialogflowV2EntityType Get(EntityItem<GoogleCloudDialogflowV2EntityType> requestGet) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes/" + requestGet.getId());		
		return super.List(requestGet);
	}
	
	@Override
	public GoogleCloudDialogflowV2EntityType Update(EntityItem<GoogleCloudDialogflowV2EntityType> requestPut) {
		requestPut.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes/" + requestPut.getId());
		return super.Update(requestPut);
	}
	
	@Override
	public GoogleCloudDialogflowV2EntityType Delete(EntityItem<GoogleCloudDialogflowV2EntityType> requestDelete) {
		requestDelete.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/entityTypes/" + requestDelete.getId());
		return super.Delete(requestDelete);
	}
}
