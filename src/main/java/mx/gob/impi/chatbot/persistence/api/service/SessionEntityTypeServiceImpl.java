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
    static String entidad = "/agent/sessionEntityTypes/";

    @Override
    public DialogflowRequest<GoogleCloudDialogflowV2SessionEntityType> getRequestPost(String area, String method, String uriTemplate, GoogleCloudDialogflowV2SessionEntityType requestEntity,
            Class<GoogleCloudDialogflowV2SessionEntityType> responseClass) {
        // Crear el cliente de la entidad del endpoint
        return new SessionEntityTypeRepository(credentials.getBagClients().get(area), method, uriTemplate, requestEntity, responseClass);
    }

    @Override
    public GoogleCloudDialogflowV2SessionEntityType execute(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestGet, MainControllerResponse response){
        // Crear el objeto de la entidad de respuesta del endpoint
        GoogleCloudDialogflowV2SessionEntityType responseEntity = new GoogleCloudDialogflowV2SessionEntityType();
        //Se realiza la solicitud al endpoint de dialogflow
        return execute(requestGet, responseEntity, response);
    }

    @Override
    public GoogleCloudDialogflowV2SessionEntityType list(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestList, MainControllerResponse response) {
        //Establece la URI del endpoint para recuperar todos los registros de la entidad
        requestList.setUriTemplate(version + this.getProjectId(requestList.getAreaId()) + entidad);
        return super.list(requestList, response);
    }

    @Override
    public MainControllerResponse create(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestPost) {
        //Establece la URI del endpoint para crear un registro
        requestPost.setUriTemplate(version + this.getProjectId(requestPost.getAreaId()) + entidad);
        return super.create(requestPost);
    }

    @Override
    public GoogleCloudDialogflowV2SessionEntityType get(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestGet, MainControllerResponse response) {
        //Establece la URI del endpoint para obtener el un registro de la entidad por medio de su identificador
        requestGet.setUriTemplate(version + this.getProjectId(requestGet.getAreaId()) + entidad + requestGet.getId());
        return super.list(requestGet, response);
    }

    @Override
    public MainControllerResponse update(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestPut) {
        //Establece la URI del endpoint para actualizar un registro de la entidad por medio de su identificador
        requestPut.setUriTemplate(version + this.getProjectId(requestPut.getAreaId()) + entidad + requestPut.getId());
        return super.update(requestPut);
    }

    @Override
    public MainControllerResponse delete(EntityItem<GoogleCloudDialogflowV2SessionEntityType> requestDelete) {
        //Establece la URI del endpoint para borrar un registro de la entidad por medio de su identificador
        requestDelete.setUriTemplate(version + this.getProjectId(requestDelete.getAreaId()) + entidad + requestDelete.getId());
        return super.delete(requestDelete);
    }
}
