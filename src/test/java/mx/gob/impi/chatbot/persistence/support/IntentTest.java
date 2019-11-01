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
 * Modulo:      MybatisTest
 * Tipo:        CLASE 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 27 de Septiembre de 2019 (18_11)
 * Version:     1.0-SNAPSHOT
 * .
 * Test de UserMapper
 *
 * Historia:    .
 *              20190927_1811 Creación de la prueba unitaria
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ArrayMap;
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2Intent;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.service.IntentService;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar el mapper de 'UserMapper'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest 
public class IntentTest {
    private static final Logger logger = LoggerFactory.getLogger(IntentTest.class);
    
    @Autowired
    private IntentService intentService;
    
    /**
     * Prueba los metodos de recuperacion de usuario
     */
    @Test
    public void whenFindByName_thenReturnEmployee() {
    	
		String postData = 
				  "{" +
				  "  \"displayName\":\"intentTest1\"," +
				  "  \"trainingPhrases\":" +
				  "  [" +
				  "    {" +
				  "      \"parts\":[" +
				  "        {" +
				  "          \"text\":\"frase uno\"" +
				  "        },{" +
				  "          \"text\":\" phrases\"" +
				  "        }" +
				  "      ]" +
				  "    }," +
				  "    {" +
				  "      \"parts\":[" +
				  "        {" +
				  "          \"text\":\"frase dos\"" +
				  "        },{" +
				  "          \"text\":\" phrases\"" +
				  "        }" +
				  "      ]" +
				  "    }," +
				  "    {" +
				  "      \"parts\":[" +
				  "        {" +
				  "          \"text\":\"frase tres\"" +
				  "        },{" +
				  "          \"text\":\" phrases\"" +
				  "        }" +
				  "      ]" +
				  "    }" +
				  "  ]" +
				  "}";
				
		JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
		GoogleCloudDialogflowV2Intent intentPrubea;
		try {
			intentPrubea = jacksonFactory.createJsonParser(postData)
			        .parse(GoogleCloudDialogflowV2Intent.class);
			
			EntityItem<GoogleCloudDialogflowV2Intent> requestPost = new EntityItem<GoogleCloudDialogflowV2Intent>();
			requestPost.setAreaId("area1");
			requestPost.setSessionId("9fa2c5fc-ea33-4861-a1ca-165f2c68fae5");
			requestPost.setItem(intentPrubea);
			
			MainControllerResponse responseSaveIntent = intentService.create(requestPost);
			
			assertTrue("Crea intent", responseSaveIntent.isSucceed());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		EntityItem<GoogleCloudDialogflowV2Intent> requestGet = new EntityItem<GoogleCloudDialogflowV2Intent>();
    	requestGet.setAreaId("area1");
    	requestGet.setSessionId("9fa2c5fc-ea33-4861-a1ca-165f2c68fae5");
    	MainControllerResponse response = new MainControllerResponse("RecuperaTodos", "RecuperaTodos", true);
		GoogleCloudDialogflowV2Intent allIntents = intentService.list(requestGet, response);
    	
		String identificadorIntentTemp = null;
		String identificadorIntent = null;
		
		//intents.entrySet().forEach(entry -> {
		for(Entry<String, Object> entry:  allIntents.entrySet()){
		    logger.info("Key : " + entry.getKey() + " Value : " + entry.getValue());
		    
		    @SuppressWarnings("unchecked")
			ArrayList<GoogleCloudDialogflowV2Intent> listIntents = (ArrayList<GoogleCloudDialogflowV2Intent>)entry.getValue();
		    Iterator<GoogleCloudDialogflowV2Intent> iterator = listIntents.iterator();
		    while (iterator.hasNext()){
		    	
		    	Object valor = iterator.next(); 
		    	@SuppressWarnings("unchecked")
				ArrayMap<String, String> intent = (ArrayMap<String, String>)valor;

		    	for(Entry<String, String> entryIntent:  intent.entrySet()){
				    logger.info("Key : " + entryIntent.getKey() + " Value : " + entryIntent.getValue());
				    if(entryIntent.getKey().equals("name")) {
				    	identificadorIntentTemp = entryIntent.getValue();
				    }
				    else if(entryIntent.getKey().equals("displayName")) {
				    	logger.info("Intent: " + entryIntent.getValue());
				    	if(entryIntent.getValue().equals("intentTest1")) {
				    		identificadorIntent = identificadorIntentTemp;
				    	}
				    	break;
				    }
		    	};
		    }
		};
		
		if(identificadorIntent!=null) {
			String[] arrOfStr = identificadorIntent.split("/");
			identificadorIntent = arrOfStr[arrOfStr.length-1];
		}
		
		assertTrue("Recuepra los intents", response.isSucceed());
		
		response = new MainControllerResponse("Recupera Intent por id", "Recupera por id", true);
		requestGet.setId(identificadorIntent);
		
		@SuppressWarnings("unused")
		GoogleCloudDialogflowV2Intent intent = intentService.get(requestGet, response);
		
		assertTrue("Obtiene intent", response.isSucceed());
		
		String patchData = 
				  "{" +
				  "  \"displayName\":\"intentTest1\"," +
				  "  \"trainingPhrases\":" +
				  "  [" +
				  "    {" +
				  "      \"parts\":[" +
				  "        {" +
				  "          \"text\":\"frase uno actualizada\"" +
				  "        },{" +
				  "          \"text\":\" phrases\"" +
				  "        }" +
				  "      ]" +
				  "    }," +
				  "    {" +
				  "      \"parts\":[" +
				  "        {" +
				  "          \"text\":\"frase dos actualizada\"" +
				  "        },{" +
				  "          \"text\":\" phrases\"" +
				  "        }" +
				  "      ]" +
				  "    }," +
				  "    {" +
				  "      \"parts\":[" +
				  "        {" +
				  "          \"text\":\"frase tres actualizada\"" +
				  "        },{" +
				  "          \"text\":\" phrases\"" +
				  "        }" +
				  "      ]" +
				  "    }" +
				  "  ]" +
				  "}";
		
		try {
			intentPrubea = jacksonFactory.createJsonParser(patchData)
			        .parse(GoogleCloudDialogflowV2Intent.class);
			
			EntityItem<GoogleCloudDialogflowV2Intent> requestPatch = new EntityItem<GoogleCloudDialogflowV2Intent>();
			requestPatch.setAreaId("area1");
			requestPatch.setSessionId("9fa2c5fc-ea33-4861-a1ca-165f2c68fae5");
			requestPatch.setItem(intentPrubea);
			requestPatch.setId(identificadorIntent);
			
			MainControllerResponse responseUpdateIntent = intentService.update(requestPatch);
			
			assertTrue("Actualiza intent", responseUpdateIntent.isSucceed());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		EntityItem<GoogleCloudDialogflowV2Intent> requestDelete = new EntityItem<GoogleCloudDialogflowV2Intent>();
		requestDelete.setAreaId("area1");
		requestDelete.setSessionId("9fa2c5fc-ea33-4861-a1ca-165f2c68fae5");
		requestDelete.setId(identificadorIntent);
		
		MainControllerResponse responseDeleteIntent = intentService.delete(requestDelete);
		
		assertTrue("borra intent", responseDeleteIntent.isSucceed());
		
		
		
    }

}
