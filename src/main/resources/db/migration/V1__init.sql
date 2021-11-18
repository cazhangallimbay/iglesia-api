CREATE TABLE iglesia (
                         id serial,
                         nombre varchar (50) NOT NULL,
                         color varchar (50) NULL,
                         tamaño varchar (50) NULL ,
                         direccion varchar (50),
                         PRIMARY KEY (id)
);

CREATE TABLE misa(
                     id serial,
                     fecha DATE,
                     hora DATE,
                     PRIMARY KEY (id)


);

CREATE TABLE evento (
                        id serial,
                        nombre varchar (50) NOT NULL,
                        fecha DATE,
                        hora DATE,
                        PRIMARY KEY (id)
);

