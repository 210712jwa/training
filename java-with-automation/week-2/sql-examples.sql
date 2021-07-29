-- This is a single line comment
-- Within this script, we can type the SQL that we will eventually want to execute

-- For Project-0, it's good to type in all of the queries in an editor like this, so that you can save those queries for later
-- Such that it just takes a few clicks of a button to repopulate your data and start from scratch (for demo purposes, testing things out, etc.)

/*

This is a multi-line comment
Similar to Java multi-line comments

*/
DROP TABLE IF EXISTS phone_number;
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
	-- inside of the parentheses here, we specify our columns along with the datatype and any CONSTRAINTS 
	-- column_name DATATYPE CONSTRAINTS
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL CHECK(LENGTH(first_name) > 0),
	last_name VARCHAR(255) NOT NULL CHECK(LENGTH(last_name) > 0),
	salary DOUBLE NOT NULL CHECK(salary > 0),
	department VARCHAR(50) NOT NULL,
	supervisor INTEGER
	-- CONSTRAINT `supervisor_foreign_key` FOREIGN KEY (supervisor) REFERENCES employee (id)
);

ALTER TABLE employee
	ADD CONSTRAINT `supervisor_foreign_key`
	FOREIGN KEY (supervisor) REFERENCES employee(id);

-- Inserting some data
INSERT INTO employee (first_name, last_name, salary, department)
VALUES ('Bach', 'Tran', 1000000, 'C-Suite');

INSERT INTO employee (first_name, last_name, salary, supervisor, department)
VALUES 
('John', 'Doe', 400000, 1, 'C-Suite'),
('Jane', 'Doe', 500000, 1, 'C-Suite');


-- Creating phone_number table
CREATE TABLE phone_number (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	number CHAR(12) NOT NULL, -- 111-111-1111
	employee_id INTEGER NOT NULL,
	CONSTRAINT `fk_phonenumber_employee` FOREIGN KEY (employee_id) 
		REFERENCES employee (id)
);

INSERT INTO phone_number (number, employee_id)
VALUES
('111-111-1111', 1),
('222-222-2222', 1),
('333-333-3333', 2),
('444-444-4444', 3);

-- Querying data
SELECT *
FROM employee;

SELECT first_name, last_name
FROM employee;

-- You can construct custom columns during the process of querying
-- || is used to perform string concatenation
-- The AS keyword functions as an alias
-- This will be the column name of the result set
-- Remember we are not actually modifying any data in our tables

SELECT CONCAT(e.first_name, ' ', e.last_name) AS full_name
FROM employee e;

SELECT *
FROM phone_number;

-- JOIN Example
SELECT e.id AS employee_id, e.first_name, e.last_name, pn.id AS phone_number_id, pn.number
FROM phone_number pn 
INNER JOIN employee e
ON pn.employee_id = e.id;

-- The way that query statements are structured is in the following order
-- SELECT 
-- FROM
-- Possibly a JOIN
-- WHERE 
-- GROUP BY 
-- HAVING 
-- ORDER BY

SELECT *
FROM employee e
ORDER BY e.first_name; -- By default, ORDER BY is ascending (ASC)

-- ORDER BY descending
SELECT *
FROM employee e
ORDER BY e.first_name DESC;


-- Subqueries
-- You can nest SELECT statements in the form of subqueries
-- For example, if I want to select ALL employees whose salary is greater than the 
-- average salary of all employees

-- How do we even get the average salary of all employees?
SELECT AVG(salary)
FROM employee;


SELECT *
FROM employee e
WHERE e.salary > (
	-- This is a subquery
	SELECT AVG(salary)
	FROM employee
);

-- You can also use the SELECT statement on a "fake table" that is created from a subquery
-- In technical terms, you can query from a result set.
-- Result set: the result of a particular query

SELECT sub1.full_name, LENGTH(sub1.full_name) 
FROM (
	SELECT CONCAT(first_name, ' ', last_name) AS full_name
	FROM employee
) AS sub1;

-- Adding more employees
INSERT INTO employee
(first_name, last_name, salary, department, supervisor)
VALUES
('Marika', 'Beorhtsige', 100000, 'IT', 3),
('Lutfi', 'Mikkjal', 70000, 'HR', 2),
('Karolis', 'Hameed', 65000, 'HR', 5),
('Johann', 'Vlasi', 85000, 'IT', 3);

-- GROUP BY: used to separate records into different groups, based on these records sharing a common value for a specified column
SELECT department, COUNT(*)
FROM employee e
GROUP BY e.department;

-- The most common reason we create these groups using GROUP BY is to utilize aggregate functions to produce some useful statistics about these groups
-- For example, we can get the average salary of each department
SELECT emp.department, AVG(emp.salary)
FROM employee emp 
GROUP BY emp.department;

-- HAVING: similar to WHERE, but it is used AFTER the GROUP BY clause in order to filter based on the established groups
SELECT e.department, AVG(e.salary)
FROM employee e 
GROUP BY e.department
HAVING AVG(salary) < 100000;
-- The query above only displays the departments and their average salaries, if the average salary of that department is less than 100k
-- Therefore, the C-Suite department is not included, since they make way more

-- WHERE v. HAVING
-- WHERE filters out records before we even partition records into their respective groups
-- HAVING goes after GROUP BY, which means that it is used to filter out after having already grouped

/*
 * Set Operations
 */
-- Think of Set operations as basically operating on 2 different result sets that have the same number and type of columns 

DROP TABLE IF EXISTS one;
DROP TABLE IF EXISTS two;

CREATE TABLE one (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	col_one INTEGER,
	col_two INTEGER
);

CREATE TABLE two (
	id INTEGER PRIMARY KEY,
	one INTEGER,
	two INTEGER
);

INSERT INTO one (col_one, col_two) VALUES (1, 1), (2, 2);
INSERT INTO two VALUES (1, 1, 1), (2, 1, 3);

SELECT *
FROM one;

SELECT *
FROM two;

-- UNION does not keep duplicate values
-- We have a common record of (1, 1, 1) in both RESULT SETS
-- It only keeps one
-- So UNION will produce a result set containing unique rows only
SELECT *
FROM one 
UNION 
SELECT *
FROM two;

-- UNION ALL DOES keep duplicate values
SELECT *
FROM one 
UNION ALL
SELECT *
FROM two;

-- INTERSECT will retain a duplicate row
-- This is basically used to see what is common between two result sets
SELECT *
FROM one 
INTERSECT 
SELECT *
FROM two;

-- EXCEPT will subtract out elements from the first result set that also exist in the second result set 
SELECT *
FROM one
EXCEPT 
SELECT *
FROM two;

/*
 * Scalar and aggregate functions
 * 
 * Scalar functions act on individual rows
 * For example, CONCAT, LENGTH, LOWER, TRIM, SIN, COS, TAN, UPPER, etc.
 * 
 * Based on the number of records you have, that's the number of outputs you will receive in your result set
 * 
 * Aggregate functions act on groups
 * For example, AVG, SUM, MAX, MIN, COUNT
 * 
 * Based on the number of groups you have, that's the number of outputs you will receive in your result set
 * GROUP BY is used in conjunction w/ aggregate functions in order to segregate data into groups that the
 * aggregate function can act on.
 */
