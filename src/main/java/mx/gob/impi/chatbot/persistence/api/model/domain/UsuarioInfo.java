/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.model.domain
 * Módulo:      UsuarioInfo
 * Tipo:        Clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Versión:     1.5.9
 *
 * Historia:    RFO 20120801@1129
 *                 revisa (y agrega) JavaDoc requerido
 */
package mx.gob.impi.chatbot.persistence.api.model.domain;

import java.io.Serializable;

/**
 * <p>Descripción:</p>
 * La clase UsuarioInfo.
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class UsuarioInfo implements Serializable {

    /**
     * Representa el valor inicial de la version serial.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Representa al usuario.
     */
    private User usuario;
    /**
     * Representa el detalle del usuario.
     */
    private UsuarioDetalle usuarioDetalle;

    /**
     * Crea una nueva instancia usuario info.
     *
     * @param usuario el usuario
     * @param usuarioDetalle el usuario detalle
     */
    public UsuarioInfo(User usuario, UsuarioDetalle usuarioDetalle) {
        this.usuario = usuario;
        this.usuarioDetalle = usuarioDetalle;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public UsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }

    public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
        if (usuarioDetalle != null) {
            this.usuarioDetalle = usuarioDetalle;
        } else {
            this.usuarioDetalle = new UsuarioDetalle();
        }
    }
}
