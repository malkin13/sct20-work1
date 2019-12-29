CREATE DATABASE STC20DB;

GRANT ALL ON DATABASE stc20db TO postgres;

create table "user"
(
    id          serial PRIMARY KEY,
    name        varchar(100) NOT NULL,
    birthday    date         NOT NULL,
    login_ID    serial       NOT NULL,
    city        VARCHAR(100),
    email       VARCHAR(100),
    description VARCHAR(255)
);

CREATE TYPE name_role AS ENUM ('Administration', 'Clients', 'Billing');

create table role(
    id serial PRIMARY KEY,
    name name_role,
    description VARCHAR(255)
);

create table user_role(
    id serial not null ,
    user_id serial references "user"(id),
    role_id serial references role(id)
);

create table "user"
(
    id          serial PRIMARY KEY,
    name        varchar(100) NOT NULL,
    birthday    date         NOT NULL,
    login_ID    serial       NOT NULL,
    city        VARCHAR(100),
    email       VARCHAR(100),
    description VARCHAR(255)
);