/*crear base de datos*/
CREATE DATABASE MultiMedia

/*mostrar las bases de datos*/
SHOW DATABASES

/*usar la base de datos*/
USE MultiMedia

/*mostrar las tablas*/
SHOW TABLE

/*creamos la primera tabla*/
CREATE TABLE Movies (
	id INT,
    name VARCHAR(50),
    director VARCHAR(50),
    date DATE,
    genre VARCHAR(50),
    country VARCHAR(10),
    poster VARCHAR(500)
)

/*mostrar los datos de una tabla*/
SELECT * FROM Movies

/*insertar datos a una tabla*/
INSERT INTO Movies (id, name, director, date, genre, country)
VALUES (1, 'Avatar', 'James Cameron', '2009-12-18', 'Action', 'USA')

INSERT INTO Movies (id, name, director, date, genre, country)
VALUES (2, 'I am Legend', 'Francis Lawrence', '2007-12-14', 'Drama', 'USA')

INSERT INTO Movies (id, name, director, date, genre, country)
VALUES (3, 'Shutter Island', 'John Doe', '1997-01-14', 'Thriller', 'USA')

INSERT INTO Movies (id, name, director, date, genre, country)
VALUES (4, 'Predestination', 'Etan Hawk', '1995-05-20', 'Comedy', 'USA')

/*borrar todos los datos de una tabla*/
DELETE FROM Movies 

/*borrar un dato de una tabla*/
DELETE FROM Movies WHERE id = 2