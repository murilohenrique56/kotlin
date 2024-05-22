CREATE TABLE topico(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem VARCHAR(300) NOT NULL,
    data_criacao DATETIME NOT NULL,
    curso_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);