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
 * Modulo:      User
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (12_32)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad usuario area 
 *
 * Historia:    .
 *              20190920_12_32 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserArea;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'UserArea'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UserAreaMapper {
    @Insert("INSERT INTO user_area(id_user, id_area) VALUES(#{idUser}, #{idArea}) ")
    void insert(Integer idUser, Integer idArea);
    
    @Delete("DELETE FROM user_area WHERE id_user=#{idUser} and id_area=#{idArea} ")
    void delete(Integer idUser, Integer idArea);
    
    @Select("SELECT * from user_area")
    List<UserArea> getAll();
    
    @Select("SELECT * from user_area WHERE id_user=#{idUser}")
    List<UserArea> getByIdUser(Integer idUser);
    
    @Select("SELECT * from user_area WHERE id_area=#{idArea}")
    List<UserArea> getByIdArea(Integer idArea);
}
