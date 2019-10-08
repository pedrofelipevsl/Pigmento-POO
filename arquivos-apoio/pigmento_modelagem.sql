/* pigmento_modelagem: */

CREATE TABLE PIGMENTO (
    id VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(45),
    estoque REAL,
    preco REAL,
    tipo INTEGER,
    cor_r INTEGER,
    cor_b INTEGER,
    cor_g INTEGER,
    cor_c INTEGER,
    cor_m INTEGER,
    cor_y INTEGER,
    cor_k INTEGER
);