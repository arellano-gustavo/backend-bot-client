package mx.gob.impi.chatbot.engine.agent;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import mx.gob.impi.chatbot.engine.utils.Support;

public class AIAgent {
    private Map<String, AIWorker> bag = new HashMap<>();
    private static AIAgent instance = null;

    public static AIAgent getInstance() {
        if (instance==null) {
            instance = new AIAgent();
        }
        return instance;
    }

    private AIAgent() {
        Properties mapa = Support.loadProps();
        for(Object key : mapa.keySet()) {
            bag.put(key.toString(), new AIWorker(mapa.get(key.toString()).toString()));
        }
    }

    public AIWorker getWorker(String nameNumber) {
        AIWorker worker = this.bag.get("area_"+nameNumber);
        if (worker==null) {
            throw new RuntimeException("Critical Error. NOT found area: area_"+nameNumber);
        }
        return worker;
    }
}
