
CREATE TABLE aluno(
	id serial primary key,
	nome varchar(30) not null,
	matricula varchar(20) not null,
	data Date);

CREATE TABLE avaliacao(
	id serial primary key,
	idAlunoAvaliado int,
	comentario varchar(200),
	nota float not null,
	FOREIGN KEY (idAlunoAvaliado) REFERENCES aluno(id));

CREATE TABLE fez_avaliacao(
	idAlunoAvaliado int not null,
	idAlunoAvaliador int not null,
	PRIMARY KEY (idAlunoAvaliado, idAlunoAvaliador),
	FOREIGN KEY (idAlunoAvaliado) REFERENCES aluno(id),
	FOREIGN KEY (idAlunoAvaliador) REFERENCES aluno(id));



-- TESTES DE INSERÇÃO:
insert into fez_avaliacao (idAlunoAvaliado, idAlunoAvaliador) VALUES (2, 17)
insert into aluno (nome, matricula, data) VALUES ('facada', '21233443', '1992-06-21');

insert into avaliacao (idAlunoAvaliado, comentario, nota) VALUES (2, 'mas que fiasco', 30.5);
select * from fez_avaliacao