CREATE DATABASE viagem;
USE viagem;

CREATE TABLE usuario (
  id INT,
  nome VARCHAR(255) NOT NULL COMMENT 'Nome do usuário',
  email VARCHAR(255) NOT NULL UNIQUE COMMENT 'Endereço de e-mail do usuário',
  data_nascimento DATE NOT NULL COMMENT 'Data de nascimento do usuário',
  endereco VARCHAR(50) NOT NULL COMMENT 'Endereço do Cliente'
);

CREATE TABLE destino (
  id INT,
  nome VARCHAR(255) NOT NULL UNIQUE COMMENT 'Nome do destino',
  descricao VARCHAR(255) NOT NULL COMMENT 'Descrição do destino'
);

CREATE TABLE reserva (
  id INT COMMENT 'Identificador único da reserva',
  id_usuario INT COMMENT 'Referência ao ID do usuário que fez a reserva',
  id_destino INT COMMENT 'Referência ao ID do destino da reserva',
  data DATE COMMENT 'Data da reserva',
  status VARCHAR(255) DEFAULT 'pendente' COMMENT 'Status da reserva (confirmada, pendente, cancelada, etc.)'
);

-- Inserts --
INSERT INTO usuario (id, nome, email, data_nascimento, endereco) VALUES 
(1, 'João Silva', 'joao@example.com', '1990-05-15', 'Rua A, 123, Cidade X, Estado Y'),
(2, 'Maria Santos', 'maria@example.com', '1985-08-22', 'Rua B, 456, Cidade Y, Estado Z'),
(3, 'Pedro Souza', 'pedro@example.com', '1998-02-10', 'Avenida C, 789, Cidade X, Estado Y');

INSERT INTO destino (id, nome, descricao) VALUES 
(1, 'Praia das Tartarugas', 'Uma bela praia com areias brancas e mar cristalino'),
(2, 'Cachoeira do Vale Verde', 'Uma cachoeira exuberante cercada por natureza'),
(3, 'Cidade Histórica de Pedra Alta', 'Uma cidade rica em história e arquitetura');

INSERT INTO reserva (id, id_usuario, id_destino, data, status) VALUES 
(1, 1, 2, '2023-07-10', 'confirmada'),
(2, 2, 1, '2023-08-05', 'pendente'),
(3, 3, 3, '2023-09-20', 'cancelada');

-- Selects --
-- Selecionar todos os registros da tabela "usuario"
SELECT * FROM usuario;

-- Selecionar apenas o nome e o email dos usuários
SELECT nome, email FROM usuario;

-- Selecionar os usuários que possuem o nome "João Silva"
SELECT * FROM usuario WHERE nome = 'João Silva';

-- Selecionar os usuários que nasceram antes de uma determinada data
SELECT * FROM usuario WHERE data_nascimento < '1990-01-01';

-- Like
SELECT * FROM usuario WHERE nome LIKE '%Silva%';
SELECT * FROM usuario WHERE nome LIKE 'Jo_o%';

-- Update --
UPDATE usuario SET endereco = 'Nova Rua, 123' WHERE email = 'joao@example.com';

-- delete --
DELETE FROM reserva WHERE status = 'cancelada';

-- Update --
UPDATE usuario SET endereco = 'Nova Rua, 123' WHERE email = 'joao@example.com';

-- delete --
DELETE FROM reserva WHERE status = 'cancelada';


CREATE TABLE usuario_nova (
  id INT,
  nome VARCHAR(255) NOT NULL COMMENT 'Nome do usuário',
  email VARCHAR(255) NOT NULL UNIQUE COMMENT 'Endereço de e-mail do usuário',
  data_nascimento DATE NOT NULL COMMENT 'Data de nascimento do usuário',
  endereco VARCHAR(100) NOT NULL COMMENT 'Endereço do Cliente'
);

-- Migrando os dados --

INSERT INTO usuario_nova
SELECT * from usuario;

-- Excluindo tabela anterior --
DROP table usuario;

-- Renomeando nova tabela --
ALTER TABLE usuario_nova RENAME usuario;


-- Ou opção 2 : Alterar tamanho da coluna endereço -- 
ALTER TABLE usuario MODIFY COLUMN endereco VARCHAR(100);

-- Primary Key--
-- Tabela "usuario"
ALTER TABLE usuario
MODIFY COLUMN id INT AUTO_INCREMENT,
ADD PRIMARY KEY (id);

-- Tabela "destino"
ALTER TABLE destino
MODIFY COLUMN id INT AUTO_INCREMENT,
ADD PRIMARY KEY (id);

-- Tabela "reserva"
ALTER TABLE reserva
MODIFY COLUMN id INT AUTO_INCREMENT,
ADD PRIMARY KEY (id);

-- Exemplos --

-- Inserção na tabela "usuario"
INSERT INTO usuario (nome, email, data_nascimento, endereco)
VALUES ('João Maria', 'joaomaria@example.com', '1990-01-01', 'Rua A, 123');

-- Inserção na tabela "destinos"
INSERT INTO destino (nome, descricao)
VALUES ('Praia Teste', 'Destino paradisíaco com belas praias.');

-- Inserção na tabela "reservas"
INSERT INTO reserva (id_usuario, id_destino, data, status)
VALUES (4, 4, '2023-07-01', 'pendente');

-- Chaves estrangeiras --

-- Adicionando chave estrangeira na tabela "reserva" referenciando a tabela "usuario"
ALTER TABLE reserva
ADD CONSTRAINT fk_reserva_usuario
FOREIGN KEY (id_usuario) REFERENCES usuario(id);

-- Adicionando chave estrangeira na tabela "reservas" referenciando a tabela "destinos"
ALTER TABLE reserva
ADD CONSTRAINT fk_reserva_destino
FOREIGN KEY (id_destino) REFERENCES destino(id);

-- Alterando a restrição da chave estrangeira "fk_reservas_usuarios" na tabela "reservas" para ON DELETE CASCADE
ALTER TABLE reserva
DROP FOREIGN KEY fk_reserva_usuario;

ALTER TABLE reserva
ADD CONSTRAINT fk_reserva_usuario
FOREIGN KEY (id_usuario) REFERENCES usuario(id)
ON DELETE CASCADE;


-- Adicionar colunas de endereço à tabela "Usuario"
ALTER TABLE Usuario
ADD rua VARCHAR(100),
ADD numero VARCHAR(10),
ADD cidade VARCHAR(50),
ADD estado VARCHAR(50);

-- Copia os dados da tabela original para a nova tabela
UPDATE usuario
SET rua = SUBSTRING_INDEX(SUBSTRING_INDEX(endereco, ',', 1), ',', -1),
    numero = SUBSTRING_INDEX(SUBSTRING_INDEX(endereco, ',', 2), ',', -1),
    cidade = SUBSTRING_INDEX(SUBSTRING_INDEX(endereco, ',', 3), ',', -1),
    estado = SUBSTRING_INDEX(endereco, ',', -1);

-- Exclusão da coluna "endereco" da tabela original
ALTER TABLE usuario
DROP COLUMN endereco;



INSERT INTO usuario (nome, email, data_nascimento, rua, numero, cidade, estado) 
VALUES ('Usuario sem reservas', 'semreservar@teste.com', '1990-10-10', 'Rua','123','cidade','estado');

-- Traz apenas os usuario com reservas
SELECT * FROM usuario us
INNER JOIN reserva rs
	ON us.id = rs.id_usuario;

-- Traz todos os usuario e suas reservas se tiver
SELECT * FROM usuario us
INNER JOIN reserva rs
	ON us.id = rs.id_usuario;

INSERT INTO destino ( nome, descricao) 
VALUES ('Deestino sem reserva', 'Uma bela praia com areias brancas e mar cristalino');

-- Tras todos os destinos e as reservas se tiverem -- 
SELECT * FROM reserva rs
RIGHT JOIN destino des
	ON des.id = rs.id_destino;

-- Produz o mesmo resultado que a anterior
SELECT * FROM destino des
LEFT JOIN reserva rs
	ON des.id = rs.id_destino;

-- SUb consultas

-- Usuários que não fizeram nenhuma reserva
SELECT nome
FROM usuario
WHERE id NOT IN (SELECT id_usuario FROM reserva);

-- Subconsulta para encontrar os destinos menos populares (com menos reservas):

SELECT nome
FROM destino
WHERE id NOT IN (SELECT id_destino FROM reserva)
ORDER BY id;

-- contagem de reservas por usuario

SELECT nome, (SELECT COUNT(*) FROM reserva WHERE id_usuario = usuario.id) AS total_reserva
FROM usuario;



SELECT COUNT(*) FROM usuario;

-- Media da idade dos usuario
SELECT AVG(TIMESTAMPDIFF(YEAR, data_nascimento, CURRENT_DATE())) AS idade
FROM usuario;

-- Soma da idade dos usuarios
SELECT SUM(TIMESTAMPDIFF(YEAR, data_nascimento, CURRENT_DATE())) AS media_idade
FROM usuario;

-- Menor Idade
SELECT MIN(TIMESTAMPDIFF(YEAR, data_nascimento, CURRENT_DATE())) AS media_idade
FROM usuario;

-- Maior Idade
SELECT MAX(TIMESTAMPDIFF(YEAR, data_nascimento, CURRENT_DATE())) AS media_idade
FROM usuario;

-- Ordenação
SELECT nome
FROM usuario
ORDER BY nome;

SELECT nome, data_nascimento
FROM usuario
ORDER BY data_nascimento, nome;

SELECT nome, data_nascimento
FROM usuario
ORDER BY data_nascimento, nome DESC;



-- Inserindo massa de dados --

INSERT INTO usuario (nome, email, data_nascimento, rua) VALUES
('João Silva', 'joao.silva@example.com', '1990-01-01', 'Rua A'),
('Maria Santos', 'maria.santos@example.com', '1992-03-15', 'Rua B'),
('Pedro Almeida', 'pedro.almeida@example.com', '1985-07-10', 'Rua C'),
('Ana Oliveira', 'ana.oliveira@example.com', '1998-12-25', 'Rua D'),
('Carlos Pereira', 'carlos.pereira@example.com', '1991-06-05', 'Rua E'),
('Laura Mendes', 'laura.mendes@example.com', '1994-09-12', 'Rua F'),
('Fernando Santos', 'fernando.santos@example.com', '1988-02-20', 'Rua G'),
('Mariana Costa', 'mariana.costa@example.com', '1997-11-30', 'Rua H'),
('Ricardo Rodrigues', 'ricardo.rodrigues@example.com', '1993-04-18', 'Rua I'),
('Camila Alves', 'camila.alves@example.com', '1989-08-08', 'Rua J'),
('Bruno Carvalho', 'bruno.carvalho@example.com', '1995-03-25', 'Rua K'),
('Amanda Silva', 'amanda.silva@example.com', '1996-12-02', 'Rua L'),
('Paulo Mendonça', 'paulo.mendonca@example.com', '1999-07-20', 'Rua M'),
('Larissa Oliveira', 'larissa.oliveira@example.com', '1987-10-15', 'Rua N'),
('Fernanda Sousa', 'fernanda.sousa@example.com', '1992-05-08', 'Rua O'),
('Gustavo Santos', 'gustavo.santos@example.com', '1993-09-18', 'Rua P'),
('Helena Costa', 'helena.costa@example.com', '1998-02-22', 'Rua Q'),
('Diego Almeida', 'diego.almeida@example.com', '1991-11-27', 'Rua R'),
('Juliana Lima', 'juliana.lima@example.com', '1997-04-05', 'Rua S'),
('Rafaela Silva', 'rafaela.silva@example.com', '1996-01-10', 'Rua T'),
('Lucas Pereira', 'lucas.pereira@example.com', '1986-08-30', 'Rua U'),
('Fábio Rodrigues', 'fabio.rodrigues@example.com', '1989-03-12', 'Rua V'),
('Isabela Santos', 'isabela.santos@example.com', '1994-12-07', 'Rua W'),
('André Alves', 'andre.alves@example.com', '1995-09-28', 'Rua X'),
('Clara Carvalho', 'clara.carvalho@example.com', '1990-02-15', 'Rua Y'),
('Roberto Mendes', 'roberto.mendes@example.com', '1992-07-21', 'Rua Z'),
('Mariana Oliveira', 'mariana.oliveira@example.com', '1997-05-03', 'Av. A'),
('Gustavo Costa', 'gustavo.costa@example.com', '1998-11-16', 'Av. B'),
('Lara Sousa', 'lara.sousa@example.com', '1993-06-09', 'Av. C'),
('Pedro Lima', 'pedro.lima@example.com', '1996-09-27', 'Av. D');

EXPLAIN SELECT * FROM usuario WHERE nome = "Maria";

EXPLAIN SELECT * FROM usuario us
INNER JOIN reserva rs
ON us.id = rs.id_usuario
WHERE nome = "Maria";


CREATE INDEX idx_nome ON usuario (nome);

EXPLAIN SELECT * FROM usuario WHERE nome = "Maria";