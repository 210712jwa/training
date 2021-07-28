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
	supervisor INTEGER -- ,
	-- CONSTRAINT `supervisor_foreign_key` FOREIGN KEY (supervisor) REFERENCES employee (id)
);

ALTER TABLE employee
	ADD CONSTRAINT `supervisor_foreign_key`
	FOREIGN KEY (supervisor) REFERENCES employee(id);

-- Inserting some data
INSERT INTO employee (first_name, last_name, salary)
VALUES ('Bach', 'Tran', 1000000);

INSERT INTO employee (first_name, last_name, salary, supervisor)
VALUES 
('John', 'Doe', 400000, 1),
('Jane', 'Doe', 500000, 1);


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
SELECT e.id AS somerandomcolumnname, e.first_name, e.last_name, pn.number
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

-- WHERE v. HAVING
-- GROUP BY




