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
public class LogInResponse {
    private String usuario;
    private String idusuario;
    
    public LogInResponse() {
    }
    public LogInResponse(String usuario, String idusuario) {
        this.usuario = usuario;
        this.idusuario = idusuario;        
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getIdsuario() {
        return idusuario;
    }
    public void setIdsuario(String idusuario) {
        this.idusuario = idusuario;
    }
}
