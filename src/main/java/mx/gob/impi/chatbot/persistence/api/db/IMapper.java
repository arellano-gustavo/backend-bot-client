/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    Chatbot IMPI persistence
 * Paquete:     mx.gob.impi.chatbot.persistence.api.db
 * Modulo:      Mapper
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       viernes 20 de septiembre de 2019 (17_20)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface    'Mapper' MyBatis asociado a los metos que deben
 *              implementar todos los mapper de la entidades 
 *
 * Historia:    .
 *              20190920_1720 Generado GOOSE
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Descripción:</p>
 * Interfaz genérica que define los métodos persistentes que obligatoriamente
 * debe exponer todo Mapper. Cada implementación debe usar el genérico que le
 * corresponda.
 *
 * @param T El tipo genérico
 * @author Gustavo Adolfo Arellano (GAA)
 * @version 1.1.56
 */
public interface IMapper<T> extends Serializable {

    /**
     * Retorna un objeto del mismo tipo que el argumento dado, pero con el
     * estado completo y lleno. El argumento sólo lleva los atributos que
     * definen la llave primaria.
     *
     * @param obj Objeto sin estado, sólo con su PK establecida
     * @return T : Objeto con estado
     */
    T getById(T obj);

    /**
     * Retorna una lista de objetos de un mismo tipo '&lt;T&gt;' con estado
     * acorde al persistido en la base de datos.
     *
     * @return Lista de objetos de un mismo tipo con estado acorde al persistido
     * en la base de datos.
     */
    List<T> getAll();

    /**
     * Inserta el registro representado por el argumento
     *
     * @param obj El objeto a insertar
     */
    void insert(T obj);

    /**
     * Actualiza el registro representado por el argumento
     *
     * @param obj El objeto que se someterá a actualización
     */
    void update(T obj);

    /**
     * Elimina (lógica o físicamente) el registro representado por el argumento
     *
     * @param obj El objeto que se va a eliminar
     */
    void delete(T obj);

    /**
     * Retorna el valor siguiente en la secuencia de la entidad '&lt;T&gt;'
     *
     * @return entero calculado
     */
    int getNextSequenceValue();
}
