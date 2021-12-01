CREATE TABLE iglesia (
                         id serial,
                         nombre varchar (50) NOT NULL,
                         color varchar (50) NULL,
                         direccion varchar (50),
                         PRIMARY KEY (id)
);

CREATE TABLE misa(
                     id serial,
                     fecha DATE,
                     hora DATE,
                     iglesia_id int,
                     PRIMARY KEY (id),
                     foreign key (iglesia_id) references iglesia (id)


);

CREATE TABLE evento (
                        id serial,
                        nombre varchar (50) NOT NULL,
                        fecha DATE,
                        hora DATE,
                        misa_id int,
                        PRIMARY KEY (id),
                        foreign  key (misa_id) references misa(id)

);

