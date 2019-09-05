/*
 *    Proyecto: Chatbot Ultra
 *       Fecha: 05/09/2019
 *       Autor: David Corza
 * Descripción: Clase que genera la solicitud de login, para el chatbot.
 */
package mx.gob.impi.chatbot.engine.model.login;

/**
 * Clase que genera la solicitud de login, para el chatbot.
 * @author David Corza
 */
public class LogInRequest {
    private String email;
    private String contra;
    
    /**
     *
     */
    public LogInRequest() {
    }

    /**
     *
     * @param email
     * @param contra
     */
    public LogInRequest(String email, String contra) {
        this.email = email;
        this.contra = contra;        
    }

    /**
     *
     * @return
     */
    public String getEmail() {        
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getContra() {        
        return contra;
    }

    /**
     *
     * @param contra
     */
    public void setContra(String contra) {
        this.contra = contra;
    }
}
