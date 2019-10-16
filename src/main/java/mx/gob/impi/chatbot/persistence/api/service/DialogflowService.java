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
 * Fecha:       Martes 17 de Septiembre de 2019 (15_25)
 * Version:     1.0-SNAPSHOT
 * .
 * Interfaz asociado a los servicio de Dialogflow
 *
 * Historia:    .
 *              20190917_1525 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import com.google.api.services.dialogflow.v2.DialogflowRequest;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Interfaz con los metodos para consumir los endpoint
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 * @param <T> Objeto con la rspuesta del consumo de los endpoints
 * @param <R> Objeto con los parametros para consumir los endpoint
 */
public interface DialogflowService<T, R> {

    /**
     * Metodo que crea el cliente mediante el que se hacen las
     * peticiones al agente de dialogflow
     * @param area Cadena con el Area al se realizaran las
     *             peticiones del agente agente de dialogflow
     * @param method Cadena con el metodo de HTTP para realizar
     *               la peticion
     * @param uriTemplate Cadena con el URI donde se encuentra el end pount
     * @param requestEntity Objeto con los parametros de la peticion
     *                      al endpoint de dialogflow
     * @param responseClass Indica el tipo de la clase con la que el
     *                      endpoint responde a la peticion
     * @return Objeto cliente que realiza las peticiones
     *         endpoint de dialogflow
     */
    DialogflowRequest<T> getRequestPost(String area, String method, String uriTemplate, R requestEntity,
            Class<T> responseClass);

    /**
     * Metodo que crea la referencia de la entidad con la que el endpoint
     * de dialogflow responde a las peticiones que realiza el cliente
     * @param requestGet Objeto con los parametro que se le envian endpoint
     * @param response Objeto con el estatus de la peticiones se hacen
     *                 al endpoint de dialogflow
     * @return Objeto con la respuesta del endpoint
     *         del agente de dialogflow
     */
    T execute(EntityItem<R> requestGet, MainControllerResponse response);

    /**
     * Metodo donde el cliente que se creo hace la llamado
     * a los endpoints del agente de dialogflow
     * @param requestPost Objeto con los parametro que se le envian endpoint
     * @param responseEntity Objeto de respuesta a la llamada del cliente al
     *                       end poit del agente de dialogflow
     * @param response Objeto con el estatus de la peticiones se hacen
     *                 al endpoint de dialogflow
     * @return
     */
    T execute(EntityItem<R> requestPost, T responseEntity, MainControllerResponse response);

    /**
     * Obtiene todos los registros que se encuentran
     * registrados en el agente de dialogflow
     * @param requestGet Objeto con los paramentros con los que
     *                  se consume el endpoint
     * @param response Objeto con el status del proceso para obtener
     *                 todos los registros desde el agente de dialogflow
     * @return Objeto que contiene la lista
     */
    T list(EntityItem<R> requestGet, MainControllerResponse response);

    /**
     * Ingresa un objeto en el agende de dialogflow
     * @param requestPost Objeto con los parametros de la entidad a insertar
     * @return Objeto de tipo MainControllerResponse con el status del
     *         proceso de insertar un registro en el agente de dialogflow
     */
    MainControllerResponse create(EntityItem<R>  requestPost);

     /**
      * Obtiene un objeto registrado en el agente de dialogflow
      * por medio de su identificador
      * @param requestGet Objeto que contiene el identificador
      *                   del objeto que se esta buscando
      * @param response Objeto con el status del proceso para obtener
      *                 el una registro desde el agente de dialogflow
      * @return Objeto de tipo MainControllerResponse con el status del
      *         proceso de buscar una entidad en el agente de dialogflow
      */
     
     T get(EntityItem<R> requestGet, MainControllerResponse response);
     
     /**
      * Actualiza un registro en el agente de dialogflow
      * @param requestPut Objeto con los parametros para actualizar
      *                   un registro en el agente de dialogflow
      * @return Objeto de tipo MainControllerResponse con el status del
      *         proceso de actualizar una entidad en el agente de dialogflow
      */
     MainControllerResponse update(EntityItem<R> requestPut);

     /**
      * Borra un registro en el agente de dialogflow
      * por medio de su identificador
      * @param requestDelete Objeto que contiene el identificador
      *                      del registro que se quiere borrar
      * @return
      */
     MainControllerResponse delete(EntityItem<R> requestDelete);
}
