DROP table if exists users;

CREATE TABLE users (
    id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    code VARCHAR(50) NULL,
    PRIMARY KEY (id)
);



