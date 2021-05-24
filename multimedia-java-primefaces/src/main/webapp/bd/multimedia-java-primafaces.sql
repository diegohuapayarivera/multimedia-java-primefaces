-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-05-24 21:41:28.178

-- tables
-- Table: categoria
CREATE TABLE categoria (
    idcat int  NOT NULL IDENTITY,
    nombre varchar(250)  NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY  (idcat)
);

-- Table: modelo
CREATE TABLE modelo (
    id int  NOT NULL IDENTITY,
    identificador int  NOT NULL,
    CONSTRAINT modelo_pk PRIMARY KEY  (id)
);

-- Table: persona
CREATE TABLE persona (
    id int  NOT NULL IDENTITY,
    nombre varchar(50)  NOT NULL,
    apellido varchar(50)  NOT NULL,
    dni char(8)  NOT NULL,
    imagen int  NOT NULL,
    CONSTRAINT persona_pk PRIMARY KEY  (id)
);

-- Table: producto
CREATE TABLE producto (
    idpro int  NOT NULL IDENTITY,
    idcat int  NOT NULL,
    nombre varchar(50)  NULL,
    descripcion varchar(250)  NULL,
    imagen int  NULL,
    CONSTRAINT producto_pk PRIMARY KEY  (idpro)
);

-- foreign keys
-- Reference: producto_categoria (table: producto)
ALTER TABLE producto ADD CONSTRAINT producto_categoria
    FOREIGN KEY (idcat)
    REFERENCES categoria (idcat);

-- End of file.

