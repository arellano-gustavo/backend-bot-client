package mx.gob.impi.chatbot.persistence.api.model.domain;

public class LoginResponse {
    private String user = "";
    private String message = "";
    private String longMessage = "";
    private String jwt = "";
    private boolean succeed = false;
    
    public LoginResponse() {
    }
    
    public LoginResponse(String user, boolean succeed, String message) {
        this.user = user;
        this.succeed = succeed;
        this.message = message;
    }
    
    public boolean isSucceed() {
        return succeed;
    }
    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getLongMessage() {
        return longMessage;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
    }
}
