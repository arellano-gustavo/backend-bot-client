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
 * Fecha:       Viernes 13 de Septiembre de 2019 (13_25)
 * Version:     1.0-SNAPSHOT
 * .
 * Clase base para consumir los endpoint del agente de chatbot
 *
 * Historia:    .
 *              20190913_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.services.dialogflow.v2.DialogflowRequest;
import com.google.auth.oauth2.ServiceAccountCredentials;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

/**
 * <p>Descripción:</p>
 * Clase con los metdos para consumir el agente de dialogflow
 * de acuerdo a la entidad que se quiere administrar
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public abstract class DialogflowServiceImpl<T, R> implements DialogflowService<T, R> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    DialogflowCredentials credentials;
    
    static String version = "v2/projects/";

    /**
     * Contructor en el que se crea el almacen de las
     * credenciales para consumir los endpoints de dialogflow
     *
     */
    public DialogflowServiceImpl(){

        // Referencia al singleton que contiee
        this.credentials = DialogflowCredentials.getInstance();

    }

    /**
     * Obtiene por medio del area el identificador
     * del proyecto del agente de dialogflow el cual
     * se utiliza para construr el URI del endpoint
     * @param area Cadena del area a la que se quiere
     *              realizar una peticion
     * @return Cadena que contiene el identificador del
     *         agente al que quiere realizar peticiones
     */
    public String getProjectId(String area){
        //Recupera el identificador del proyecto del area solicitada
        return ((ServiceAccountCredentials)this.credentials.getBagCredentials().get(area)).getProjectId();
    }

    /**
     * Obtiene el token del area del agente de dialogflow
     * a donde se desea realizar una pericion
     * @param area Cadena del area a la que se quiere
     *              realizar una peticion
     * @return Cadena con el token del area de agente de
     *         dialogflow al que se realizara la peticion
     */
    public String getToken(String area) {
        try {
            //Si el token de las credenciales ya expiro se genera uno nuevo
            credentials.getBagCredentials().get(area).refreshIfExpired();
        } catch (IOException e) {
            logger.error("Error  al abrir las credenciales del {}", area + e.toString());
        }
        //Regresa el token de las credenciales guardadas previamente
        return this.credentials.getBagCredentials().get(area).getAccessToken().getTokenValue();
    }

    public T execute(EntityItem<R> requestPost, T responseEntity, MainControllerResponse response){

        R requestEntity = requestPost.getItem();

        //Recupera el tipo de clase con la que el endpoint responde
        @SuppressWarnings("unchecked")
        Class<T> responseClass = (Class<T>) responseEntity.getClass();

        //Crea el cliente de los endpoints
        DialogflowRequest<T> dialogflowRequest =  getRequestPost(requestPost.getAreaId(), requestPost.getMethod(), requestPost.getUriTemplate(), requestEntity, responseClass);

        //Obtiene el token desde el objeto que almacena las credenciales
        String token = getToken(requestPost.getAreaId());

        //Crea la cabecera para enviar el token al endpoint de dialogflow
        com.google.api.client.http.HttpHeaders headers = new com.google.api.client.http.HttpHeaders();
        headers.setAuthorization("Bearer " + token);
        headers.setContentType("application/json");
        dialogflowRequest.setRequestHeaders(headers);

        try {
            //Realiza la solicitud al endpoint de dialogflow
            responseEntity = (T) dialogflowRequest.execute();
        } catch (IOException e) {
            logger.error("Error en el endpoint del {}", requestPost.getAreaId() + e.toString());
            response.setLongMessage(e.toString());
            response.setMessage("Error");
            response.setSucceed(false);
        }

        return responseEntity;
    }

    public DialogflowRequest<T> getRequestPost(String area, String method, String uriTemplate, R requestEntity,
            Class<T> responseClass) {    return null;
    }

    public T execute(EntityItem<R> requestGet, MainControllerResponse response){
        return execute((EntityItem<R>)requestGet, null, response);
    }

    @Override
    public T list(EntityItem<R> requestList, MainControllerResponse response) {
        //Indica el metodo de HTTP con el que el cliente va a realizar la solicitud al endpoint
        requestList.setMethod("GET");
        //Se realiza la solicitud al endpoint de dialogflow
        return execute(requestList, response);
    }

    @Override
    public MainControllerResponse create(EntityItem<R> requestPost) {
        //Crea el objeto de respuesta
        MainControllerResponse response = new MainControllerResponse("Creado", "Creado", true);
        //Indica el metodo de HTTP con el que el cliente va a realizar la solicitud al endpoint
        requestPost.setMethod("POST");
        //Se realiza la solicitud al endpoint de dialogflow
        execute(requestPost, response);
        return response;
    }

    @Override
    public T get(EntityItem<R> requestGet, MainControllerResponse response) {
        //Indica el metodo de HTTP con el que el cliente va a realizar la solicitud al endpoint
        requestGet.setMethod("GET");
        return execute(requestGet, response);
    }

    @Override
    public MainControllerResponse update(EntityItem<R> requestPut) {
        //Crea el objeto de respuesta
        MainControllerResponse response = new MainControllerResponse("Actualizado", "Actualizado", true);
        //Indica el metodo de HTTP con el que el cliente va a realizar la solicitud al endpoint
        requestPut.setMethod("PATCH");
        //Se realiza la solicitud al endpoint de dialogflow
        execute(requestPut, response);
        return response;
    }

    @Override
    public MainControllerResponse delete(EntityItem<R> requestDelete) {
        //Crea el objeto de respuesta
        MainControllerResponse response = new MainControllerResponse("Borrado", "Borrado", true);
        //Indica el metodo de HTTP con el que el cliente va a realizar la solicitud al endpoint
        requestDelete.setMethod("DELETE");
        //Se realiza la solicitud al endpoint de dialogflow
        execute(requestDelete, response);
        return response;
    }
}
