CREATE TABLE usuario(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

insert into usuario (id, nome, email) VALUES (1, 'Murilo Henrique', 'murilo-souza@hotmail.com');
