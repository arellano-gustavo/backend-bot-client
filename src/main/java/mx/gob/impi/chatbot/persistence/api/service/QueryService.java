package mx.gob.impi.chatbot.persistence.api.service;

import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentResponse;

public interface QueryService extends DialogflowService<GoogleCloudDialogflowV2DetectIntentResponse, GoogleCloudDialogflowV2DetectIntentRequest>{

}
