INSERT INTO role (role_id, name) VALUES(1, 'ROLE_USER'),(2, 'ROLE_ADMIN');
INSERT INTO card (card_id,name,number) VALUES(1,"admin",123);
INSERT INTO user (user_id,last_name,name,password,email,username,card_id,role_id) VALUES (1,"ADMIN","SUPER","$2y$12$rgk.pbqOKd.Uz/nA88fM/O5zqUjVFgfPwYCQ/sXwMkffZsr4iFQTi","admin@gmail.com","admin@gmail.com",1,2);