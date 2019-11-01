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
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2EntityType;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.service.EntityTypeService;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar el mapper de 'UserMapper'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest 
public class EntityTypeTest {
    private static final Logger logger = LoggerFactory.getLogger(EntityTypeTest.class);
    
    @Autowired
    private EntityTypeService entityTypeService;
    
    /**
     * Prueba los metodos de recuperacion de usuario
     */
    @Test
    public void whenFindByName_thenReturnEmployee() {
    	/*
		String postData = 
			"{" +
			"        \"displayName\": \"entityTypeTest1\"," +
			"        \"entities\": [" +
			"            {" +
			"                \"synonyms\": [" +
			"                    \"salsa cumbeando\"," +
			"                    \"bachata\"," +
			"                    \"bachata romantica\"" +
			"                ]," +
			"                \"value\": \"pop\"" +
			"            }," +
			"            {" +
			"                \"synonyms\": [" +
			"                    \"rock\"," +
			"                    \"ruidoso\"," +
			"                    \"loco\"" +
			"                ]," +
			"                \"value\": \"rock\"" +
			"            }," +
			"            {" +
			"                \"synonyms\": [" +
			"                    \"balada\"," +
			"                    \"dulce\"," +
			"                    \"melodiosa\"" +
			"                ]," +
			"                \"value\": \"balada\"" +
			"            }," +
			"            {" +
			"                \"synonyms\": [" +
			"                    \"salsa cumbeando\"," +
			"                    \"bachata\"," +
			"                    \"bachata romantica\"" +
			"                ]," +
			"                \"value\": \"salsa\"" +
			"            }" +
			"        ]," +
			"        \"kind\": \"KIND_MAP\"" +
			"  }";
				
		JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
		GoogleCloudDialogflowV2EntityType entityTypePrubea;
		try {
			entityTypePrubea = jacksonFactory.createJsonParser(postData)
			        .parse(GoogleCloudDialogflowV2EntityType.class);
			
			EntityItem<GoogleCloudDialogflowV2EntityType> requestPost = new EntityItem<GoogleCloudDialogflowV2EntityType>();
			requestPost.setAreaId("area1");
			requestPost.setSessionId("9fa2c5fc-ea33-4861-a1ca-165f2c68fae5");
			requestPost.setItem(entityTypePrubea);
			
			MainControllerResponse responseSaveEntityType = entityTypeService.create(requestPost);
			
			assertTrue("Crea entityType", responseSaveEntityType.isSucceed());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		EntityItem<GoogleCloudDialogflowV2EntityType> requestGet = new EntityItem<GoogleCloudDialogflowV2EntityType>();
    	requestGet.setAreaId("area1");
    	requestGet.setSessionId("9fa2c5fc-ea33-4861-a1ca-165f2c68fae5");
    	MainControllerResponse response = new MainControllerResponse("RecuperaTodos", "RecuperaTodos", true);
		GoogleCloudDialogflowV2EntityType allEntityTypes = entityTypeService.list(requestGet, response);
    	
		String identificadorEntityTypeTemp = null;
		String identificadorEntityType = null;
		
		//entityTypes.entrySet().forEach(entry -> {
		for(Entry<String, Object> entry:  allEntityTypes.entrySet()){
		    logger.info("Key : " + entry.getKey() + " Value : " + entry.getValue());
		    
		    @SuppressWarnings("unchecked")
			ArrayList<GoogleCloudDialogflowV2EntityType> listEntityTypes = (ArrayList<GoogleCloudDialogflowV2EntityType>)entry.getValue();
		    Iterator<GoogleCloudDialogflowV2EntityType> iterator = listEntityTypes.iterator();
		    while (iterator.hasNext()){
		    	
		    	Object valor = iterator.next(); 
		    	@SuppressWarnings("unchecked")
				ArrayMap<String, String> entityType = (ArrayMap<String, String>)valor;

		    	for(Entry<String, String> entryEntityType:  entityType.entrySet()){
				    logger.info("Key : " + entryEntityType.getKey() + " Value : " + entryEntityType.getValue());
				    if(entryEntityType.getKey().equals("name")) {
				    	identificadorEntityTypeTemp = entryEntityType.getValue();
				    }
				    else if(entryEntityType.getKey().equals("displayName")) {
				    	logger.info("EntityType: " + entryEntityType.getValue());
				    	if(entryEntityType.getValue().equals("entityTypeTest1")) {
				    		
				    		identificadorEntityType = identificadorEntityTypeTemp;
				    	}
				    	break;
				    }
		    	};
		    }
		};
		
		if(identificadorEntityType!=null) {
			String[] arrOfStr = identificadorEntityType.split("/");
			identificadorEntityType = arrOfStr[arrOfStr.length-1];
		}
		
		assertTrue("Recuepra los entityTypes", response.isSucceed());
		
		response = new MainControllerResponse("Recupera EntityType por id", "Recupera por id", true);
		requestGet.setId(identificadorEntityType);
		
		@SuppressWarnings("unused")
		GoogleCloudDialogflowV2EntityType entityType = entityTypeService.get(requestGet, response);
		
		assertTrue("Obtiene entityType", response.isSucceed());
		
		String patchData = 
				"{" +
						"        \"displayName\": \"entityTypeTest1\"," +
						"        \"entities\": [" +
						"            {" +
						"                \"synonyms\": [" +
						"                    \"salsa cumbeando actualizada\"," +
						"                    \"bachata actualizada\"," +
						"                    \"bachata romantica actualizada\"" +
						"                ]," +
						"                \"value\": \"pop\"" +
						"            }," +
						"            {" +
						"                \"synonyms\": [" +
						"                    \"rock\"," +
						"                    \"ruidoso\"," +
						"                    \"loco\"" +
						"                ]," +
						"                \"value\": \"rock\"" +
						"            }," +
						"            {" +
						"                \"synonyms\": [" +
						"                    \"balada\"," +
						"                    \"dulce\"," +
						"                    \"melodiosa\"" +
						"                ]," +
						"                \"value\": \"balada\"" +
						"            }," +
						"            {" +
						"                \"synonyms\": [" +
						"                    \"salsa cumbeando\"," +
						"                    \"bachata\"," +
						"                    \"bachata romantica\"" +
						"                ]," +
						"                \"value\": \"salsa\"" +
						"            }" +
						"        ]," +
						"        \"kind\": \"KIND_MAP\"" +
						"  }";
		
		try {
			entityTypePrubea = jacksonFactory.createJsonParser(patchData)
			        .parse(GoogleCloudDialogflowV2EntityType.class);
			
			EntityItem<GoogleCloudDialogflowV2EntityType> requestPatch = new EntityItem<GoogleCloudDialogflowV2EntityType>();
			requestPatch.setAreaId("area1");
			requestPatch.setSessionId("9fa2c5fc-ea33-4861-a1ca-165f2c68fae5");
			requestPatch.setItem(entityTypePrubea);
			requestPatch.setId(identificadorEntityType);
			
			MainControllerResponse responseUpdateEntityType = entityTypeService.update(requestPatch);
			
			assertTrue("Actualiza entityType", responseUpdateEntityType.isSucceed());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		EntityItem<GoogleCloudDialogflowV2EntityType> requestDelete = new EntityItem<GoogleCloudDialogflowV2EntityType>();
		requestDelete.setAreaId("area1");
		requestDelete.setSessionId("9fa2c5fc-ea33-4861-a1ca-165f2c68fae5");
		requestDelete.setId(identificadorEntityType);
		
		MainControllerResponse responseDeleteEntityType = entityTypeService.delete(requestDelete);
		
		assertTrue("borra entityType", responseDeleteEntityType.isSucceed());
		
		*/
		
    }

}
