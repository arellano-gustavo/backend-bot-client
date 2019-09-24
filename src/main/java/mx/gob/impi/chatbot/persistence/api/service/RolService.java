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
 * Modulo:      Rol
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de rol
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.util.List;

import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.Rol;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de 'rol'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface RolService {
	/**
	 * Proporciona la lista de los Roles registrados, estén o no activos.
	 * @return Objeto de tipo 'List' con la totalidad de los Roles registrados.
	 */
    List<Rol> getAll();
    
    /**
     * Proporciona un objeto de tipo 'Rol' cuyo id es proporcionado.
     * @param id Entero con el id (llave primaria) de una Rol.
     * @return
     */
    Rol getRolById(Integer id);
    
    /**
     * Guarda en la base de datos el objeto de tipo 'Rol' proporcionado.
     * @param rol Objeto de tipo 'Rol' a almacenar.
     * @return
     */
    MainControllerResponse save(Rol rol);
    
    /**
     * Actualiza en la base de datos el objeto de tipo 'Rol' proporcionado.
     * @param rol Objeto de tipo 'Rol' a actualizar.
     * @return Objeto de tipo 'MainControllerResponse' que contiene el resultado de la operación de actualzación.
     */
    MainControllerResponse update(Rol rol);
}
