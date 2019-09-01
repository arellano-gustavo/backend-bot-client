package mx.gob.impi.chatbot.engine.agent;

import org.apache.log4j.Logger;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

public class AIWorker {
    private final static Logger logger = Logger.getLogger(AIWorker.class);
    private AIDataService dataService = null;

    public AIWorker(String apikey) {
        logger.info("Constructor Inicialization Invoked...");
        logger.info("Creating AIConfguration....");
        AIConfiguration configuration = new AIConfiguration(apikey);
        logger.info("Creating AIDataService....");
        this.dataService = new AIDataService(configuration);
    }

    public String response(String challenge) {
        logger.info("Sending Challenge: " + challenge);
        try {
            AIRequest request = new AIRequest(challenge);
            AIResponse response = dataService.request(request);
            if (response.getStatus().getCode() == 200) {
                return response.getResult().getFulfillment().getSpeech();
            } else {
                return response.getStatus().getErrorDetails();
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
}
