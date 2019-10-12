CREATE USER IF NOT EXISTS "SA" SALT 'bd0e1f2db4df485f' HASH 'd0a918ce0ab8bb69100ff06af1d81a5fed49ab7e02353c7166ead701e8b75fa9' ADMIN;
CREATE SCHEMA IF NOT EXISTS "PRUEBA" AUTHORIZATION "SA";
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_9499666B_D976_47B2_B3B3_A220E6AAC310" START WITH 18 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_A4344EC1_08DB_414D_A374_696363FAB24B" START WITH 54 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_3DA3F944_7C38_43D2_9C93_080AA68854B8" START WITH 52 BELONGS_TO_TABLE;
CREATE CACHED TABLE "PUBLIC"."USERS"(
    "ID" INT DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_3DA3F944_7C38_43D2_9C93_080AA68854B8") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_3DA3F944_7C38_43D2_9C93_080AA68854B8",
    "USR" VARCHAR(50) NOT NULL,
    "PASSWORD" VARCHAR(65) NOT NULL,
    "MAIL" VARCHAR(50) NOT NULL,
    "CREATION_DATE" DATE,
    "EXPIRED_ACCOUNT" BOOLEAN DEFAULT FALSE,
    "BLOQUED_ACCOUNT" BOOLEAN DEFAULT FALSE,
    "EXPIRED_CREDENTIAL" BOOLEAN DEFAULT FALSE,
    "DISABLED" BOOLEAN DEFAULT TRUE,
    "FAILED_ATEMPT_COUNTER" INT DEFAULT 0,
    "BLOQUED_DATE" DATETIME,
    "SECRET_QUESTION" VARCHAR(50) DEFAULT '',
    "SECRET_ANSWER" VARCHAR(50) DEFAULT '',
    "SECURITY_TOKEN" VARCHAR(50) DEFAULT '',
    "SECURITY_TOKEN_WINDOW" BIGINT DEFAULT 0 NOT NULL,
    "LAST_ACCESS_DATE" DATE,
    "LAST_PASSWORD_UPDATE_DATE" DATE,
    "FULL_NAME" VARCHAR(100)
);
ALTER TABLE "PUBLIC"."USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("ID");
-- 14 +/- SELECT COUNT(*) FROM PUBLIC.USERS;
INSERT INTO "PUBLIC"."USERS" VALUES
(1, 'root', '817dd0c382108e670e865430f361fb626a0098ad8a599f59168e794679f89091', 'tavo7@aol.com', DATE '2019-09-21', FALSE, FALSE, FALSE, FALSE, 0, TIMESTAMP '2019-10-11 21:58:54.846', '', '', '', 0, NULL, NULL, 'Sylvanas Brisaveloz'),
(2, 'tavo', '4e5cdfcaf10e0124ab19ec3267cf4da9acbcecc91ae0dd0c9dc8f479e41af30a', 'arellano.gustavo@gmail.com', NULL, FALSE, FALSE, FALSE, FALSE, 0, TIMESTAMP '2019-10-11 21:58:29.383', NULL, NULL, 'cNMeVS9ptG84YvUEHuY5vTY8qLxd8bGoMrMPGjCxFBHs7a2jCL', 0, NULL, NULL, NULL),
(33, 'tercero', 'b75f914c13a2cf309962a07fbd9ee10ae9c2f8dfabfb52bf056536f04a6b416', 'goose9@aol.com', NULL, FALSE, FALSE, FALSE, FALSE, 1, TIMESTAMP '1969-12-31 18:00:00.001', '', '', '', 1000, NULL, NULL, 'Anduin Wrynn'),
(34, 'cuarto', '478ed70364e2c9058724102ffdb646ef832379657ddec020d22ed9f3fa14a79e', 'goose7@aol.com', NULL, FALSE, FALSE, FALSE, FALSE, 3, TIMESTAMP '1969-12-31 18:00:00.001', '', '', '', 1000, NULL, NULL, 'Cairne Bloodhoof'),
(35, 'quinto', 'cf4d586e6bca4f3f6890b7c3e6407201b9ff781848b5ec36f189ce518fe8e5b7', 'goose5@aol.com', NULL, FALSE, FALSE, FALSE, FALSE, 0, TIMESTAMP '1969-12-31 18:00:00.001', '', '', '', 1000, NULL, NULL, 'Lor themar Theron'),
(36, 'sexto', '5bbba82dda8161f6843911bcd4569daa25b8467d55ec58f37d0e988199e133da', 'dcorzaa@ultrasist.com.mx', NULL, FALSE, FALSE, FALSE, FALSE, 0, TIMESTAMP '1970-01-01 00:00:00.001', NULL, NULL, 'RCSAfolWzcCF4PQ8oYvsLHA2BEeenKGdt8rpEZljmbVP7jxVDV', 1570824965847, NULL, NULL, NULL),
(44, 'goose37', 'xyz', '37gus@hotmail.com', DATE '2019-10-10', FALSE, FALSE, FALSE, TRUE, 0, NULL, '', '', '', 0, NULL, NULL, NULL),
(45, 'goose45', 'xyz', '45gus@hotmail.com', DATE '2019-10-10', FALSE, FALSE, FALSE, TRUE, 0, NULL, '', '', '', 0, NULL, NULL, NULL),
(46, 'goose46', 'xyz', '46gus@hotmail.com', DATE '2019-10-10', FALSE, FALSE, FALSE, TRUE, 0, NULL, '', '', '', 0, NULL, NULL, NULL),
(47, 'goose47', 'xyz', '47gus@hotmail.com', DATE '2019-10-10', FALSE, FALSE, FALSE, TRUE, 0, NULL, '', '', '', 0, NULL, NULL, NULL),
(48, 'goose48', 'xyz', '48gus@hotmail.com', DATE '2019-10-10', FALSE, FALSE, FALSE, TRUE, 0, NULL, '', '', '', 0, NULL, NULL, NULL),
(49, 'goose49', 'xyz', '49gus@hotmail.com', DATE '2019-10-11', FALSE, FALSE, FALSE, TRUE, 0, NULL, '', '', '', 0, NULL, NULL, NULL),
(50, 'goose50', 'xyz', '50gus@hotmail.com', DATE '2019-10-11', FALSE, FALSE, FALSE, TRUE, 0, NULL, '', '', '', 0, NULL, NULL, NULL),
(51, 'goose51', 'xyz', '51gus@hotmail.com', DATE '2019-10-11', FALSE, FALSE, FALSE, TRUE, 0, NULL, '', '', '', 0, NULL, NULL, NULL);
CREATE UNIQUE INDEX "PUBLIC"."USER_USR_IDX" ON "PUBLIC"."USERS"("USR");
CREATE UNIQUE INDEX "PUBLIC"."USER_MAIL_IDX" ON "PUBLIC"."USERS"("MAIL");
CREATE INDEX "PUBLIC"."USER_SECURITY_TOKEN_IDX" ON "PUBLIC"."USERS"("SECURITY_TOKEN");
CREATE CACHED TABLE "PRUEBA"."SAMPLE"(
    "ID" INT
);
-- 0 +/- SELECT COUNT(*) FROM PRUEBA.SAMPLE;
CREATE FORCE VIEW "PUBLIC"."ROLES_FROM_USER"("USER_ID", "ID", "NAME", "DESCRIPTION", "ACTIVE") AS
SELECT
    "USERS"."ID" AS "USER_ID",
    "ROLES"."ID",
    "ROLES"."NAME",
    "ROLES"."DESCRIPTION",
    "ROLES"."ACTIVE"
FROM "PUBLIC"."USERS"
INNER JOIN "PUBLIC"."USER_ROL"
    ON 1=1
INNER JOIN "PUBLIC"."ROLES"
    ON 1=1
WHERE ("USERS"."ID" = "USER_ROL"."ID_USER")
    AND ("ROLES"."ID" = "USER_ROL"."ID_ROL");
CREATE FORCE VIEW "PUBLIC"."AREAS_FROM_USER"("USER_ID", "ID", "NAME", "DESCRIPTION", "ACTIVE") AS
SELECT
    "USERS"."ID" AS "USER_ID",
    "AREAS"."ID",
    "AREAS"."NAME",
    "AREAS"."DESCRIPTION",
    "AREAS"."ACTIVE"
FROM "PUBLIC"."USERS"
INNER JOIN "PUBLIC"."USER_AREA"
    ON 1=1
INNER JOIN "PUBLIC"."AREAS"
    ON 1=1
WHERE ("USERS"."ID" = "USER_AREA"."ID_USER")
    AND ("AREAS"."ID" = "USER_AREA"."ID_AREA");
CREATE CACHED TABLE "PUBLIC"."ROLES"(
    "ID" INT DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_9499666B_D976_47B2_B3B3_A220E6AAC310") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_9499666B_D976_47B2_B3B3_A220E6AAC310",
    "NAME" VARCHAR(50) NOT NULL,
    "DESCRIPTION" VARCHAR(250),
    "ACTIVE" BOOLEAN
);
ALTER TABLE "PUBLIC"."ROLES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ID");
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.ROLES;
INSERT INTO "PUBLIC"."ROLES" VALUES
(1, 'admin', 'administrador general del sistema', TRUE),
(2, 'trainer', 'Entrenador del Chatbot', TRUE),
(12, 'prueba3', 'prueba3', TRUE),
(13, 'rol13', 'prueba13', TRUE),
(14, 'rol14', 'prueba14', TRUE),
(15, 'rol15', 'prueba15', TRUE),
(16, 'rol16', 'prueba16', TRUE),
(17, 'rol17', 'prueba17', TRUE);
CREATE UNIQUE INDEX "PUBLIC"."ROL_NAME_IDX" ON "PUBLIC"."ROLES"("NAME");
CREATE CACHED TABLE "PUBLIC"."AREAS"(
    "ID" INT DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_A4344EC1_08DB_414D_A374_696363FAB24B") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_A4344EC1_08DB_414D_A374_696363FAB24B",
    "NAME" VARCHAR(50) NOT NULL,
    "DESCRIPTION" VARCHAR(250),
    "ACTIVE" BOOLEAN
);
ALTER TABLE "PUBLIC"."AREAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1E" PRIMARY KEY("ID");
-- 13 +/- SELECT COUNT(*) FROM PUBLIC.AREAS;
INSERT INTO "PUBLIC"."AREAS" VALUES
(1, 'uno', 'primer area', TRUE),
(2, 'dos', 'segunda area', TRUE),
(3, 'tres', 'tercera area', TRUE),
(4, 'cuatro', 'cuarta', TRUE),
(5, 'Cinco', 'quinta', TRUE),
(6, 'Seis', 'sexta', TRUE),
(47, 'prueba7', 'prueba7', TRUE),
(48, 'area48', 'prueba48', TRUE),
(49, 'area49', 'prueba49', TRUE),
(50, 'area50', 'prueba50', TRUE),
(51, 'area51', 'prueba51', TRUE),
(52, 'area52', 'prueba52', TRUE),
(53, 'area53', 'prueba53', TRUE);
CREATE UNIQUE INDEX "PUBLIC"."AREA_NAME_IDX" ON "PUBLIC"."AREAS"("NAME");
CREATE CACHED TABLE "PUBLIC"."USER_AREA"(
    "ID_USER" INT NOT NULL,
    "ID_AREA" INT NOT NULL
);
ALTER TABLE "PUBLIC"."USER_AREA" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_B" PRIMARY KEY("ID_USER", "ID_AREA");
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.USER_AREA;
INSERT INTO "PUBLIC"."USER_AREA" VALUES
(1, 5),
(1, 2),
(2, 6),
(33, 6),
(34, 5),
(35, 4),
(36, 3),
(2, 3);
CREATE CACHED TABLE "PUBLIC"."USER_ROL"(
    "ID_USER" INT NOT NULL,
    "ID_ROL" INT NOT NULL
);
ALTER TABLE "PUBLIC"."USER_ROL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1ED" PRIMARY KEY("ID_USER", "ID_ROL");
-- 6 +/- SELECT COUNT(*) FROM PUBLIC.USER_ROL;
INSERT INTO "PUBLIC"."USER_ROL" VALUES
(1, 1),
(2, 2),
(33, 2),
(34, 2),
(35, 2),
(36, 2);
ALTER TABLE "PUBLIC"."USER_ROL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1ED7" FOREIGN KEY("ID_USER") REFERENCES "PUBLIC"."USERS"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."USER_ROL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1ED77" FOREIGN KEY("ID_ROL") REFERENCES "PUBLIC"."ROLES"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."USER_AREA" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_BC0" FOREIGN KEY("ID_AREA") REFERENCES "PUBLIC"."AREAS"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."USER_AREA" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_BC" FOREIGN KEY("ID_USER") REFERENCES "PUBLIC"."USERS"("ID") NOCHECK;
(38 filas, 3 ms)