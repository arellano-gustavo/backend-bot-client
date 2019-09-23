package mx.gob.impi.chatbot.persistence.api.db;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserArea;

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
