/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.db
 * Modulo:      UsuarioPerfil
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad usuario_perfil 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import mx.gob.impi.chatbot.persistence.api.model.domain.UsuarioPerfil;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad usuario_perfil
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UsuarioPerfilMapper extends IMapper<UsuarioPerfil> {

    /**
     * Elimina al usuario con el número de Id especificado como argumento.
     *
     * @param idUser Número Id asociado a un usuario.
     *
     */
    void deleteByIdUsuario(Integer idUser);
    
}
