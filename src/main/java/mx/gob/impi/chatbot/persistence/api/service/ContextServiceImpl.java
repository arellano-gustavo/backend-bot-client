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
	static String entidad = "/agent/contexts/";

    @Override
    public DialogflowRequest<GoogleCloudDialogflowV2Context> getRequestPost(String area, String method, String uriTemplate, GoogleCloudDialogflowV2Context requestEntity,
            Class<GoogleCloudDialogflowV2Context> responseClass) {
        // Crear el cliente de la entidad del endpoint
    	return new ContextRepository(credentials.getBagClients().get(area), method, uriTemplate, requestEntity, responseClass);        
    }

    @Override
    public GoogleCloudDialogflowV2Context execute(EntityItem<GoogleCloudDialogflowV2Context> requestEnity, MainControllerResponse response){
        // Crear el objeto de la entidad de respuesta del endpoint
        GoogleCloudDialogflowV2Context responseEntity = new GoogleCloudDialogflowV2Context();
        //Se realiza la solicitud al endpoint de dialogflow
        return execute(requestEnity, responseEntity, response);
    }

    @Override
    public GoogleCloudDialogflowV2Context list(EntityItem<GoogleCloudDialogflowV2Context> requestList, MainControllerResponse response) {
        //Establece la URI del endpoint para recuperar todos los registros de la entidad
        requestList.setUriTemplate(version + this.getProjectId(requestList.getAreaId()) + "/agent/sessions/" + requestList.getSessionId() + "/contexts");
        return super.list(requestList, response);
    }

    @Override
    public MainControllerResponse create(EntityItem<GoogleCloudDialogflowV2Context> requestPost) {
        //Establece la URI del endpoint para crear un registro
        requestPost.setUriTemplate(version + this.getProjectId(requestPost.getAreaId()) + entidad);
        return super.create(requestPost);
    }

    @Override
    public GoogleCloudDialogflowV2Context get(EntityItem<GoogleCloudDialogflowV2Context> requestGet, MainControllerResponse response) {
        //Establece la URI del endpoint para obtener el un registro de la entidad por medio de su identificador
        requestGet.setUriTemplate(version + this.getProjectId(requestGet.getAreaId()) + entidad + requestGet.getId());
        return super.list(requestGet, response);
    }

    @Override
    public MainControllerResponse update(EntityItem<GoogleCloudDialogflowV2Context> requestPut) {
        //Establece la URI del endpoint para actualizar un registro de la entidad por medio de su identificador
        requestPut.setUriTemplate(version + this.getProjectId(requestPut.getAreaId()) + entidad + requestPut.getId());
        return super.update(requestPut);
    }

    @Override
    public MainControllerResponse delete(EntityItem<GoogleCloudDialogflowV2Context> requestDelete) {
        //Establece la URI del endpoint para borrar un registro de la entidad por medio de su identificador
        requestDelete.setUriTemplate(version + this.getProjectId(requestDelete.getAreaId()) + entidad + requestDelete.getId());
        return super.delete(requestDelete);
    }

}
