CREATE TABLE curso(
    id bigint NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

insert into curso (id, nome, categoria) values (1, 'Java', 'Programação');