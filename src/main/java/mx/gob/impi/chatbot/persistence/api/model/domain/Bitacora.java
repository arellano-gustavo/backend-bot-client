/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.com.infotec.dadt.arq.core.model
 * Modulo:      Bitacora
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad bitacora 
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
 * POJO asociado a la entidad bitacora
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class Bitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer bitacoraPk;
    private String username;
    private String ip;
    private Date eventDate;
    private Integer action;
    private String extraInfo;

    /**
     * Constructor default de la clase.
     */
    public Bitacora() {
    }

    /**
     * Constructor con los atributos que conforman la llave de la clase.
     */
    public Bitacora(Integer bitacoraPk) {
        this.bitacoraPk = bitacoraPk;
    }

    /**
     * Constructor con todos los atributos de la clase.
     */
    public Bitacora(Integer bitacoraPk, String username, String ip, Date eventDate, Integer action, String extraInfo) {
        this.bitacoraPk = bitacoraPk;
        this.username = username;
        this.ip = ip;
        this.eventDate = eventDate;
        this.action = action;
        this.extraInfo = extraInfo;
    }

    public Integer getBitacoraPk() {
        return bitacoraPk;
    }

    public void setBitacoraPk(Integer bitacoraPk) {
        this.bitacoraPk = bitacoraPk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
