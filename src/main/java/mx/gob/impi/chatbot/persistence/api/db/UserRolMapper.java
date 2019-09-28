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
 * Interface 'Mapper' MyBatis asociado a la entidad 'UsuarioRol' 
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
import mx.gob.impi.chatbot.persistence.api.model.domain.UserRol;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'UserArea'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UserRolMapper {
    @Insert("INSERT INTO user_rol(id_user, id_rol) VALUES(#{idUser}, #{idRol}) ")
    void insert(Integer idUser, Integer idRol);
    
    @Delete("DELETE FROM user_rol WHERE id_user=#{idUser} and id_rol=#{idRol} ")
    void delete(Integer idUser, Integer idRol);
    
    @Select("SELECT * from user_rol")
    List<UserRol> getAll();
    
    @Select("SELECT * from user_rol WHERE id_user=#{idUser}")
    List<UserRol> getByIdUser(Integer idUser);
    
    @Select("SELECT * from user_rol WHERE id_rol=#{idRol}")
    List<UserRol> getByIdRol(Integer idRol);
}