CREATE TABLE IF NOT EXISTS students
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    first_name  VARCHAR(256) NOT NULL ,
    last_name  VARCHAR(256) NOT NULL,
    middle_name  VARCHAR(256) NOT NULL
    );

CREATE TABLE IF NOT EXISTS groupss
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    groupname  VARCHAR(256) NOT NULL
);