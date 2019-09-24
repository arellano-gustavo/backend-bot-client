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
 * Paquete:     mx.gob.impi.chatbot.persistence.api.service
 * Modulo:      User
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de persona
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.Area;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de 'area'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface AreaService {
    /**
     * Proporciona la lista de Areas registradas, estén o no activas.
     * 
     * @return Objeto de tipo 'List' con la totalidad de Areas registradas.
     */
    List<Area> getAll();
    /**
     * Proporciona un objeto de tipo 'Area' cuyo id es proporcionado.
     * @param id Entero con el id (llave primaria) de una Area.
     * 
     * @return Objeto de tipo 'Area' asociado al id proporcionado.
     */
    Area getAreaById(Integer id);
    /**
     * Guarda en la base de datos el objeto de tipo 'Area' proporcionado.
     * @param area Objeto de tipo 'Area' a almacenar.
     * 
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de guardado.
     */
    MainControllerResponse save(Area area);
    /**
     * Actualiza en la base de datos el objeto de tipo 'Area' proporcionado.
     * @param area Objeto de tipo 'Area' a actualizar.
     * 
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de actualzación.
     */
    MainControllerResponse update(Area area);
}
