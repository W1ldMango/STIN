INSERT INTO users(id, name, surname, email, password) VALUES (1, 'John', 'Doe', 'test@gmail.com','dGVzdA==');
INSERT INTO users(id, name, surname, email, password) VALUES (2, 'John', 'Doe1', 'test1@gmail.com','dGVzdDE');
INSERT INTO users(id, name, surname, email, password) VALUES (3, 'John', 'Doe1', 'admin@gmail.com','admin');


DELETE FROM users WHERE id = 1;
DELETE FROM users WHERE id = 3;

DELETE FROM users WHERE id > 4;

SELECT * FROM users;