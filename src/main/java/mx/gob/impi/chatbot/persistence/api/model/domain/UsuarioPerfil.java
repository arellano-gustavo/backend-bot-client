/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.com.infotec.dadt.arq.core.model
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
