#Nombre: Angel Gabriel Vargas Varela 
#Carnet: 2021080292
create database MIBDP;
show databases;
use MIBDP;

create table celebridad(
  id int not null auto_increment,
  nombre varchar(50) not null,
  rol varchar(50) not null,
  primary key(id)
);

  
  
create table series(
  id int not null auto_increment,
  titulo varchar(50) not null,
  episodios int,
  temporadas int not null,
  calificacion int not null,
  genero varchar(50) not null,
  sinopsis varchar(50) not null,
  visto varchar(50) not null,
  celebridad int not null,
  primary key(id),
  foreign key(celebridad) references celebridad(id)
);

  
create table cine(
  id int not null auto_increment,
  nombre varchar(50) not null,
  ubicacion varchar(50) not null,
  primary key(id)
);
  
  
create table visualizacion(
  id int not null auto_increment,
  veces_vista int not null,
  lugar varchar(50) not null,
  fecha date,
  cine int,
  primary key(id),
  foreign key(cine) references cine(id)
);



create table peliculas(
  id int not null auto_increment,
  titulo varchar(50) not null,
  sinopsis varchar(50) not null,
  visto varchar(2) not null,
  genero varchar(50) not null,
  nota int not null,
  visualizacion int,
  celebridad int not null,
  primary key(id),
  foreign key(visualizacion) references visualizacion(id),
  foreign key(celebridad) references celebridad(id)
);

