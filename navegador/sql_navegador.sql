CREATE DATABASE navegador;
USE navegador;

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';

SET GLOBAL time_zone = '+4:00';

CREATE TABLE usuario (
	PRIMARY KEY(id),
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(20),
    login VARCHAR(10),
    senha VARCHAR(8)
);

INSERT INTO usuario VALUES (1, 'Usuário padrão', 'padrao', 'padrao');
INSERT INTO usuario VALUES (2, 'Estêvão Anderle', 'estevao', 'estevao');
INSERT INTO usuario VALUES (3, 'Lenon de Paula', 'lenon', 'lenon');

CREATE TABLE historico (
	PRIMARY KEY(id),
    id INT NOT NULL AUTO_INCREMENT,
    pagina VARCHAR(20),
    url VARCHAR(45),
    data_acesso DATETIME,
    id_usuario INT NOT NULL,
		FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    favorito BOOLEAN	
); 
    
