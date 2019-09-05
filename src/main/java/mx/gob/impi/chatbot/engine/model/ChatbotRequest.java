package mx.gob.impi.chatbot.engine.model;

/**
 *
 * @author Administrador
 */
public class ChatbotRequest {
    private String challenge;
    private String area;
    private String uid;

    /**
     *
     */
    public ChatbotRequest() {
    }

    /**
     *
     * @param challenge
     * @param area
     * @param uid
     */
    public ChatbotRequest(String challenge, String area, String uid) {
        this.challenge = challenge;
        this.area = area;
        this.uid = uid;
    }

    /**
     *
     * @return
     */
    public String getChallenge() {
        return challenge;
    }

    /**
     *
     * @param challenge
     */
    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    /**
     *
     * @return
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     *
     * @return
     */
    public String getUid() {
        return uid;
    }

    /**
     *
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
}
