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
 * Clase que lamacena las credenciales para consumir los endpoint
 *
 * Historia:    .
 *              20190913_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.dialogflow.v2.Dialogflow;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

/**
 * <p>Descripción:</p>
 * Clase que proporciona la credenciales para consumir los endpoint
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class DialogflowCredentials {

    private Map<String, GoogleCredentials> bagCredentials;
    private Map<String, Dialogflow> bagClients;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static DialogflowCredentials instance = null;

    /**
     * Metdo estatico para recuperar las credenciales de los agentes
     * @return Objeto con las credenciales para consumir los endpoint
     */
    public static DialogflowCredentials getInstance() {
        if (instance==null) {
            instance = new DialogflowCredentials();
        }
        return instance;
    }

    /**
     * El constructor es privado, no permite que se genere un constructor por defecto.
     */
    private DialogflowCredentials() {

        logger.info("Crea las credenciales de dialogflow {}", "para cada area");

        this.bagCredentials = new HashMap<>();
        this.bagClients= new HashMap<>();

        //Crea las credenciales del area de MARCAS del agente de dialogflow
        create("area1", "Marcas.json");

        //Crea las credenciales del area de PORTAL del agente de dialogflow
        create("area2", "Portal.json");

        //Crea las credenciales del area de PATENTES del agente de dialogflow
        create("area3", "Patentes.json");
        
      //Crea las credenciales del area de Pruebas del agente de dialogflow
        create("area4", "Pruebas.json");
    }

    /**
     * Crea las crdenciales para consumir los agentes de Dialogflow
     * @param area Cadena con el Area del agente que se quiere acceder
     * @param path Cadena con la ruta del archivo de donde secargan las credenciales
     */
    private void create(String area, String path)
    {
        GoogleCredentials credentials = null;
        Dialogflow client;
        String projectId = "";

        //Crea el objeto que contiene las credenciales para conectar al agente de dialogflow
        try {
            logger.info("Carga las crendeciales del agente");
            InputStream stream =
                    DialogflowCredentials
                    .class
                    .getClassLoader()
                    .getResourceAsStream(path);

            credentials = GoogleCredentials.fromStream(stream);//Administrador de la API de Dialogflow

            if (credentials.createScopedRequired()) {
                credentials = credentials.createScoped(Collections.singletonList("https://www.googleapis.com/auth/dialogflow"));
            }
            projectId = ((ServiceAccountCredentials)credentials).getProjectId();

        } catch (FileNotFoundException e) {
            logger.error("No se encuentran las credenciales del {}", area + e.toString());
        } catch (IOException e) {
            logger.error("Error  al abrir las credenciales del {}", area + e.toString());
        }

        //Inicia la creacion de parametros del cliente
        JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();

        com.google.api.client.http.HttpTransport transport = null;
        try {
            transport = GoogleNetHttpTransport.newTrustedTransport();
        } catch (GeneralSecurityException | IOException e) {
            logger.error("Error  al instanciar el transporte para el area {}", area + e.toString());
        }

        //Crea el cliente que realiza las peticiones al agente de dialogflow
        client = new Dialogflow.Builder(transport, jacksonFactory, null).setApplicationName(projectId).build();

        //Guarda la credencial y el criente del area de un agente de dialogflow
        this.bagCredentials.put(area, credentials);
        this.bagClients.put(area, client);

    }

    public Map<String, GoogleCredentials> getBagCredentials() {
        return bagCredentials;
    }

    public Map<String, Dialogflow> getBagClients() {
        return bagClients;
    }
}
