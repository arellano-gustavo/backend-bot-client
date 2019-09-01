package mx.gob.impi.chatbot.engine.service;

import org.apache.log4j.Logger;

import mx.gob.impi.chatbot.engine.agent.AIAgent;
import mx.gob.impi.chatbot.engine.agent.AIWorker;
import mx.gob.impi.chatbot.engine.model.ChatbotRequest;

public class TextClientSrvImpl implements TextClientSrv {
    private final static Logger logger = Logger.getLogger(TextClientSrvImpl.class);
    
    @Override
    public String response(String areaNumber, String challenge, String idUsuario) {
        logger.info("Calling Agent instance...");
        logger.info("Información recibida del usuario: "+ idUsuario);
        AIWorker worker = AIAgent.getInstance().getWorker(areaNumber);
        logger.info("Sending Challenge -->" + challenge + "<--");
        return worker.response(challenge);
    }

    @Override
    public String response(ChatbotRequest challenge) {
        logger.info("Calling Agent instance...");
        logger.info("Información recibida del usuario: "+ challenge.getUid());
        AIWorker worker = AIAgent.getInstance().getWorker(challenge.getArea());
        logger.info("Sending Challenge -->" + challenge + "<--");
        return worker.response(challenge.getChallenge());
    }
}
