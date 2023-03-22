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

DROP TABLE if exists accounts;


CREATE TABLE accounts (
    id SERIAL NOT NULL UNIQUE,
    account_number INT NOT NULL UNIQUE,
    balanceUSD INT NOT NULL,
    balanceEUR INT NOT NULL,
    balanceCZK INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES users(id)
);


DROP TABLE if exists transactions;

CREATE TABLE transactions (
    id SERIAL NOT NULL,
    account_number INT NOT NULL,
    amount INT NOT NULL,
    currency VARCHAR(3) NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (account_number) REFERENCES accounts(account_number)
);






