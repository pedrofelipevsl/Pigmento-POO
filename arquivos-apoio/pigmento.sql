CREATE TABLE pigmento(
	idPigmento varchar(10) NOT NULL,
	nome varchar(30),
	estoque real,
	preco real,
	tipo int,
	corR int,
	corG int,
	corB int,
	corC int,
	corM int,
	corY int,
	corK int,
	PRIMARY KEY	(idPigmento)
);

insert into pigmento values ('Blue0255', 'Blue', 11.6, 1.34, 1, 0, 0, 255, null, null, null, null);

insert into pigmento values ('Oran021', 'Orange021', 12.7, 2.35, 2, null, null, null, 0, 53, 100, 0);

insert into pigmento values ('FGree34', 'ForestGreen', 7.9, 3.62, 1, 34, 139, 34, null, null, null, null);

insert into pigmento values ('Choc210', 'Chocolate', 10.3, 4.10, 1, 210, 105, 30, null, null, null, null);

insert into pigmento values ('WRed75', 'WarmRed', 7.6, 4.69, 2, null, null, null, 0, 75, 90, 0);

insert into pigmento values ('Gold255', 'Gold', 12.6, 4.91, 1, 255, 215, 0, null, null, null, null);

insert into pigmento values ('Khaki125', 'Khaki1', 34.3, 5.28, 1, 255, 246, 143, null, null, null, null);

insert into pigmento values ('Thistle21', 'Thistle', 24.3, 5.46, 1, 216, 191, 216, null, null, null, null);

insert into pigmento values ('Yellow30', 'Yellow', 11.3, 6.91, 2, null, null, null, 0, 3, 100, 0);

insert into pigmento values ('Alfa42B', 'Especiaria Antiga', 32.5, 7.5, 1, 180, 108, 114, null, null, null, null);

-- 

UPDATE PIGMENTO SET estoque = 11.6 WHERE idPigmento = 'Blue0255'; 

select * from pigmento

SELECT idPigmento, nome, estoque, preco, tipo, corR, corG, corB FROM PIGMENTO

SELECT idPigmento, nome, estoque, preco, tipo, corC, corM, corY, corK FROM PIGMENTO

SELECT idPigmento, nome, estoque, preco, tipo, corR, corG, corB, corC, corM, corY, corK FROM PIGMENTO