package mx.gob.impi.chatbot.persistence.api.db;

import com.google.api.services.dialogflow.v2.Dialogflow;
import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Intent;

public class IntentRepository extends DialogflowRequest<GoogleCloudDialogflowV2Intent>  {

	public IntentRepository(Dialogflow client, String method, String uriTemplate, Object content,
			Class<GoogleCloudDialogflowV2Intent> responseClass) {
		super(client, method, uriTemplate, content, responseClass);
		// TODO Auto-generated constructor stub
	}


}
