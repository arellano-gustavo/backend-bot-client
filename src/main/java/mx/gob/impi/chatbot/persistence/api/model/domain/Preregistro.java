/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.com.infotec.dadt.arq.core.model
 * Modulo:      Preregistro
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad preregistro 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.model.domain;

import java.io.Serializable;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad preregistro
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class Preregistro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer preregistroPk;
    private String correo;
    private String idSeguridad;
    private java.util.Date ventanaParaIdSeguridad;

    /**
     * Constructor default de la clase.
     */
    public Preregistro() {
    }

    /**
     * Constructor con los atributos que conforman la llave de la clase.
     */
    public Preregistro(Integer preregistroPk) {
        this.preregistroPk = preregistroPk;
    }

    public Integer getPreregistroPk() {
        return preregistroPk;
    }

    public void setPreregistroPk(Integer preregistroPk) {
        this.preregistroPk = preregistroPk;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdSeguridad() {
        return idSeguridad;
    }

    public void setIdSeguridad(String idSeguridad) {
        this.idSeguridad = idSeguridad;
    }

    public java.util.Date getVentanaParaIdSeguridad() {
        return ventanaParaIdSeguridad;
    }

    public void setVentanaParaIdSeguridad(java.util.Date ventanaParaIdSeguridad) {
        this.ventanaParaIdSeguridad = ventanaParaIdSeguridad;
    }
}
