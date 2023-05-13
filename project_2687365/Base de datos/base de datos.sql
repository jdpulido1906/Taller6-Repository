CREATE DATABASE CarUnity;
USE CarUnity;

CREATE TABLE users_tbl(
user_id int not null primary key auto_increment,
user_firstname VARCHAR(40) not null,
user_lastname VARCHAR(40) not null,
user_email VARCHAR(60) not null,
user_password VARBINARY(255)
);
insert INTO CarUnity.users_tbl (user_firstname, user_lastname, user_email, user_password)VALUES (UPPER('fabian'), UPPER('perez'), 'mate@gmail.com',AES_ENCRYPT('password','$2a$15$Ov6xYXkMlR2Ez2/RwUiO.OoYBEIKcQzy3YQkIfeIQXCiTPUSAWPta'));
SELECT *,CAST(AES_DECRYPT(user_password,'$2a$15$Ov6xYXkMlR2Ez2/RwUiO.OoYBEIKcQzy3YQkIfeIQXCiTPUSAWPta') AS CHAR(50))end_data FROM users_tbl WHERE user_id = 1;