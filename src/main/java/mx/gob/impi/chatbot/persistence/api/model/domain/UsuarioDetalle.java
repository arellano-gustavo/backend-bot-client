/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.com.infotec.dadt.arq.core.model
 * Modulo:      UsuarioDetalle
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad usuario_detalle 
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
 * POJO asociado a la entidad usuario_detalle
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class UsuarioDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer usuarioFk;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String telefonos;
    private String direccion;
    private boolean mandaCorreoPromo;

    /**
     * Constructor default de la clase.
     */
    public UsuarioDetalle() {
    }

    /**
     * Constructor con los atributos que conforman la llave de la clase.
     */
    public UsuarioDetalle(Integer usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    public Integer getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(Integer usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isMandaCorreoPromo() {
        return mandaCorreoPromo;
    }

    public void setMandaCorreoPromo(boolean mandaCorreoPromo) {
        this.mandaCorreoPromo = mandaCorreoPromo;
    }
}
