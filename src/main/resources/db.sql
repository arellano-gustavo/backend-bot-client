

DROP TABLE user;
CREATE TABLE user (
 id                         int NOT NULL auto_increment,
 usr                        varchar(50) NOT NULL,
 password                   varchar(250) NOT NULL,
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
 security_token_window      bigint default 0,
 last_access_date           date,
 last_password_update_date  date,
 PRIMARY KEY (id)
);
CREATE UNIQUE INDEX user_usr_idx ON user(usr);
CREATE UNIQUE INDEX user_mail_idx ON user(mail);
CREATE INDEX user_security_token_idx ON user(security_token);

DROP TABLE rol;
CREATE TABLE rol (
 id                         int NOT NULL auto_increment,
 name                       varchar(50) NOT NULL,
 description                varchar(250),
 active                     boolean,
 PRIMARY KEY (id)
);
CREATE UNIQUE INDEX rol_name_idx ON rol(name);

DROP TABLE area;
CREATE TABLE area (
 id                         int NOT NULL auto_increment,
 name                       varchar(50) NOT NULL,
 description                varchar(250),
 active                     boolean,
 PRIMARY KEY (id)
);
CREATE UNIQUE INDEX area_name_idx ON area(name);

INSERT INTO area(name, description, active) VALUES('uno','primer area',true);
INSERT INTO area(name, description, active) VALUES('dos','segunda area',true);
INSERT INTO area(name, description, active) VALUES('tres','tercera area',true);
SELECT * FROM area; 

CREATE TABLE user_area (
  id_user int NOT NULL,
  id_area int NOT NULL,
  PRIMARY KEY (id_user, id_area)
);
ALTER TABLE user_area ADD FOREIGN KEY (id_user) REFERENCES user(id);
ALTER TABLE user_area ADD FOREIGN KEY (id_area) REFERENCES area(id);


CREATE TABLE user_rol (
  id_user int NOT NULL,
  id_rol int NOT NULL,
  PRIMARY KEY (id_user, id_rol)
);
ALTER TABLE user_rol ADD FOREIGN KEY (id_user) REFERENCES user(id);
ALTER TABLE user_rol ADD FOREIGN KEY (id_rol) REFERENCES rol(id);



INSERT INTO user ( 
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


