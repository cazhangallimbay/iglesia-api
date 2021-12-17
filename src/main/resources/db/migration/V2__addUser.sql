CREATE TABLE IF NOT EXISTS usuario (
        id serial,
        username VARCHAR (45) NOT NULL,
        password VARCHAR (45) NOT NULL,
        PRIMARY KEY (id),
        UNIQUE  (username)
        );



