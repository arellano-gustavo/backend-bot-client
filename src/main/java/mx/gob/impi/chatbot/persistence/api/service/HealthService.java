package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;
import java.util.Map;

public interface HealthService {
	Map<String, String> getInfo(String data) throws Exception;
	List<String> getLog(int last);
}
