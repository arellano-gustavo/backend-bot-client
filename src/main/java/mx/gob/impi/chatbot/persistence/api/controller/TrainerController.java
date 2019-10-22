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

import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Context;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2EntityType;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Intent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.service.ContextService;
import mx.gob.impi.chatbot.persistence.api.service.EntityTypeService;
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
    private IntentService intentService;
    private EntityTypeService entityTypeService;
    private ContextService contextService;

    /**
     * Inicicializa los servicio que utilizaran los controladores
     * Se utiliza construccion de dependecias por contruccion
     * porque se envia el objeto que se crea a las calses padre
     */
    @Autowired
    public TrainerController(IntentService intentService, EntityTypeService entityTypeService, ContextService contextService) {
        this.intentService = intentService;
        this.entityTypeService = entityTypeService;
        this.contextService = contextService;
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
        method = POST,
        produces = "application/json; charset=utf-8")
    public ResponseEntity<GoogleCloudDialogflowV2Intent> getAllIntent(@RequestBody EntityItem<GoogleCloudDialogflowV2Intent> requestGet) {
        MainControllerResponse response = new MainControllerResponse("RecuperaTodos", "RecuperaTodos", true);
        GoogleCloudDialogflowV2Intent intent = intentService.list(requestGet, response);
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
        MainControllerResponse response = intentService.create(requestPost);
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
        method = POST,
        produces = "application/json; charset=utf-8")
    public GoogleCloudDialogflowV2Intent getIntentById(@RequestBody EntityItem<GoogleCloudDialogflowV2Intent> requestGet) {
        MainControllerResponse response = new MainControllerResponse("RecuperaPorId", "RecuperaPorId", true);
        GoogleCloudDialogflowV2Intent intent = intentService.get(requestGet, response);
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
        MainControllerResponse response = intentService.update(requestPut);
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
        MainControllerResponse response = intentService.delete(requestDelete);
        return response;
    }



    /**
     * Obtiene una lista de entityType registrados en el sistema
     * @param requestGet Objeto de tipo 'EntityType'
     *        con los parametros de busqueda
     * @return Objeto de tipo 'EntityType'
     *         con una lista de entityType del sistema
     */
    @ApiOperation(
        value = "TrainerController::getAllEntityType",
        notes = "Regresa un arreglo de todos los entityType en el sistema")
    @RequestMapping(
        value = "/all-entityType.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public ResponseEntity<GoogleCloudDialogflowV2EntityType> getAllEntityType(@RequestBody EntityItem<GoogleCloudDialogflowV2EntityType> requestGet) {
        MainControllerResponse response = new MainControllerResponse("RecuperaTodos", "RecuperaTodos", true);
        GoogleCloudDialogflowV2EntityType entityType = entityTypeService.list(requestGet, response);
        return ResponseEntity.ok(entityType);
    }

    /**
     * Ingresa un entityType en el sistema
     * @param requestPost Objeto de tipo 'EntityType' a registrar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la insercion
     */
    @ApiOperation(
        value = "TrainerController::insert-entityType",
        notes = "Inserta un entityType al sistema")
    @RequestMapping(
        value = "/insert-entityType.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertEntityType(@RequestBody EntityItem<GoogleCloudDialogflowV2EntityType> requestPost) {
        MainControllerResponse response = entityTypeService.create(requestPost);
        return response;
    }

    /**
     * Obtiene un entityType por medio de su id
     * @param requestGet Objeto de tipo EntityType con el Identificador del entityType
     * @return Objeto de tipo 'EntityType' relacionado a un identificador dado
     */
    @ApiOperation(
        value = "TrainerController::getEntityTypeeById",
        notes = "Regresa un EntityType con base en su ID")
    @RequestMapping(
        value = "/get-entityType.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public GoogleCloudDialogflowV2EntityType getEntityTypeById(@RequestBody EntityItem<GoogleCloudDialogflowV2EntityType> requestGet) {
        MainControllerResponse response = new MainControllerResponse("RecuperaPorId", "RecuperaPorId", true);
        GoogleCloudDialogflowV2EntityType entityType = entityTypeService.get(requestGet, response);
        return entityType;
    }

    /**
     * Actualiza un entityType registrado en el sistema
     * @param requestPut Objeto de tipo 'EntityType' a actualizar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la actualizacion
     */
    @ApiOperation(
        value = "TrainerController::update-entityType",
        notes = "Actualiza un entityType en el sistema")
    @RequestMapping(
        value = "/update-entityType.json",
        method = PUT,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse updateEntityType(@RequestBody EntityItem<GoogleCloudDialogflowV2EntityType> requestPut) {
        MainControllerResponse response = entityTypeService.update(requestPut);
        return response;
    }

    /**
     * Elimina un entityType del sistema por medio de su id
     * @param requestDelete Objeto de tipo EntityType con el Identificador del entityType
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la eliminacion
     */
    @ApiOperation(
        value = "TrainerController::remove-entityType",
        notes = "Remueve una entityType a un usuario")
    @RequestMapping(
        value = "/remove-entityType.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse removeEntityType(@RequestBody EntityItem<GoogleCloudDialogflowV2EntityType> requestDelete) {
        MainControllerResponse response = entityTypeService.delete(requestDelete);
        return response;
    }


    /**
     * Obtiene una lista de context registrados en el sistema
     * @param requestGet Objeto de tipo 'Context'
     *        con los parametros de busqueda
     * @return Objeto de tipo 'Context'
     *         con una lista de context del sistema
     */
    @ApiOperation(
        value = "TrainerController::getAllContext",
        notes = "Regresa un arreglo de todos los context en el sistema")
    @RequestMapping(
        value = "/all-context.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public ResponseEntity<GoogleCloudDialogflowV2Context> getAllContext(@RequestBody EntityItem<GoogleCloudDialogflowV2Context> requestGet) {
        MainControllerResponse response = new MainControllerResponse("RecuperaTodos", "RecuperaTodos", true);
        GoogleCloudDialogflowV2Context context = contextService.list(requestGet, response);
        return ResponseEntity.ok(context);
    }

    /**
     * Ingresa un context en el sistema
     * @param requestPost Objeto de tipo 'Context' a registrar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la insercion
     */
    @ApiOperation(
        value = "TrainerController::insert-context",
        notes = "Inserta un context al sistema")
    @RequestMapping(
        value = "/insert-context.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse insertContext(@RequestBody EntityItem<GoogleCloudDialogflowV2Context> requestPost) {
        MainControllerResponse response = contextService.create(requestPost);
        return response;
    }

    /**
     * Obtiene un context por medio de su id
     * @param requestGet Objeto de tipo Context con el Identificador del context
     * @return Objeto de tipo 'Context' relacionado a un identificador dado
     */
    @ApiOperation(
        value = "TrainerController::getContexteById",
        notes = "Regresa un Context con base en su ID")
    @RequestMapping(
        value = "/get-context.json",
        method = GET,
        produces = "application/json; charset=utf-8")
    public GoogleCloudDialogflowV2Context getContextById(@RequestBody EntityItem<GoogleCloudDialogflowV2Context> requestGet) {
        MainControllerResponse response = new MainControllerResponse("RecuperaPorId", "RecuperaPorId", true);
        GoogleCloudDialogflowV2Context context = contextService.get(requestGet, response);
        return context;
    }

    /**
     * Actualiza un context registrado en el sistema
     * @param requestPut Objeto de tipo 'Context' a actualizar
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la actualizacion
     */
    @ApiOperation(
        value = "TrainerController::update-context",
        notes = "Actualiza un context en el sistema")
    @RequestMapping(
        value = "/update-context.json",
        method = PUT,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse updateContext(@RequestBody EntityItem<GoogleCloudDialogflowV2Context> requestPut) {
        MainControllerResponse response = contextService.update(requestPut);
        return response;
    }

    /**
     * Elimina un context del sistema por medio de su id
     * @param requestDelete Objeto de tipo Context con el Identificador del context
     * @return Objeto de tipo 'MainControllerResponse'
     *         con el resultado de la eliminacion
     */
    @ApiOperation(
        value = "TrainerController::remove-context",
        notes = "Remueve una context a un usuario")
    @RequestMapping(
        value = "/remove-context.json",
        method = DELETE,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse removeContext(@RequestBody EntityItem<GoogleCloudDialogflowV2Context> requestDelete) {
        MainControllerResponse response = contextService.delete(requestDelete);
        return response;
    }
}
