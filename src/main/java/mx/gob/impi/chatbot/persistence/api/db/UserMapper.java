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
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad usuario 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.db;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.gob.impi.chatbot.persistence.api.model.domain.User;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'User'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UserMapper {
    
    /* Mapeo de campos objeto-entidad */
    @Results(value = {
            @Result(property = "id",                     column = "id"),
            @Result(property = "usr",                    column = "usr"),
            @Result(property = "password",               column = "password"),
            @Result(property = "mail",                   column = "mail"),
            @Result(property = "creationDate",           column = "creation_date"),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "disabled",               column = "disabled"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date"),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date"),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date")
          })
    /**
     * Obtiene un usuario realizando la búsqueda con el nombre de pila.
     *
     * @param usuario Nombre de pila del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Select("SELECT * FROM user;")
    List<User> getAll();
    
    /**
     * Obtiene un usuario realizando la búsqueda con el nombre de pila.
     *
     * @param usuario Nombre de pila del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Select("SELECT * FROM user WHERE usr = #{usr}")
    User getUserByName(String user);

    /**
     * Obtiene un usuario realizando la búsqueda con el correo electrónico.
     *
     * @param correo Dirección de correo electrónico.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Select("SELECT * FROM user WHERE mail = #{mail}")
    User getUserByMail(String mail);
    
    /**
     * Obtiene un usuario realizando la búsqueda con la llave primaria
     * 
     * @param id Llave primaria 
     * 
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Integer id);

    /**
     * Obtiene un usuario realizando la búsqueda con el Id de seguridad.
     *
     * @param idSeguridad Id de seguridad del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Select("SELECT * FROM user WHERE security_token = #{securityToken}")
    User getUserBySecurityToken(String securityToken);

    /**
     * Elimina al usuario cuyo ID es el dado y también elimina a las 
     * dependencias que este tiene en la base de datos.
     *
     * @param id El id del usuario
     */
    @Update("UPDATE user SET disabled=true WHERE id=#{id}")
    void deleteUserByIdLogico(int id);
    
    String full_insert_statement = 
            "INSERT INTO user("
            //+"id, "
            +"usr, "
            +"password, "
            +"mail, "
            +"creation_date, "
            +"expired_account, "
            +"bloqued_account, "
            +"expired_credential, "
            +"disabled, "
            +"failed_atempt_counter, "
            +"bloqued_date, "
            +"secret_question, "
            +"secret_answer, "
            +"security_token, "
            +"security_token_window, "
            +"last_access_date, "
            +"last_password_update_date "
            +") VALUES("
            //+"#{id}, "
            +"#{usr}, "
            +"#{password}, "
            +"#{mail}, "
            +"#{creationDate}, "
            +"#{expiredAccount}, "
            +"#{bloquedAccount}, "
            +"#{expiredCredential}, "
            +"#{disabled}, "
            +"#{failedAtemptCounter}, "
            +"#{bloquedDate}, "
            +"#{secretQuestion}, "
            +"#{secretAnswer}, "
            +"#{securityToken}, "
            +"#{securityTokenWindow}, "
            +"#{lastAccessDate}, "
            +"#{lastPasswordUpdateDate}"
            +");";
    /** Procedimiento de inserción con mapeo incluido */
    @Insert(full_insert_statement)
    void fullInsert(User user);
    
    String short_insert_statement = 
            "INSERT INTO user("
            //+"id, "
            +"usr, "
            +"password, "
            +"mail, " 
            + "creation_date "
            +") VALUES("
            //+"#{id}, "
            +"#{usr}, "
            +"#{password}, "
            +"#{mail}, " 
            +"#{creationDate}"
            +");";
    /** Procedimiento de inserción con mapeo incluido */
    @Insert(short_insert_statement)
    void insert(User user);

    String update_statement = 
            "UPDATE user SET "
            +"usr                       = #{usr}, "
            +"password                  = #{password}, "
            +"mail                      = #{mail}, "
            +"creation_date             = #{creationDate}, "
            +"expired_account           = #{expiredAccount}, "
            +"bloqued_account           = #{bloquedAccount}, "
            +"expired_credential        = #{expiredCredential}, "
            +"disabled                  = #{disabled}, "
            +"failed_atempt_counter     = #{failedAtemptCounter}, "
            +"bloqued_date              = #{bloquedDate}, "
            +"secret_question           = #{secretQuestion}, "
            +"secret_answer             = #{secretAnswer}, "
            +"security_token            = #{securityToken}, "
            +"security_token_window     = #{securityTokenWindow}, "
            +"last_access_date          = #{lastAccessDate}, "
            +"last_password_update_date = #{lastPasswordUpdateDate} "
            +"WHERE "
            +"id = #{id}";
    /** Procedimiento de actualización con mapeo incluido */
    @Update(update_statement)
    void update(User user);
}


/*
DROP TABLE user;
CREATE TABLE user (
 id                         int NOT NULL auto_increment,
 usr                        varchar(50) NOT NULL,
 password                   varchar(50) NOT NULL,
 mail                       varchar(50) NOT NULL,
 creation_date              date,
 expired_account            boolean default false,
 bloqued_account            boolean default false,
 expired_credential         boolean default false,
 disabled                   boolean default true,
 failed_atempt_counter      int default 0,
 bloqued_date               date,
 secret_question            varchar(50) default '',
 secret_answer              varchar(50) default '',
 security_token             varchar(50) default '',
 security_token_window      int default 1000,
 last_access_date           date,
 last_password_update_date  date,
 PRIMARY KEY (id)
);
CREATE UNIQUE INDEX user_usr_idx ON user(usr);
CREATE UNIQUE INDEX user_mail_idx ON user(mail);
CREATE INDEX user_security_token_idx ON user(security_token);

insert into user ( 
id, 
usr, 
password, 
mail, 
creation_date, 
expired_account, 
bloqued_account, 
expired_credential,  
disabled,
failed_atempt_counter,  
bloqued_date, 
secret_question, 
secret_answer, 
security_token, 
security_token_window,
last_access_date,
last_password_update_date
)
values(
3,
'goose',
'clave',
'correo',
TO_DATE( '2-DEC-2006', 'DD-MON-YYYY' ),
true,
true,
true,
true,
0,
TO_DATE( '2-DEC-2006', 'DD-MON-YYYY' ),
NULL,
'respuesta_secreta',
'token_de_seguridad',
1234,
TO_DATE( '2-DEC-2006', 'DD-MON-YYYY' ),
TO_DATE( '2-DEC-2006', 'DD-MON-YYYY' )
);
select * from usuario;

*/
// check this out:
// https://howtodoinjava.com/eclipse/create-eclipse-templates-for-faster-java-coding/
