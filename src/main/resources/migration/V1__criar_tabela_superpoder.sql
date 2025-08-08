CREATE TABLE superpoder (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    nota INT,
    razao VARCHAR(200) NOT NULL,
    data_criacao DATE
);
