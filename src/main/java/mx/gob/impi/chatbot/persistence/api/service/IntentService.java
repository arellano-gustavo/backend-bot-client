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
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Miercoles 18 de Septiembre de 2019 (18_05)
 * Version:     1.0-SNAPSHOT
 * .
 * Interfaz asociado a los servicio de Intent de Dialogflow
 *
 * Historia:    .
 *              20190917_1525 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Intent;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Interfaz con los metodos para consumir los endpoint
 * de la entidad Intent del agente de dialogflow
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 * @param <TEntity> Objeto con la respuesta del consumo de los endpoints
 * @param <TRequest> Objeto con los parametros para consumir los endpoint
 */
public interface IntentService extends DialogflowService<GoogleCloudDialogflowV2Intent, GoogleCloudDialogflowV2Intent>{
	
	/**
     * Obtiene todos los registros que se encuentran
     * registrados en el agente de dialogflow
     * @param requestGet Objeto con los paramentros con los que
     *                  se consume el endpoint
     * @param response Objeto con el status del proceso para obtener
     *                 todos los registros desde el agente de dialogflow
     */
    void getPrefix(EntityItem<GoogleCloudDialogflowV2Intent> requestGet, MainControllerResponse response);

}
