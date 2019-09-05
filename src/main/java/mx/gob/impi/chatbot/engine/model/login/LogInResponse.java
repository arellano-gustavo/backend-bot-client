/*
 *    Proyecto: Chatbot Ultra
 *       Fecha: 05/09/2019
 *       Autor: David Corza
 * Descripción: Clase para la respuesta del chatbot.
 */
package mx.gob.impi.chatbot.engine.model.login;

/**
 *  Clase para la respuesta del chatbot.
 * @author David Corza
 */
public class LogInResponse {
    private String usuario;
    private String idusuario;
    
    /**
     *
     */
    public LogInResponse() {
    }

    /**
     *
     * @param usuario
     * @param idusuario
     */
    public LogInResponse(String usuario, String idusuario) {
        this.usuario = usuario;
        this.idusuario = idusuario;        
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getIdsuario() {
        return idusuario;
    }

    /**
     *
     * @param idusuario
     */
    public void setIdsuario(String idusuario) {
        this.idusuario = idusuario;
    }
}
