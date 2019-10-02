package mx.gob.impi.chatbot.persistence.api.db;

import com.google.api.services.dialogflow.v2.Dialogflow;
import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentResponse;

public class DetectIntentRepository
extends DialogflowRequest<GoogleCloudDialogflowV2DetectIntentResponse>  {

	public DetectIntentRepository(Dialogflow client, String method, String uriTemplate,
			GoogleCloudDialogflowV2DetectIntentRequest requestEntity,
			Class<GoogleCloudDialogflowV2DetectIntentResponse> responseClass) {
		super(client, method, uriTemplate, requestEntity, responseClass);
	}

}
