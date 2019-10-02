package mx.gob.impi.chatbot.persistence.api.service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentResponse;

import mx.gob.impi.chatbot.persistence.api.db.DetectIntentRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;

public class QueryServiceImpl
extends DialogflowServiceImpl<GoogleCloudDialogflowV2DetectIntentResponse, GoogleCloudDialogflowV2DetectIntentRequest>
implements QueryService
{
	
	public DialogflowRequest<GoogleCloudDialogflowV2DetectIntentResponse> getRequestPost(String method, String uriTemplate, GoogleCloudDialogflowV2DetectIntentRequest requestEntity,
			Class<GoogleCloudDialogflowV2DetectIntentResponse> responseClass) {
		DialogflowRequest<GoogleCloudDialogflowV2DetectIntentResponse> dialogflowRequest = new DetectIntentRepository(client, method, uriTemplate, requestEntity, responseClass);
		return dialogflowRequest;
	}
	
	@Override
	public GoogleCloudDialogflowV2DetectIntentResponse Create(EntityItem<GoogleCloudDialogflowV2DetectIntentRequest> requestPost) {
		requestPost.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/sessions/" + requestPost.getSessionId() + ":detectIntent");
		return super.Create(requestPost);
	}
	
	@Override
	public GoogleCloudDialogflowV2DetectIntentResponse execute(EntityItem<GoogleCloudDialogflowV2DetectIntentRequest> requestEnity){
		GoogleCloudDialogflowV2DetectIntentResponse responseEntity = new GoogleCloudDialogflowV2DetectIntentResponse();
		return execute(requestEnity, responseEntity);		
	}
	

}
