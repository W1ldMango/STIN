INSERT INTO users(id, name, surname, email, password) VALUES (1, 'John', 'Doe', 'test@gmail.com','dGVzdA==');
INSERT INTO users(id, name, surname, email, password) VALUES (2, 'John', 'Doe1', 'test1@gmail.com','dGVzdDE');
INSERT INTO users(id, name, surname, email, password) VALUES (3, 'John', 'Doe1', 'admin@gmail.com','admin');
INSERT INTO users(id, name, surname, email, password) VALUES (4, 'John', 'Doe1', 'justfoxel@gmail.com','admin');

INSERT INTO users(code) VALUES (1);

insert into users(code) (select 111 from users where id = 1)

update users set code = 112311 where email = 'test@gmail.com';

select code from users where email = 'admin@gmail.com';

DELETE FROM users WHERE id = 1;
DELETE FROM users WHERE id = 3;

DELETE FROM users WHERE id > 4;

SELECT * FROM users;

SELECT * FROM transactions;

INSERT INTO accounts(id, account_number, balanceusd, balanceeur, balanceczk) VALUES (1, 1, 1000, 90, 100);

INSERT INTO accounts(id, account_number, balanceusd, balanceeur, balanceczk) VALUES (2, 2, 1000, 90, 100);

select * from accounts;

DELETE FROM transactions where account_number = 1;
