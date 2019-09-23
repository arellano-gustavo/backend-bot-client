/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.db
 * Modulo:      Rol
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad perfil 
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

import mx.gob.impi.chatbot.persistence.api.model.domain.Rol;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad perfil
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface RolMapper {

    @Insert("INSERT INTO rol(name, description, active) VALUES(#{name}, #{description}, #{active});")
    void insert(Rol rol);
    
    @Update("UPDATE rol SET name=#{name}, description=#{description}, active=#{active} WHERE id=#{id};")
    void update(Rol rol);
    
    @Select("SELECT * FROM rol WHERE id = #{id}")
    Rol getRolById(Integer id);
    
    @Select("SELECT * FROM rol")
    List<Rol> getAll();
}
