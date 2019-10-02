package mx.gob.impi.chatbot.persistence.api.service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2SessionEntityType;

import mx.gob.impi.chatbot.persistence.api.db.SessionEntityTypeRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

public class SessionEntityTypeServiceImpl
extends DialogflowServiceImpl<GoogleCloudDialogflowV2SessionEntityType, GoogleCloudDialogflowV2SessionEntityType>
implements SessionEntityTypeService
{

	@Override
	public DialogflowRequest<GoogleCloudDialogflowV2SessionEntityType> getRequestPost(String method, String uriTemplate, GoogleCloudDialogflowV2SessionEntityType requestEntity,
			Class<GoogleCloudDialogflowV2SessionEntityType> responseClass) {
		DialogflowRequest<GoogleCloudDialogflowV2SessionEntityType> dialogflowRequest =new SessionEntityTypeRepository(client, method, uriTemplate, requestEntity, responseClass);
		return dialogflowRequest;
	}
	
	@Override
	public GoogleCloudDialogflowV2SessionEntityType execute(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestGet, MainControllerResponse response){
		GoogleCloudDialogflowV2SessionEntityType responseEntity = new GoogleCloudDialogflowV2SessionEntityType();
		return execute(requestGet, responseEntity, response);		
	}
	
	@Override
	public GoogleCloudDialogflowV2SessionEntityType List(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestGet, MainControllerResponse response) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/sessionEntityTypes");		
		return super.List(requestGet, response);
	}
	
	@Override
	public MainControllerResponse Create(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestPost) {
		requestPost.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/sessionEntityTypes");		
		return super.Create(requestPost);
	}
	
	@Override
	public GoogleCloudDialogflowV2SessionEntityType Get(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestGet, MainControllerResponse response) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/sessionEntityTypes/" + requestGet.getId());		
		return super.List(requestGet, response);
	}
	
	@Override
	public MainControllerResponse Update(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestPut) {
		requestPut.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/sessionEntityTypes/" + requestPut.getId());
		return super.Update(requestPut);
	}
	
	@Override
	public MainControllerResponse Delete(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestDelete) {
		requestDelete.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/sessionEntityTypes/" + requestDelete.getId());
		return super.Delete(requestDelete);
	}
}
