package mx.gob.impi.chatbot.persistence.api.db;

import com.google.api.services.dialogflow.v2.Dialogflow;
import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2SessionEntityType;

public class SessionEntityTypeRepository
extends DialogflowRequest<GoogleCloudDialogflowV2SessionEntityType>  {

	public SessionEntityTypeRepository(Dialogflow client, String method, String uriTemplate, Object content,
			Class<GoogleCloudDialogflowV2SessionEntityType> responseClass) {
		super(client, method, uriTemplate, content, responseClass);
		// TODO Auto-generated constructor stub
	}


}
