DROP database IF exists MazmorraSQL;
CREATE DATABASE MazmorraSQL;
Use MazmorraSQL;
DROP TABLE IF EXISTS ObjetosJugador;
Create table ObjetosJugador(
 id int auto_increment primary key,
 nombre varchar(50)
);