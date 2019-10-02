package mx.gob.impi.chatbot.persistence.api.service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Context;

import mx.gob.impi.chatbot.persistence.api.db.ContextRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;


public class ContextServiceImpl 
extends DialogflowServiceImpl<GoogleCloudDialogflowV2Context, GoogleCloudDialogflowV2Context>
implements ContextService
{
	
	@Override
	public DialogflowRequest<GoogleCloudDialogflowV2Context> getRequestPost(String method, String uriTemplate, GoogleCloudDialogflowV2Context requestEntity,
			Class<GoogleCloudDialogflowV2Context> responseClass) {
		DialogflowRequest<GoogleCloudDialogflowV2Context> dialogflowRequest =new ContextRepository(client, method, uriTemplate, requestEntity, responseClass);
		return dialogflowRequest;
	}
	
	@Override
	public GoogleCloudDialogflowV2Context execute(EntityItem<GoogleCloudDialogflowV2Context> requestEnity){
		GoogleCloudDialogflowV2Context responseEntity = new GoogleCloudDialogflowV2Context();
		return execute(requestEnity, responseEntity);		
	}
	
	@Override
	public GoogleCloudDialogflowV2Context List(EntityItem<GoogleCloudDialogflowV2Context> requestGet) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/sessions/" + requestGet.getSessionId() + "/contexts");		
		return super.List(requestGet);
	}
	
	@Override
	public GoogleCloudDialogflowV2Context Create(EntityItem<GoogleCloudDialogflowV2Context> requestPost) {
		requestPost.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/contexts");		
		return super.Create(requestPost);
	}
	
	@Override
	public GoogleCloudDialogflowV2Context Get(EntityItem<GoogleCloudDialogflowV2Context> requestGet) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/contexts/" + requestGet.getId());		
		return super.List(requestGet);
	}
	
	@Override
	public GoogleCloudDialogflowV2Context Update(EntityItem<GoogleCloudDialogflowV2Context> requestPut) {
		requestPut.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/contexts/" + requestPut.getId());
		return super.Update(requestPut);
	}
	
	@Override
	public GoogleCloudDialogflowV2Context Delete(EntityItem<GoogleCloudDialogflowV2Context> requestDelete) {
		requestDelete.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/contexts/" + requestDelete.getId());
		return super.Delete(requestDelete);
	}

}
