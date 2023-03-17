DROP table if exists users;

CREATE TABLE users (
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    code VARCHAR(50) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE accounts (
    id SERIAL NOT NULL,
    account_number INT NOT NULL,
    balanceUSD INT NOT NULL,
    balanceEUR INT NOT NULL,
    balanceCZK INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES users(id)
);

DROP TABLE if exists accounts;



