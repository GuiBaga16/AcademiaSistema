/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  GuiBaga
 * Created: 28 de set. de 2026
 */

CREATE TABLE equipamento (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    marca VARCHAR(100),
    quantidade INT NOT NULL,
    status_atual VARCHAR(30) NOT NULL
);

CREATE TABLE aluno (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    documento VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(254) NOT NULL,
    telefone VARCHAR(20),
    data_nascimento DATE
);

CREATE TABLE tipo_treino (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE exercicio (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    equipamento_id INT,
    
    CONSTRAINT fk_exercicio_equipamento
        FOREIGN KEY (equipamento_id)
        REFERENCES equipamento(id)
);

CREATE TABLE treino (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    tipo_treino_id INT NOT NULL,
    
    CONSTRAINT fk_treino_tipo
        FOREIGN KEY (tipo_treino_id)
        REFERENCES tipo_treino(id)
);

CREATE TABLE aluno_treino (
    aluno_id INT NOT NULL,
    treino_id INT NOT NULL,

    PRIMARY KEY (aluno_id, treino_id),

    CONSTRAINT fk_aluno_treino_aluno
        FOREIGN KEY (aluno_id)
        REFERENCES aluno(id),

    CONSTRAINT fk_aluno_treino_treino
        FOREIGN KEY (treino_id)
        REFERENCES treino(id)
);

CREATE TABLE treino_exercicio (
    treino_id INT NOT NULL,
    exercicio_id INT NOT NULL,
    series INT NOT NULL,
    repeticoes INT NOT NULL,
    carga DECIMAL(6,2),

    PRIMARY KEY (treino_id, exercicio_id),

    CONSTRAINT fk_treino_exercicio_treino
        FOREIGN KEY (treino_id)
        REFERENCES treino(id),

    CONSTRAINT fk_treino_exercicio_exercicio
        FOREIGN KEY (exercicio_id)
        REFERENCES exercicio(id)
);