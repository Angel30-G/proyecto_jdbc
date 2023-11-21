#Nombre: Angel Gabriel Vargas Varela 
#Carnet: 2021080292

INSERT INTO celebridad (nombre, rol)
VALUES
  ('Jennifer Aniston', 'Actriz'),
  ('Brad Pitt', 'Actor'),
  ('Meryl Streep', 'Director'),
  ('Leonardo DiCaprio', 'Actor'),
  ('Emma Watson', 'Actriz'),
  ('Dwayne Johnson', 'Actor'),
  ('Julia Roberts', 'Director'),
  ('Tom Hanks', 'Actor'),
  ('Charlize Theron', 'Actriz'),
  ('George Clooney', 'Actor');
  
  INSERT INTO series (titulo, episodios, temporadas, calificacion, genero, sinopsis, visto, celebridad)
values
  ('Juego de tronos', 18, 3, 9, 'Ciencia ficción', 'Una serie de ciencia ficción', 'Sí', 1),
  ('Juego de tronos', 18, 3, 9, 'Ciencia ficción', 'Una serie de ciencia ficción', 'Sí', 2),
  ('Juego de tronos', 18, 3, 9, 'Ciencia ficción', 'Una serie de ciencia ficción', 'Sí', 3),
  ('Juego de tronos', 18, 3, 9, 'Ciencia ficción', 'Una serie de ciencia ficción', 'Sí', 4),
  ('Breaking bad', 20, 5, 7, 'Suspenso', 'Una serie de fantasía', 'No', 8),
  ('Breaking bad', 20 , 6, 9, 'Suspenso', 'Una serie de suspenso', 'Sí', 9),
  ('Vikingos', 40, 7, 8, 'Misterio', 'Una serie de misterio', 'Sí', 5),
  ('The Witcher', 12, 8, 7, 'Acción', 'Una serie de acción', 'No', 6),
  ('The last of us', 8, 9, 9, 'Romance', 'Una serie romántica', 'Sí', 8),
  ('Hacks', 10, 10, 8, 'Comedia', 'Una serie cómica', 'Sí', 1);
  
  
  INSERT INTO cine (nombre, ubicacion)
VALUES
  ('Cine A', 'Ciudad 1'),
  ('Cine B', 'Ciudad 2'),
  ('Cine C', 'Ciudad 3'),
  ('Cine D', 'Ciudad 4'),
  ('Cine E', 'Ciudad 5'),
  ('Cine F', 'Ciudad 6'),
  ('Cine G', 'Ciudad 7'),
  ('Cine H', 'Ciudad 8'),
  ('Cine I', 'Ciudad 9'),
  ('Cine J', 'Ciudad 10');
  

INSERT INTO visualizacion (veces_vista, lugar, fecha, cine)
VALUES
  (3, 'Casa', '2023-01-15', null),
  (2, 'Cine B', '2023-02-20', 1),
  (4, 'Cine A', '2023-03-10', 3),
  (1, 'Cine C', '2023-04-05', 4),
  (5, 'Casa', '2023-05-12', null),
  (2, 'Cine D', '2023-06-18', 6),
  (3, 'Cine A', '2023-07-22', 2),
  (2, 'Cine C', '2023-08-30', 1),
  (4, 'Cine D', '2023-09-14', 3),
  (1, 'Cine B', '2023-10-19', 4);
  
  
INSERT INTO peliculas (titulo, sinopsis, visto, genero, nota, visualizacion, celebridad)
VALUES
  ('Titanic', 'Sinopsis 1', 'Sí', 'Drama', 8, 1, 1),
  ('Titanic', 'Sinopsis 1', 'Sí', 'Drama', 8, 1, 2),
  ('Titanic', 'Sinopsis 1', 'Sí', 'Drama', 8, 1, 3),
  ('Titanic', 'Sinopsis 1', 'Sí', 'Drama', 8, 1, 4),
  ('Star Wars', 'Sinopsis 2', 'No', 'Fantasía', 7, null, 8),
  ('Harry Potter', 'Sinopsis 3', 'Sí', 'Suspenso', 9, 6, 9),
  ('Avatar', 'Sinopsis 4', 'Sí', 'Misterio', 8, 7, 5),
  ('El conjuro', 'Sinopsis 5', 'No', 'Acción', 7, null, 2),
  ('La monja', 'Sinopsis 6', 'Sí', 'Romance', 9, 9, 3),
  ('Shrek', 'Sinopsis 7', 'Sí', 'Comedia', 8, 10, 2);
  
CREATE VIEW PeliculasEnMiCasa AS
SELECT p.titulo AS nombre_pelicula, p.sinopsis, c.nombre AS nombre_director
FROM peliculas p
JOIN celebridad c ON p.celebridad = c.id
JOIN visualizacion v ON p.visualizacion = v.id
WHERE v.lugar = 'Casa' AND p.visto = 'Sí' AND c.rol = 'Director' ;

select * from PeliculasEnMiCasa;
select * from celebridad;