package mx.gob.impi.chatbot.persistence.api.service;

import org.springframework.stereotype.Service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Intent;

import mx.gob.impi.chatbot.persistence.api.db.IntentRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

@Service
public class IntentServiceImpl
extends DialogflowServiceImpl<GoogleCloudDialogflowV2Intent, GoogleCloudDialogflowV2Intent>
implements IntentService
{

	@Override
	public DialogflowRequest<GoogleCloudDialogflowV2Intent> getRequestPost(String method, String uriTemplate, GoogleCloudDialogflowV2Intent requestEntity,
			Class<GoogleCloudDialogflowV2Intent> responseClass) {
		DialogflowRequest<GoogleCloudDialogflowV2Intent> dialogflowRequest =new IntentRepository(client, method, uriTemplate, requestEntity, responseClass);
		return dialogflowRequest;
	}
	
	@Override
	public GoogleCloudDialogflowV2Intent execute(EntityItem<GoogleCloudDialogflowV2Intent> requestEnity, MainControllerResponse response){
		GoogleCloudDialogflowV2Intent responseEntity = new GoogleCloudDialogflowV2Intent();
		return execute(requestEnity, responseEntity, response);		
	}
	
	@Override
	public GoogleCloudDialogflowV2Intent List(EntityItem<GoogleCloudDialogflowV2Intent> requestGet, MainControllerResponse response) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/intents?intentView=INTENT_VIEW_FULL");		
		return super.List(requestGet, response);
	}
	
	@Override
	public MainControllerResponse Create(EntityItem<GoogleCloudDialogflowV2Intent> requestPost) {
		requestPost.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/intents");		
		return super.Create(requestPost);
	}
	
	@Override
	public GoogleCloudDialogflowV2Intent Get(EntityItem<GoogleCloudDialogflowV2Intent> requestGet, MainControllerResponse response) {
		
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/intents/" + requestGet.getId() + "?intentView=INTENT_VIEW_FULL");		
		return super.List(requestGet, response);
	}
	
	@Override
	public MainControllerResponse Update(EntityItem<GoogleCloudDialogflowV2Intent> requestPut) {
		requestPut.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/intents/" + requestPut.getId());
		return super.Update(requestPut);
	}
	
	@Override
	public MainControllerResponse Delete(EntityItem<GoogleCloudDialogflowV2Intent> requestDelete) {
		requestDelete.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/intents/" + requestDelete.getId());
		return super.Delete(requestDelete);
	}
}
