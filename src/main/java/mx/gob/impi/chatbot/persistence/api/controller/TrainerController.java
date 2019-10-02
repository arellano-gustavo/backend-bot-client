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
 * Paquete:     mx.gob.impi.chatbot.persistence.api.controller
 * Modulo:      Trainer
 * Tipo:        Controller
 * Autor:       Gustavo Adolfo Arellano Sandoval (GAA)
 * Fecha:       Lunes 23 de Septiembre de 2019
 * Version:     0.0.1
 * .
 * Clase controller de los servicios rest 
 * para entrenar el chatbot
 *
 * Historia:    .
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Intent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.service.IntentService;

/**
 * <p>Descripción:</p>
 * Implementacion del controlador del trainer
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RestController
@Api(value = "trainer")
@RequestMapping(value = "/api/chatbot/trainer")
public class TrainerController {
	
	IntentService intentService;
	
	@Autowired
	public TrainerController(IntentService intentService) {
		this.intentService = intentService;		
	}
	
	/**
     * Obtiene una lista de intent registrados en el sistema
     * @param requestGet Objeto de tipo 'Intent' 
     *        con los parametros de busqueda
     * @return Objeto de tipo 'Intent' 
     *         con una lista de intent del sistema
     */
    @ApiOperation(
        value = "TrainerController::getAllIntent",
        notes = "Regresa un arreglo de todos los intent en el sistema")
    @RequestMapping(
        value = "/all-intent.json",
        method = GET,
        produces = "application/json; charset=utf-8")
	public ResponseEntity<GoogleCloudDialogflowV2Intent> getAllIntent(@RequestBody EntityItem<GoogleCloudDialogflowV2Intent> requestGet) {
    	MainControllerResponse response = new MainControllerResponse("RecuperaTodos", "RecuperaTodos", true);
		GoogleCloudDialogflowV2Intent intent = intentService.List(requestGet, response);
		return ResponseEntity.ok(intent);
	}
    
    /**
     * Ingresa un intent en el sistema
     * @param requestPost Objeto de tipo 'Intent' a registrar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la insercion
     */
    @ApiOperation(
        value = "TrainerController::insert-intent",
        notes = "Inserta un intent al sistema")
    @RequestMapping(
        value = "/insert-intent.json",
        method = POST,
        produces = "application/json; charset=utf-8")
	public MainControllerResponse insertIntent(@RequestBody EntityItem<GoogleCloudDialogflowV2Intent> requestPost) {
    	MainControllerResponse response = intentService.Create(requestPost);
		return response;
	}
	
    /**
     * Obtiene un intent por medio de su id
     * @param requestGet Objeto de tipo Intent con el Identificador del intent
     * @return Objeto de tipo 'Intent' relacionado a un identificador dado
     */
    @ApiOperation(
        value = "TrainerController::getIntenteById",
        notes = "Regresa un Intent con base en su ID")
    @RequestMapping(
        value = "/get-intent.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public GoogleCloudDialogflowV2Intent getIntentById(@RequestBody EntityItem<GoogleCloudDialogflowV2Intent> requestGet) {
    	MainControllerResponse response = new MainControllerResponse("RecuperaPorId", "RecuperaPorId", true);
		GoogleCloudDialogflowV2Intent intent = intentService.Get(requestGet, response);		
		return intent;
	}	
	
    /**
     * Actualiza un intent registrado en el sistema
     * @param requestPut Objeto de tipo 'Intent' a actualizar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la actualizacion 
     */
    @ApiOperation(
        value = "TrainerController::update-intent",
        notes = "Actualiza un intent en el sistema")
    @RequestMapping(
        value = "/update-intent.json",
        method = PUT,
        produces = "application/json; charset=utf-8")
	public MainControllerResponse updateIntent(@RequestBody EntityItem<GoogleCloudDialogflowV2Intent> requestPut) {
    	MainControllerResponse response = intentService.Update(requestPut);
		return response;
	}
	
    /**
     * Elimina un intent del sistema por medio de su id
     * @param requestDelete Objeto de tipo Intent con el Identificador del intent
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la eliminacion
     */
    @ApiOperation(
        value = "TrainerController::remove-intent",
        notes = "Remueve una intent a un usuario")
    @RequestMapping(
        value = "/remove-intent.json",
        method = DELETE,
        produces = "application/json; charset=utf-8")
	public MainControllerResponse removeIntent(@RequestBody EntityItem<GoogleCloudDialogflowV2Intent> requestDelete) {
    	MainControllerResponse response = intentService.Delete(requestDelete);
		return response;
	}
}
