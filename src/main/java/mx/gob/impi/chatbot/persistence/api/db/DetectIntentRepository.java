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
 * Paquete:     mx.gob.impi.chatbot.persistence.api.db
 * Modulo:      Dialogflow
 * Tipo:        class 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Jueves 12 de Septiembre de 2019 (16_47)
 * Version:     1.0-SNAPSHOT
 * .
 * Clase que crea el cliente para consumir los endpoint de 
 * DetectIntent del agente de dialogflow
 * Historia:    .
 *              20190912_1647 Creación del tipo
 */
package mx.gob.impi.chatbot.persistence.api.db;

import com.google.api.services.dialogflow.v2.Dialogflow;
import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentRequest;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2DetectIntentResponse;

/**
 * <p>Descripción:</p>
 * Clase cliente que consume los endpoint 
 * de la entidad DetectIntent del agente de dialogflow
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class DetectIntentRepository
extends DialogflowRequest<GoogleCloudDialogflowV2DetectIntentResponse>  {

	/**
	 * Constructor que crea el cliente para consumir los endpoint
	 * de DetectIntent del agente de dialogflow
	 * @param client Objeto cliente que realiza las peticiones a
	 *               los endpoints de dialogflow
	 * @param method Cadena con el metodo de HTTP para realizar
	 *               la peticion
	 * @param uriTemplate Cadena con el URI donde se encuentra el end pount
	 * @param content Objeto con los parametros de la peticion
	 *                al endpoint de dialogflow
	 * @param responseClass Indica el tipo de la clase con la que el
	 *                      endpoint responde a la peticion
	 */
	public DetectIntentRepository(Dialogflow client, String method, String uriTemplate,
			GoogleCloudDialogflowV2DetectIntentRequest requestEntity,
			Class<GoogleCloudDialogflowV2DetectIntentResponse> responseClass) {
		super(client, method, uriTemplate, requestEntity, responseClass);
	}

}
