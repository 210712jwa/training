DROP TABLE IF EXISTS ship;

CREATE TABLE ship (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	age INTEGER DEFAULT 0
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

SELECT *
FROM ship;

SELECT * FROM jdbc_demo.ship;

/*
 * The 3 DML operations (not including SELECT) are INSERT, UPDATE, and DELETE
 */
UPDATE ship 
SET 
name = 'Black Pearl',
age = 1
WHERE id = 1;
