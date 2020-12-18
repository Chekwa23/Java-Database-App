
USE `group78`;
DROP USER IF EXISTS 'cs363'@'%%';
CREATE USER 'cs363'@'%%' IDENTIFIED WITH  mysql_native_password BY  '#project78';
GRANT INSERT, SELECT, DROP, CREATE, DELETE ON group78.* TO 'cs363'@'%%';
GRANT EXECUTE ON group78.* TO 'cs363'@'%%';