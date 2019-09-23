package mx.gob.impi.chatbot.persistence.api.model.domain;

import java.io.Serializable;

public class UserArea implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int idUser;
    private int idArea;
    
    public UserArea(){
    }
    
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public int getIdArea() {
        return idArea;
    }
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
    
}
