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
 * Clase asociada a los servicio de EntityType de Dialogflow
 *
 * Historia:    .
 *              20190917_1525 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import org.springframework.stereotype.Service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2EntityType;

import mx.gob.impi.chatbot.persistence.api.db.EntityTypeRepository;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Clase con los metodos para consumir los endpoint
 * de la entidad EntityType del agente de dialogflow
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 * @param <TEntity> Objeto con la respuesta del consumo de los endpoints
 * @param <TRequest> Objeto con los parametros para consumir los endpoint
 */
@Service
public class EntityTypeServiceImpl
extends DialogflowServiceImpl<GoogleCloudDialogflowV2EntityType, GoogleCloudDialogflowV2EntityType>
implements EntityTypeService{

    @Override
    public DialogflowRequest<GoogleCloudDialogflowV2EntityType> getRequestPost(String area, String method, String uriTemplate, GoogleCloudDialogflowV2EntityType requestEntity,
            Class<GoogleCloudDialogflowV2EntityType> responseClass) {
        // Crear el cliente de la entidad del endpoint
        DialogflowRequest<GoogleCloudDialogflowV2EntityType> dialogflowRequest =new EntityTypeRepository(credentials.getBagClients().get(area), method, uriTemplate, requestEntity, responseClass);
        return dialogflowRequest;
    }

    @Override
    public GoogleCloudDialogflowV2EntityType execute(EntityItem<GoogleCloudDialogflowV2EntityType> requestEnity, MainControllerResponse response){
        // Crear el objeto de la entidad de respuesta del endpoint
        GoogleCloudDialogflowV2EntityType responseEntity = new GoogleCloudDialogflowV2EntityType();
        //Se realiza la solicitud al endpoint de dialogflow
        return execute(requestEnity, responseEntity, response);
    }

    @Override
    public GoogleCloudDialogflowV2EntityType List(EntityItem<GoogleCloudDialogflowV2EntityType> requestGet, MainControllerResponse response) {
        //Establece la URI del endpoint para recuperar todos los registros de la entidad
        requestGet.setUriTemplate("v2/projects/" + this.getProjectId(requestGet.getAreaId()) + "/agent/entityTypes");
        return super.List(requestGet, response);
    }

    @Override
    public MainControllerResponse Create(EntityItem<GoogleCloudDialogflowV2EntityType> requestPost) {
        //Establece la URI del endpoint para crear un registro
        requestPost.setUriTemplate("v2/projects/" + this.getProjectId(requestPost.getAreaId()) + "/agent/entityTypes");
        return super.Create(requestPost);
    }

    @Override
    public GoogleCloudDialogflowV2EntityType Get(EntityItem<GoogleCloudDialogflowV2EntityType> requestGet, MainControllerResponse response) {
        //Establece la URI del endpoint para obtener el un registro de la entidad por medio de su identificador
        requestGet.setUriTemplate("v2/projects/" + this.getProjectId(requestGet.getAreaId()) + "/agent/entityTypes/" + requestGet.getId());
        return super.List(requestGet,  response);
    }

    @Override
    public MainControllerResponse Update(EntityItem<GoogleCloudDialogflowV2EntityType> requestPut) {
        //Establece la URI del endpoint para actualizar un registro de la entidad por medio de su identificador
        requestPut.setUriTemplate("v2/projects/" + this.getProjectId(requestPut.getAreaId()) + "/agent/entityTypes/" + requestPut.getId());
        return super.Update(requestPut);
    }

    @Override
    public MainControllerResponse Delete(EntityItem<GoogleCloudDialogflowV2EntityType> requestDelete) {
        //Establece la URI del endpoint para borrar un registro de la entidad por medio de su identificador
        requestDelete.setUriTemplate("v2/projects/" + this.getProjectId(requestDelete.getAreaId()) + "/agent/entityTypes/" + requestDelete.getId());
        return super.Delete(requestDelete);
    }
}
