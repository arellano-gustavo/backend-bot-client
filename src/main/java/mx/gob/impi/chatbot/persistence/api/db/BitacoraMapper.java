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
 * Paquete:     mx.gob.impi.chatbot.persistence.api.db
 * Modulo:      Bitacora
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad bitacora 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import mx.gob.impi.chatbot.persistence.api.model.domain.Bitacora;
import mx.gob.impi.chatbot.persistence.api.model.domain.DateWrapper;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad bitacora
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface BitacoraMapper extends IMapper<Bitacora> {

    /**
     * Actualiza los campos de la bitácora, salvo el campo action.
     * @param bitacora Instancia con los valores a actualizar.
     */
    void upeventDate(Bitacora bitacora);
    
    /**
     * Realiza la tarea de limpieza de un objeto de tipo DateWrapper.
     *
     * @param dw Instancia del objeto DateWrapper que se desea limpiar.
     */
    void clean(DateWrapper dateWrapper);
}
