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
 * Modulo:      Area
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad area
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.gob.impi.chatbot.persistence.api.model.domain.Area;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad area
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface AreaMapper {

    @Insert("INSERT INTO areas(name, description, active) VALUES(#{name}, #{description}, #{active});")
    void insert(Area area);

    @Update("UPDATE areas SET name=#{name}, description=#{description}, active=#{active} WHERE id=#{id};")
    void update(Area area);

    @Select("SELECT * FROM areas WHERE id = #{id}")
    Area getAreaById(Integer id);

    @Select("SELECT * FROM areas")
    List<Area> getAll();
}
