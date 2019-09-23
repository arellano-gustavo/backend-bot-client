/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.db
 * Modulo:      Preregistro
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad preregistro 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import mx.gob.impi.chatbot.persistence.api.model.domain.DateWrapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.Preregistro;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad preregistro
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface PreregistroMapper extends IMapper<Preregistro> {

    /**
     * Obtiene un pre-registro realizando la búsqueda por correo electrónico.
     *
     * @param correo Dirección de correo electrónico.
     *
     * @return El pre-registro encontrado asociado a la dirección de correo 
     * electrónico.
     */
    Preregistro getByCorreo(String correo);

    /**
     * Obtiene un pre-registro realizando la búsqueda por Id de Seguridad.
     *
     * @param idSeguridad Id de seguridad del usuario.
     *
     * @return El pre-registro encontrado asociado al Id de seguridad.
     */
    Preregistro getByIdSeguridad(String idSeguridad);

    /**
     * Realiza la tarea de eliminar los objetos antiguos.
     *
     * @param dw Instancia del DateWrapper de referencia para relizar la tarea.
     */
    void deleteOldones(DateWrapper dateWrapper);
}
