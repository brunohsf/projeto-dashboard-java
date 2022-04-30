create table tiposanguineo (
	idtiposanguineo serial not null,
	tiposanguineo varchar(2),
	constraint pk_tiposanguineo primary key (idtiposanguineo)
);

create table uf (
	iduf serial not null,
	uf varchar(2),
	constraint pk_uf primary key(iduf)
);

create table endereco (
	idendereco serial not null,
	endereco varchar(50),
	cep varchar(11),
	iduf int not null,
	constraint pk_endereco primary key(idendereco),
	constraint fk_endereco_uf foreign key(iduf) references uf(iduf)
);

create table cadastro (
	idcadastro serial not null,
	nome varchar (50),
	idendereco int not null,
	constraint pk_cadastro primary key(idcadastro),
	constraint fk_cadastro_endereco foreign key(idendereco) references endereco(idendereco)
);

create table paciente (
	idpaciente serial not null,	
	idcadastro int not null,
	idtiposanguineo int,
	peso float,	
	constraint pk_paciente primary key(idpaciente),
	constraint fk_paciente_cadastro foreign key(idcadastro) references cadastro(idcadastro),
	constraint fk_paciente_tiposanguineo foreign key(idtiposanguineo) references tiposanguineo(idtiposanguineo)

);


insert into tiposanguineo(tiposanguineo) values ('A+');
insert into tiposanguineo(tiposanguineo) values ('A-');
insert into tiposanguineo(tiposanguineo) values ('B+');
insert into tiposanguineo(tiposanguineo) values ('B-');
insert into tiposanguineo(tiposanguineo) values ('AB');
insert into tiposanguineo(tiposanguineo) values ('O+');
insert into tiposanguineo(tiposanguineo) values ('O-');



insert into uf (uf) values ('Rondônia');
insert into uf (uf) values ('Acre');
insert into uf (uf) values ('Amazonas');
insert into uf (uf) values ('Roraima');
insert into uf (uf) values ('Pará');
insert into uf (uf) values ('Amapá');
insert into uf (uf) values ('Tocantins');
insert into uf (uf) values ('Maranhão');
insert into uf (uf) values ('Piauí');
insert into uf (uf) values ('Ceará');
insert into uf (uf) values ('Rio Grande do Norte');
insert into uf (uf) values ('Paraíba');
insert into uf (uf) values ('Pernambuco');
insert into uf (uf) values ('Alagoas');
insert into uf (uf) values ('Sergipe');
insert into uf (uf) values ('Bahia');
insert into uf (uf) values ('Minas Gerais');
insert into uf (uf) values ('Espírito Santo');
insert into uf (uf) values ('Rio de Janeiro');
insert into uf (uf) values ('São Paulo');
insert into uf (uf) values ('Paraná');
insert into uf (uf) values ('Santa Catarina');
insert into uf (uf) values ('Rio Grande do Sul (*)');
insert into uf (uf) values ('Mato Grosso do Sul');
insert into uf (uf) values ('Mato Grosso');
insert into uf (uf) values ('Goiás');
insert into uf (uf) values ('Distrito Federal');


