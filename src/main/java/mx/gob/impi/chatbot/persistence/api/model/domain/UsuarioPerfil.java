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
 * Modulo:      UsuarioPerfil
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad usuario_perfil 
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
 * POJO asociado a la entidad usuario_perfil
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class UsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer usuarioFk;
    private Integer perfilFk;

    /**
     * Constructor default de la clase.
     */
    public UsuarioPerfil() {
    }

    /**
     * Constructor con los atributos que conforman la llave de la clase.
     */
    public UsuarioPerfil(Integer usuarioFk, Integer perfilFk) {
        this.usuarioFk = usuarioFk;
        this.perfilFk = perfilFk;
    }

    public Integer getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(Integer usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    public Integer getPerfilFk() {
        return perfilFk;
    }

    public void setPerfilFk(Integer perfilFk) {
        this.perfilFk = perfilFk;
    }
}
