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
 * Clase asociada a los servicio de SessionEntityType de Dialogflow
 *
 * Historia:    .
 *              20190917_1525 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import org.springframework.stereotype.Service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2SessionEntityType;

import mx.gob.impi.chatbot.persistence.api.db.SessionEntityTypeRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Clase con los metodos para consumir los endpoint
 * de la entidad SessionEntityType del agente de dialogflow
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 * @param <TEntity> Objeto con la respuesta del consumo de los endpoints
 * @param <TRequest> Objeto con los parametros para consumir los endpoint
 */
@Service
public class SessionEntityTypeServiceImpl
extends DialogflowServiceImpl<GoogleCloudDialogflowV2SessionEntityType, GoogleCloudDialogflowV2SessionEntityType>
implements SessionEntityTypeService
{

    @Override
    public DialogflowRequest<GoogleCloudDialogflowV2SessionEntityType> getRequestPost(String area, String method, String uriTemplate, GoogleCloudDialogflowV2SessionEntityType requestEntity,
            Class<GoogleCloudDialogflowV2SessionEntityType> responseClass) {
        // Crear el cliente de la entidad del endpoint
        DialogflowRequest<GoogleCloudDialogflowV2SessionEntityType> dialogflowRequest =new SessionEntityTypeRepository(credentials.getBagClients().get(area), method, uriTemplate, requestEntity, responseClass);
        return dialogflowRequest;
    }

    @Override
    public GoogleCloudDialogflowV2SessionEntityType execute(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestGet, MainControllerResponse response){
        // Crear el objeto de la entidad de respuesta del endpoint
        GoogleCloudDialogflowV2SessionEntityType responseEntity = new GoogleCloudDialogflowV2SessionEntityType();
        //Se realiza la solicitud al endpoint de dialogflow
        return execute(requestGet, responseEntity, response);
    }

    @Override
    public GoogleCloudDialogflowV2SessionEntityType List(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestGet, MainControllerResponse response) {
        //Establece la URI del endpoint para recuperar todos los registros de la entidad
        requestGet.setUriTemplate("v2/projects/" + this.getProjectId(requestGet.getAreaId()) + "/agent/sessionEntityTypes");
        return super.List(requestGet, response);
    }

    @Override
    public MainControllerResponse Create(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestPost) {
        //Establece la URI del endpoint para crear un registro
        requestPost.setUriTemplate("v2/projects/" + this.getProjectId(requestPost.getAreaId()) + "/agent/sessionEntityTypes");
        return super.Create(requestPost);
    }

    @Override
    public GoogleCloudDialogflowV2SessionEntityType Get(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestGet, MainControllerResponse response) {
        //Establece la URI del endpoint para obtener el un registro de la entidad por medio de su identificador
        requestGet.setUriTemplate("v2/projects/" + this.getProjectId(requestGet.getAreaId()) + "/agent/sessionEntityTypes/" + requestGet.getId());
        return super.List(requestGet, response);
    }

    @Override
    public MainControllerResponse Update(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestPut) {
        //Establece la URI del endpoint para actualizar un registro de la entidad por medio de su identificador
        requestPut.setUriTemplate("v2/projects/" + this.getProjectId(requestPut.getAreaId()) + "/agent/sessionEntityTypes/" + requestPut.getId());
        return super.Update(requestPut);
    }

    @Override
    public MainControllerResponse Delete(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestDelete) {
        //Establece la URI del endpoint para borrar un registro de la entidad por medio de su identificador
        requestDelete.setUriTemplate("v2/projects/" + this.getProjectId(requestDelete.getAreaId()) + "/agent/sessionEntityTypes/" + requestDelete.getId());
        return super.Delete(requestDelete);
    }
}
