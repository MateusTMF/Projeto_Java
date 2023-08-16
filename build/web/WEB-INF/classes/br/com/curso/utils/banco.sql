create table estado(
    idestado serial primary key,
    nomestado varchar(100) not null,
    siglaestado varchar(2) not null
);

insert into estado(nomestado, siglaestado) values('São Paulo', 'SP');

create table veiculo (
	idveiculo serial primary key,
	marcaveiculo varchar(100) not null,
	modeloveiculo varchar(100) not null
);

insert into veiculo (marcaveiculo,modeloveiculo)
values ('TOYOTA', 'COROLLA');

create table imovel (
	idimovel serial primary key,
	descricao varchar(100) not null,
	endereco varchar(100) not null,
        valoraluguel float
);

insert into imovel (bairroimovel, cidadeimovel)
values ('CENTRO', 'JALES');
