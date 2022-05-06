CREATE TABLE IF NOT EXISTS studentsR
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    first_name  VARCHAR(256) NOT NULL ,
    last_name  VARCHAR(256) NOT NULL,
    middle_name  VARCHAR(256) NOT NULL,
    group_id INTEGER
    );
--DROP TABLE IF EXISTS groupsR;
CREATE TABLE IF NOT EXISTS groupsR
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    groupname  VARCHAR(256) NOT NULL
);