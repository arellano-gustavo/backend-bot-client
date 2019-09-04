/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.impi.chatbot.engine.model.login;

/**
 *
 * @author David Corza
 */
public class LogInRequest {
    private String email;
    private String contra;
    
    public LogInRequest() {
    }
    public LogInRequest(String email, String contra) {
        this.email = email;
        this.contra = contra;        
    }
    public String getEmail() {        
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContra() {        
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }
}
