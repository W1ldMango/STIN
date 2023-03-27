INSERT INTO users(id, name, surname, email, password) VALUES (1, 'admin', 'admin', 'admin@gmail.com','$2a$10$hgcpzVMF7Qm.cADa.wlvRua7HPEcMmKnKFvCB5m7oBduG1vHsBNHi');
INSERT INTO users(id, name, surname, email, password) VALUES (2, 'Vladimir', 'Stankov', 'justfoxel@gmail.com','$2a$10$T67VuRo5bbtVUbneCLcesudcJCnro/QtSkNBoc3YVHpgicEOmQhXe');

INSERT INTO accounts(id, account_number, balanceusd, balanceeur, balanceczk) VALUES (1, 1, null, 90, 100);

INSERT INTO accounts(id, account_number, balanceusd, balanceeur, balanceczk) VALUES (2, 2, 1000, 90, 100);

select * from accounts;
