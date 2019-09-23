/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.model.domain
 * Modulo:      User
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad usuario 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad usuario
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** Llave primaria de un usuario (es un entero incremental) */
    private Integer id;
    
    /** Cadena alfanumérica que identifica a un usuario de manera única */
    private String usr;
    
    /** Cadena alfanumérica que representa un password */
    private String password;
    
    /** Correo electrónico del usuario*/
    private String mail;
    
    /** Fecha en la que se ha creado la cuenta */
    private Date creationDate;
    
    /** Indica si la vida de la CUENTA ha expirado */
    private boolean expiredAccount;
    
    /** Indica si la vida de las credenciales ha expirado */
    private boolean expiredCredential;
    
    /** Indica que la cuenta ha sido bloqueada */
    private boolean bloquedAccount;
    
    /** Indica si la cuenta ha sido inhabilitada */
    private boolean disabled;
    
    /** Contador de intentos de login fallidos */
    private int failedAtemptCounter;
    
    /** Fecha en la que la cuenta ha sido bloqueada*/
    private Date bloquedDate;
    
    private String secretQuestion;
    private String secretAnswer;
    
    private String securityToken;
    private int securityTokenWindow;
    
    /** Indica la última vez que la cuenta fué accedida */
    private Date lastAccessDate;
    
    /** Indica la última vez que la cuenta fué actualizada */
    private Date lastPasswordUpdateDate;

    /**
     * Constructor default de la clase.
     */
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isExpiredAccount() {
        return expiredAccount;
    }

    public void setExpiredAccount(boolean expiredAccount) {
        this.expiredAccount = expiredAccount;
    }

    public boolean isBloquedAccount() {
        return bloquedAccount;
    }

    public void setBloquedAccount(boolean bloquedAccount) {
        this.bloquedAccount = bloquedAccount;
    }

    public boolean isExpiredCredential() {
        return expiredCredential;
    }

    public void setExpiredCredential(boolean expiredCredential) {
        this.expiredCredential = expiredCredential;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getFailedAtemptCounter() {
        return failedAtemptCounter;
    }

    public void setFailedAtemptCounter(int failedAtemptCounter) {
        this.failedAtemptCounter = failedAtemptCounter;
    }

    public Date getBloquedDate() {
        return bloquedDate;
    }

    public void setBloquedDate(Date bloquedDate) {
        this.bloquedDate = bloquedDate;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public int getSecurityTokenWindow() {
        return securityTokenWindow;
    }

    public void setSecurityTokenWindow(int securityTokenWindow) {
        this.securityTokenWindow = securityTokenWindow;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public Date getLastPasswordUpdateDate() {
        return lastPasswordUpdateDate;
    }

    public void setLastPasswordUpdateDate(Date lastPasswordUpdateDate) {
        this.lastPasswordUpdateDate = lastPasswordUpdateDate;
    }
}