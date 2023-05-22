create database mazmorra;
use mazmorra;

create table personaje(
	ID int auto_increment primary key,
	Nombre varchar(40),
    Objetos varchar(40)
);

create table objetos(
	id int auto_increment primary key,
    Nombre varchar(40),
    Ataque int
);