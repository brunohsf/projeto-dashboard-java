create table cadastro (
	idcadastro serial not null,
	nome varchar (50),
	idendereco int not null,
	constraint pk_cadastro primary key(idcadastro),
	constraint fk_cadastro_endereco foreign key(idendereco) references endereco(idendereco)
)

create table paciente (
	idpaciente serial not null,	
	idcadastro int not null,
	idtiposanguineo int,
	peso float,	
	constraint pk_paciente primary key(idpaciente),
	constraint fk_paciente_cadastro foreign key(idcadastro) references cadastro(idcadastro),
	constraint fk_paciente_tiposanguineo foreign key(idtiposanguineo) references tiposanguineo(idtiposanguineo)

)

create table uf (
	iduf serial not null,
	uf varchar(2),
	constraint pk_uf primary key(iduf)
)

create table endereco (
	idendereco serial not null,
	endereco varchar(50),
	cep varchar(11),
	iduf int not null,
	constraint pk_endereco primary key(idendereco),
	constraint fk_endereco_uf foreign key(iduf) references uf(iduf)
)

create table tiposanguineo (
	idtiposanguineo serial not null,
	tiposanguineo varchar(2),
	constraint pk_tiposanguineo primary key (idtiposanguineo)
)




