package mx.gob.impi.chatbot.engine.model;

public class ChatbotRequest {
    private String challenge;
    private String area;
    private String uid;

    public ChatbotRequest() {
    }

    public ChatbotRequest(String challenge, String area, String uid) {
        this.challenge = challenge;
        this.area = area;
        this.uid = uid;
    }
    public String getChallenge() {
        return challenge;
    }
    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    
}
