package mx.gob.impi.chatbot.persistence.api.model.domain;

public class MainControllerResponse {
    private String message = "";
    private String longMessage = "";
    private boolean succeed = false;

    public MainControllerResponse(){}

    public MainControllerResponse(String message, String longMessage, boolean succeed) {
        this.message = message;
        this.longMessage = longMessage;
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLongMessage() {
        return longMessage;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }
    
}
