/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.service
 * Modulo:      Dialogflow
 * Tipo:        class
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Miercoles 18 de Septiembre de 2019 (18_05)
 * Version:     1.0-SNAPSHOT
 * .
 * Clase asociada a los servicio de IntentRequest de Dialogflow
 *
 * Historia:    .
 *              20190917_1525 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import org.springframework.stereotype.Service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentResponse;

import mx.gob.impi.chatbot.persistence.api.db.DetectIntentRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Clase con los metodos para consumir los endpoint
 * de la entidad IntentRequest del agente de dialogflow
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 * @param <TEntity> Objeto con la respuesta del consumo de los endpoints
 * @param <TRequest> Objeto con los parametros para consumir los endpoint
 */
@Service
public class QueryServiceImpl
extends DialogflowServiceImpl<GoogleCloudDialogflowV2DetectIntentResponse, GoogleCloudDialogflowV2DetectIntentRequest>
implements QueryService
{

    public DialogflowRequest<GoogleCloudDialogflowV2DetectIntentResponse> getRequestPost(String area, String method, String uriTemplate, GoogleCloudDialogflowV2DetectIntentRequest requestEntity,
            Class<GoogleCloudDialogflowV2DetectIntentResponse> responseClass) {
        // Crear el cliente de la entidad del endpoint
    	return new DetectIntentRepository(credentials.getBagClients().get(area), method, uriTemplate, requestEntity, responseClass);
    }
    /*
    @Override
    public GoogleCloudDialogflowV2DetectIntentResponse Create(EntityItem<GoogleCloudDialogflowV2DetectIntentRequest> requestPost) {
        requestPost.setUriTemplate("v2/projects/" + this.getProjectId() + "/agent/sessions/" + requestPost.getSessionId() + ":detectIntent");
        return super.Create(requestPost);
    }
    */
    @Override
    public GoogleCloudDialogflowV2DetectIntentResponse execute(EntityItem<GoogleCloudDialogflowV2DetectIntentRequest> requestEnity, MainControllerResponse response){
        // Crear el objeto de la entidad de respuesta del endpoint
        GoogleCloudDialogflowV2DetectIntentResponse responseEntity = new GoogleCloudDialogflowV2DetectIntentResponse();
        //Se realiza la solicitud al endpoint de dialogflow
        return execute(requestEnity, responseEntity, response);
    }


}
