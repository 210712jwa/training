DROP TABLE IF EXISTS pirate;
DROP TABLE IF EXISTS ship;

CREATE TABLE ship (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	age INTEGER DEFAULT 0
);

CREATE TABLE pirate (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	age INTEGER NOT NULL,
	ship_id INTEGER NOT NULL,
	CONSTRAINT `fk_pirate_ship` FOREIGN KEY (ship_id) REFERENCES ship(id)
);

INSERT INTO ship 
(name)
VALUES 
('Black Pearl');

INSERT INTO ship 
(name, age) 
VALUES
('Royal Fortune', 10),
('Queen Anne''s Revenge', 5);

INSERT INTO pirate (name, age, ship_id) 
VALUES 
('Blackbeard', 34, 3),
('Bach Tran', 23, 3),
('Jack Sparrow', 28, 1);

SELECT *
FROM ship;

SELECT * FROM jdbc_demo.ship;

/*
 * The 3 DML operations (not including SELECT) are INSERT, UPDATE, and DELETE
 */
-- UPDATE ship 
-- SET 
-- name = 'Black Pearl',
-- age = 1
-- WHERE id = 1;
-- 
-- DELETE FROM ship 
-- WHERE id = 6;

SELECT *
FROM jdbc_demo.pirate p
WHERE p.ship_id = 3;


