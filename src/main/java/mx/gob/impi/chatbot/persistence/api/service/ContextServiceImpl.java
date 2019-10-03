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
 * Clase asociada a los servicio de Context de Dialogflow
 *
 * Historia:    .
 *              20190917_1525 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import org.springframework.stereotype.Service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Context;

import mx.gob.impi.chatbot.persistence.api.db.ContextRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Clase con los metodos para consumir los endpoint 
 * de la entidad Context del agente de dialogflow
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 * @param <TEntity> Objeto con la respuesta del consumo de los endpoints
 * @param <TRequest> Objeto con los parametros para consumir los endpoint
 */
@Service
public class ContextServiceImpl 
extends DialogflowServiceImpl<GoogleCloudDialogflowV2Context, GoogleCloudDialogflowV2Context>
implements ContextService
{
	
	@Override
	public DialogflowRequest<GoogleCloudDialogflowV2Context> getRequestPost(String area, String method, String uriTemplate, GoogleCloudDialogflowV2Context requestEntity,
			Class<GoogleCloudDialogflowV2Context> responseClass) {
		DialogflowRequest<GoogleCloudDialogflowV2Context> dialogflowRequest =new ContextRepository(credentials.getBagClients().get(area), method, uriTemplate, requestEntity, responseClass);
		return dialogflowRequest;
	}
	
	@Override
	public GoogleCloudDialogflowV2Context execute(EntityItem<GoogleCloudDialogflowV2Context> requestEnity, MainControllerResponse response){
		GoogleCloudDialogflowV2Context responseEntity = new GoogleCloudDialogflowV2Context();
		return execute(requestEnity, responseEntity, response);		
	}
	
	@Override
	public GoogleCloudDialogflowV2Context List(EntityItem<GoogleCloudDialogflowV2Context> requestGet, MainControllerResponse response) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId(requestGet.getAreaId()) + "/agent/sessions/" + requestGet.getSessionId() + "/contexts");		
		return super.List(requestGet, response);
	}
	
	@Override
	public MainControllerResponse Create(EntityItem<GoogleCloudDialogflowV2Context> requestPost) {
		requestPost.setUriTemplate("v2/projects/" + this.getProjectId(requestPost.getAreaId()) + "/agent/contexts");		
		return super.Create(requestPost);
	}
	
	@Override
	public GoogleCloudDialogflowV2Context Get(EntityItem<GoogleCloudDialogflowV2Context> requestGet, MainControllerResponse response) {
		requestGet.setUriTemplate("v2/projects/" + this.getProjectId(requestGet.getAreaId()) + "/agent/contexts/" + requestGet.getId());		
		return super.List(requestGet, response);
	}
	
	@Override
	public MainControllerResponse Update(EntityItem<GoogleCloudDialogflowV2Context> requestPut) {
		requestPut.setUriTemplate("v2/projects/" + this.getProjectId(requestPut.getAreaId()) + "/agent/contexts/" + requestPut.getId());
		return super.Update(requestPut);
	}
	
	@Override
	public MainControllerResponse Delete(EntityItem<GoogleCloudDialogflowV2Context> requestDelete) {
		requestDelete.setUriTemplate("v2/projects/" + this.getProjectId(requestDelete.getAreaId()) + "/agent/contexts/" + requestDelete.getId());
		return super.Delete(requestDelete);
	}

}
