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
import org.apache.ibatis.type.JdbcType;

import mx.gob.impi.chatbot.persistence.api.model.domain.PageBoundaries;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'User'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface UserMapper {
    /**
     * Obtiene un usuario realizando la búsqueda con el nombre de pila.
     *
     * @param usuario Nombre de pila del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Results(value = {
            @Result(property = "creationDate",           column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",               column = "full_name")
          })
    @Select("SELECT * FROM users order by ${sortColumn} asc")
    List<User> getAll(PageBoundaries pb);

    
    /**
     * Obtiene un usuario realizando la búsqueda con el nombre de pila.
     *
     * @param usuario Nombre de pila del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Results(value = {
            @Result(property = "creationDate",           column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",               column = "full_name")
          })
    @Select("SELECT * FROM users order by ${sortColumn} desc")
    List<User> getAllDesc(PageBoundaries pb);
    
    /**
     * Obtiene un usuario realizando la búsqueda con el nombre de pila.
     *
     * @param usuario Nombre de pila del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Results(value = {
            @Result(property = "creationDate",           column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",               column = "full_name")
          })
    @Select("SELECT * FROM users WHERE usr = #{usr}")
    User getUserByName(String user);

    /**
     * Obtiene un usuario realizando la búsqueda con el correo electrónico.
     *
     * @param correo Dirección de correo electrónico.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Results(value = {
            @Result(property = "creationDate",           column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",               column = "full_name")
          })
    @Select("SELECT * FROM users WHERE mail = #{mail}")
    User getUserByMail(String mail);

    /**
     * Obtiene un usuario realizando la búsqueda con la llave primaria
     *
     * @param id Llave primaria
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Results(value = {
            @Result(property = "creationDate",           column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",               column = "full_name")
          })
    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(Integer id);

    /**
     * Obtiene un usuario realizando la búsqueda con el Id de seguridad.
     *
     * @param idSeguridad Id de seguridad del usuario.
     *
     * @return el usuario encontrado con el criterio de búsqueda.
     */
    @Results(value = {
            @Result(property = "creationDate",           column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",               column = "full_name")
          })
    @Select("SELECT * FROM users WHERE security_token = #{securityToken}")
    User getUserBySecurityToken(String securityToken);

    /**
     * Elimina al usuario cuyo ID es el dado y también elimina a las
     * dependencias que este tiene en la base de datos.
     *
     * @param id El id del usuario
     */
    @Update("UPDATE users SET disabled=true WHERE id=#{id}")
    void deleteUserByIdLogico(int id);

    String full_insert_statement =
            "INSERT INTO users("
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
            +"last_password_update_date, "
            +" full_name "
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
            +"#{lastPasswordUpdateDate}, "
            +"#{fullName}"
            +")";
    /** Procedimiento de inserción con mapeo FULL incluido */
    @Results(value = {
            @Result(property = "creationDate",           column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",               column = "full_name")
          })
    @Insert(full_insert_statement)
    void fullInsert(User user);

    /** Procedimiento de inserción con mapeo incluido */
    String short_insert_statement =
            "INSERT INTO users("
            //+"id, "
            +"usr, "
            +"password, "
            +"mail, "
            +"disabled, "
            +"creation_date, full_name"
            +") VALUES("
            +"#{usr}, "
            +"#{password}, "
            +"#{mail}, "
            +"#{disabled}, "
            +"#{creationDate}, #{fullName}"
            +")";
    @Results(value = {
            @Result(property = "creationDate",  column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",      column = "full_name")
          })
    @Insert(short_insert_statement)
    void shortInsert(User user);

    String update_statement =
            "UPDATE users SET "
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
            +"last_password_update_date = #{lastPasswordUpdateDate}, "
            +"full_name                 = #{fullName} "
            +"WHERE "
            +"id = #{id}";
    //TODO Checar si este mapeo es necesario. Pienso que sólo se requiere lo de las fechas
    /**
     * Update completo ...
     * 
     * @param user el objeto ...
     */
    @Results(value = {
            @Result(property = "creationDate",           column = "creation_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "expiredAccount",         column = "expired_account"),
            @Result(property = "bloquedAccount",         column = "bloqued_account"),
            @Result(property = "expiredCredential",      column = "expired_credential"),
            @Result(property = "failedAtemptCounter",    column = "failed_atempt_counter"),
            @Result(property = "bloquedDate",            column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "secretQuestion",         column = "secret_question"),
            @Result(property = "secretAnswer",           column = "secret_answer"),
            @Result(property = "securityToken",          column = "security_token"),
            @Result(property = "securityTokenWindow",    column = "security_token_window"),
            @Result(property = "lastAccessDate",         column = "last_access_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "lastPasswordUpdateDate", column = "last_password_update_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "fullName",               column = "full_name")
          })
    @Update(update_statement)
    void update(User user);

    String updateFailure_statement =
            "UPDATE users SET "
            +"failed_atempt_counter     = #{failedAtemptCounter} "
            +"WHERE "
            +"id = #{id}";
    @Results(value = {
            @Result(property = "failedAtemptCounter",      column = "failed_atempt_counter")
          })
    @Update(updateFailure_statement)
    void updateFailure(User usuario);

    String updateLocked_statement =
            "UPDATE users SET "
            +"bloqued_account           = #{bloquedAccount}, "
            +"bloqued_date              = #{bloquedDate} "
            +"WHERE "
            +"id = #{id}";
    /**
     * Actualiza el estado de 'bloqueado' para un usuario dado.
     * 
     * @param usuario Objeto de ttipo 'User' al que se le va a modificar su estado de bloqueo.
     */
    @Results(value = {
            @Result(property = "bloquedDate",    column = "bloqued_date", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "bloquedAccount", column = "bloqued_account")
          })
    @Update(updateLocked_statement)
    void updateBlocked(User usuario);
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
 full_name                  varchar(100)
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
last_password_update_date.
full_name
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
TO_DATE( '2-DEC-2006', 'DD-MON-YYYY' ),
'Gustavo Arellano Sandoval'
);
select * from usuario;

*/
// check this out:
// https://howtodoinjava.com/eclipse/create-eclipse-templates-for-faster-java-coding/
