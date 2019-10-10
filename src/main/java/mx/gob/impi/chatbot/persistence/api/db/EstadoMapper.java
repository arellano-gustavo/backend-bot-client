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
 * Modulo:      EstadosMapper
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       viernes 20 de septiembre de 2019 (17_20)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface    'EstadosMapper' MyBatis asociado a la entidad estados
 *
 * Historia:    .
 *              20190920_1720 Generado GOOSE
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.gob.impi.chatbot.persistence.api.model.estado.EstadoPojo;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad estados
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface EstadoMapper {
    @Insert("Insert into estado(estado_pk, nombre) values (#{estado_pk}, #{nombre})")
    @Results(value = {
            @Result(property = "estadoPk", column = "estado_pk"),
            @Result(property="nombre", column = "nombre")
          })
    Integer insert(EstadoPojo estado);

    @Select("select * from Estado")
    List<EstadoPojo> getAll();
}
