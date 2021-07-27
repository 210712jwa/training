# SQL (Structured Query Language)

SQL = Structured Query Language

It is NOT a programming language. It's a language we use to perform operations against a **relational database**.

Relational Database: A database that is structured in the form of tables that could be potentially related to each other through foreign keys and primary keys.

A database is a collection of data in some organized format
- Allows us to input, manage, and retrieve data quickly
- Traditionally, in the form of relational databases, is organized into "tables" with "records" as rows and "fields" as columns
- Data is the intersection between rows and columns (cell)

# Relational Database Management System (RDBMS)
To provide for a way of utilizing the concept of relational databases, we have RDBMSes, or relational database management systems
- This is the actual "engine"/"brain" of the database
- Upholds relationships between tables
- Maintains security, accuracy, integrity, and consistency of the data
- There are many different dialects/flavors of SQL
    - MariaDB
    - PostgreSQL ("Postgres")
    - MySQL
    - Oracle SQL
    - MS SQL Server

# Datatypes

## Numeric
- TINYINT
- INTEGER / INT
- BIGINT
- DECIMAL / NUMERIC
- DOUBLE
- FLOAT

## Characters / Strings
- VARCHAR
- CHAR
- TINYTEXT
- TEXT
- MEDIUMTEXT
- LONGTEXT

## Binary Data
Can be used to store files on your database (or also characters/text since it falls under that category as well)
- TINYBLOB
- BLOB
- MEDIUMBLOB
- LONGBLOB

# DATE AND TIME
- DATE
- TIME
- DATETIME
- TIMESTAMP

# Schema
There's in general 2 definitions of schema:

1. A database schema refers to the formal structure of data in our relational database. This includes tables and their columns, constraints, and relationships, which are describable through entity relationship diagrams (ERDs).

2. It also refers to the collection of database objects that exist in our database. This includes tables, stored procedures, etc. 


# SQL Sublanguages
- DDL = Data Definition Language
    - For creation/alteration of the table structure
    - This is how we actually define the schema for our database
        - Schema: a collection of database "objects"
            - Tables
            - Stored procedures
            - Constraints
            - etc.
    - CREATE, ALTER, TRUNCATE, DROP
        - CREATE: used to add a new database object (ex. creating a table)
        - ALTER: used to modify an existing database object (ex. adding a new column to a table)
        - TRUNCATE: deletes all the data in a table without deleting the table itself
        - DROP: deletes the entire table (with all of the data inside of the table, of course)
- DML = Data Manipulation Language
    - Changing/manipulating/modifying data within a table (modifying the records in a table)
    - CRUD operations (Create, read, update, delete)
    - INSERT, SELECT, UPDATE, DELETE
        - INSERT: insert a new record into a table
        - SELECT: retrieve data from a table
        - UPDATE: update existing records in a table
        - DELETE: delete a record in a table
- DQL = Data Query Language
    - This sublanguage pertains to the `SELECT` statement
    - Some developers consider the SELECT keyword to be separate from DML
    - For the purposes of training, QC, one-on-ones, we'll just consider SELECT as part DML, but you can mention this difference if you want
- DCL = Data Control Language
    - Regulate access to the data by imposing restrictions such as user permissions
    - Pertains to security
    - GRANT, REVOKE
- TCL = Transaction Control Language
    - Pertains to database transactions
    - Transaction: "a single unit of work", in particular it's based around DML operations
        - During the course of executing multiple DML statements, we can have them treated as a single transaction
    - Through TCL commands, we can finalize or revert those DML statements that are part of a single transaction
    - COMMIT, ROLLBACK, SAVEPOINT, SET TRANSACTION (isolation level)
        - Once you commit a transaction, it is permanent. There is no rolling back using ROLLBACK
        - ROLLBACK can only be used before you COMMIT a transaction (for example, if you didn't like the changes and haven't committed yet)
        - So COMMITTING is something you only do if you're sure you want those changes

# SELECT in more detail
The SELECT statement is probably the most widely used keyword in SQL, since it is what we use in order to actually retrieve data from the database. This is what contains a lot of intracies with regards to how we want to retrieve the data according to what conditions and how to ultimately format the data in the final result.

## SELECT
```sql
SELECT column1, column2
FROM table_name;
```

Select all of the columns, we can use the (*) wildcard

```sql
SELECT *
FROM table_name;
```

## WHERE
```sql
SELECT *
FROM person
WHERE id = 1;
```

## GROUP BY
The group by clause can be added after SELECT ... FROM ... WHERE ... in order to aggregate together records that have the same value for some given column, and then have some type of aggregate function applied to each of these groups

Example: let's say we have an employee table, with columns
- name (employee name)
- salary (a number for their salary)
- department (IT, HR, Finance, etc.)

Let's say we want the average salary for a given department

```sql
SELECT department, AVG(salary)
FROM employee
GROUP BY department;
```

Output example

| Department | AVG(salary) |
| :--------- | :---------- |
| IT | 55343 |
| HR | 45343 |
| Finance | 53232 |
| ... | ... |

## HAVING
Associated with the GROUP BY clause is the `HAVING` clause. This is used to filter out results AFTER we have already grouped together different records based on a common value for the specified column.

For example, let's say we want to list out the departments whose average salary is greater than $50,000.

```sql
SELECT department, AVG(salary)
FROM employee
GROUP BY department
HAVING AVG(salary) > 50000
```

| Department |
| :--------- |
| IT |
| Finance |
| ... |

**It is important to understand the difference between `WHERE` and `HAVING`**
- Scalar functions CAN be contained inside the WHERE clause (as well as the HAVING clause)
- Aggregate functions can be contained in the HAVING clause, but not the WHERE clause

# Aggregate and Scalar Functions

## Scalar Functions
Scalar functions act on individual values, PER RECORD. Scalar functions can be used within the `SELECT` and `WHERE` clause

- UPPER(): used to capitalize a word
- LOWER(): used to lowercase a word
- LENGTH(): used to convert a word into a number representing the length of the word
- ROUND(): used to a round a number
- ABS(): a negative number becomes positive
- Many others

## Aggregate Functions
Aggregate functions operate on multiple values (groups of values). Aggregate functions will take the values of the entire group and transform them into a single value. 

You can create groups using `GROUP BY`, which will group records according to shared values for a given column. (for example, `GROUP BY department` would group employees into their respective departments)

- MAX()
- MIN()
- AVG()
- SUM()
- COUNT()

Get the max salary in a department
```sql
SELECT department, MAX(salary)
FROM employees
GROUP BY department
```

Get the list of departments and the count of employees in each department, IF the department has more than 5 employees

```sql
SELECT department, COUNT(id)
FROM employees
GROUP BY department
HAVING COUNT(id) > 5;
```

Get the list of departments and the average salary of the employees in that department, not including employees with a salary 50,000 or less, but displaying only the averages greater than 100000.

```sql
SELECT department, AVG(salary)
FROM employees
WHERE salary > 50000
GROUP BY department
HAVING AVG(salary) > 100000;
```
It is important to understand what exactly is happening in the SQL above. We are first filtering out any employee in our table with a salary less than 50000 (as if they don't exist). Then we are grouping together all of the employees based on their departments. This means that when we are doing the grouping, we're not including the employees making 50000 or less. So, the average salary per department is only based on the employees making more than 50000.
Then from there, we are narrowing down what we output for our result to the departments with the average being more than 100000.

# Multiplicity / Cardinality
Describes the relationship between 2 tables. There are 3 categories of relationships:

- 1 to 1
    - Records in one table are associated with only 1 record in another table
    - Can be created using a foreign key constraint and a unique constraint on the same column (this could be done one either table)
    - ex. Classrooms and Projectors
        - 1 classroom has 1 projector
- 1 to many (many to 1)
    - Each records in one table can be associated with many records in another table
    - ex. one beehive has many bees / many bees belong to one beehive
    - ex2. one ship has many pirates / many pirates belong to one ship
    - To establish this relationship, the foreign key has to be on the many side of the relationship
        - In the bees table, we would have a column called beehive_id, that will have the beehive that that particular bee belongs to
- many to many
    - Records in both tables are associated with many records in the other
    - ex. Students and Courses
        - a student can have many courses, but a course can also have many students
        - Therefore, many students have many courses
    - To establish this relationship, we need a join table

### Students Table
| id | name |
| :- | :--- |
| 1 | John |
| 2 | Jane |
| 3 | Bob |

### Courses table
| id | name |
| :- | :--- |
| 1 | Algebra |
| 2 | History |

### Join Table
| student_id | course_id |
| :--------- | :-------- |
| 1 | 1 |
| 1 | 2 |
| 3 | 1 |
| 2 | 2 |

# Referential Integrity
Whenever we create relationships between tables, such as by having a foreign key in one table link to the primary key in anther table, we want to ensure that there are no **orphan records**. If you have one table's data that points to another table's data through a foreign key, and we try to delete the data being pointed to, the foreign key containing data in the first table would be "orphaned". SQL prevents you from doing this without first deleting the record with the foreign key.

- Example: if you try to delete a beehive that has many bees that belong to it, this would mean that the bees would now be orphans. However, SQL doesn't allow this. We need to delete the bees before we can delete the beehive.

# Constraints
In SQL, we have the idea of constraints that we can define for our specific columns when defining a table. This allows us to ensure consistency with our data and also its integrity. Some of the constraints are the following:

- PRIMARY KEY: serves as a unique identifier for a record in a table
    - Implicitly makes use of 2 other constraints, UNIQUE + NOT NULL
- FOREIGN KEY: serves as a reference to a primary key in another table (could also actually be a primary key in the same table as well). Foreign keys are used in order to establish a multiplicative relationship (one-to-one, one-to-many, many-to-many).
- UNIQUE: means we can only have unique values for a certain column
- NOT NULL: means you cannot have no value for that particular column for a record
- CHECK: Ensures that data must follow a certain condition. For example, `CHECK (age) >= 18` means we cannot insert or modify existing records to have an age below 18.
- DEFAULT: If we do not provide a value for a column with this constraint, it will by DEFAULT have a certain value. For example, `DEFAULT 0` on a certain column will mean that the value defaults to 0 if nothing is specified. Without the default constraint, you will have a NULL value if you don't specify any value.
- Composite Keys: two or more columns that, when combined, behave as a primary key

## Composite Keys
Most of the time, the primary key will just be a single column. Sometimes, however, multiple columns may be used together to create a primary key to uniquely identify a row. Each column that makes up this primary key, is known as a **candidate key**. This forms a primary key with multiple columns that is known as a **composite key**. 

Example: a CD collection

We may have a table called `song` that has the columns `track_no`, `album_id`, `genre`, etc. Notice that `track_no` by itself wouldn't really work as a primary key, because you might have the same track_no's over and over again per album. However, if we combine the two columns `track_no` and `album_id` into a composite key, it is possible to uniquely identify each song.

# Database Normalization
Normalization is how we aim to reduce redundancy and duplicate data when designing databases. It aims to help keep a database organized, expandable, and maintainable.

Levels of normalization:
- 0NF = Zero Normal Form (not really a normalization level)
    - No normalization at all
    - Total chaos
- 1NF = 1st Normal Form
    - Data should be atomic
    - Table must have a primary key
- 2NF = 1st NF + No partial dependencies
    - Cannot have columns that are dependent on only one part of the composite key
    - If you don't have any composite keys, you are already in 2NF
- 3NF = 2nd NF + No transitive dependencies
    - If you have column C, describing column B, which describes the PK (column A) we are not in 3NF because C is only indirectly related to the primary key
    - "Every column should describe only the primary key and nothing else" 

General Guidelines
- 1NF: We must have a key
- 2NF: We must describe the whole key
- 3NF: And we should describe nothing but the key

# Transaction Properties: ACID
Whenever we perform modifications to the data in our database, we are utilizing the SQL sublanguage DML (data manipulation language) (INSERT, SELECT, UPDATE, DELETE). This is dealing with records being created or updated or deleted from our table. Whatever operations occur before a COMMIT or ROLLBACK statement are considered as a single transaction (if you turn autocommit off, which is actually on by default). 

An example of a transaction might be transferring money from one bank account to another. There are two different operations that would need to happen here. We would need to modify the record of one account, lowering the balance of that account, and modify the record of the receiving account, raising the balance of that account (we would be doing two UPDATE statements). 

You could imagine that the above example could have multiple failure points along the way. For example,
1. Let's say we're in the middle of withdrawing from the sending account, but then the power goes out to our database. That money is lost because it hasn't yet reached the receiving account
2. The account we are withdrawing from doesn't have sufficient balance (we don't want to credit the receiving account unless the withdrawal from the sending account was successful).

We want to avoid these two issues by treating the withdrawing from sending account and depositing to the receiving account as a single transaction instead of two separate transactions. This way, if the transaction fails at any point, the whole thing is either successful or not at all.

- Atomicity: a transaction will either completely succeed or not at all. There is no in between state. There is only the state before the transaction and after the transaction.
- Consistency: constraints are enforced for every transaction that is committed. We cannot commit changes if they violate constraints set for the database. Remember that examples of constraints could be PRIMARY KEY, FOREIGN KEY, CHECKS, NOT NULL, UNIQUE. There is also upholding referential integrity as well as upholding data types.
- Isolation: If we have two transactions occurring at the same time, this principle of isolation is talking about how we should deal with these concurrent transactions. If we have two transactions occurring, they should not be disturbing each other (ideally). We have different isolation levels that we can set for our database. 
- Durability: When a transaction is complete (has been committed), it is stored to permanent memory (hard drive) instead of RAM. This means that even if we restarted our system or lost power, etc., our data would still be there. (unless your hard drive gets destroyed).

# Read Phenomena
Read phenomena refers to 3 different phenomenon that can occur with two or more concurrent transactions. These are essentially issues that could occur that we should be aware of depending on what isolation level is set for our database.

[Link to a great wikipedia article on various database concurrency issues (read phenomena)](https://en.wikipedia.org/wiki/Isolation_(database_systems)#Read_phenomena)

This is related to the I (isolation) in ACID properties. It refers to the degree in which two transactions will interfere with each other when doing some sort of modifications and reads on the same data.
- When applications become more complex and there is more traffic to the database, we need account for these issues
- The more strict our isolation level, the more careful the system is about avoiding conflicts, but this could cause performance issues since concurrency would decrease with a more strict level

| Isolation Level | Dirty Read | Non-repeatable Read | Phantom Read | 
| :--------- | :--------- | :--------- | :--------- |
| Read Uncommitted | Y | Y | Y |
| Read Committed | N | Y | Y |
| Repeatable Read | N | N | Y |
| Serializable | N | N | N |

# Database Joins
- Joins are operations that allow us to "join" together data from different tables
- Useful when retrieving data when there is a relationship between two tables (or three, or four)
- Several Types
    - INNER JOIN
        - Shows records where a condition matches both sides
    - FULL OUTER JOIN
        - Show matching records and records that don't have a match, with NULL values on the opposite side for non-matching cases
    - LEFT/RIGHT JOIN
        - Data from the LEFT table (or RIGHT) are paired with another table, with NULLS if no match is found for the other side
    - CROSS JOIN
        - Not really used all that much
        - Cross product of both tables
        - List of permutations
            - A lot of data, if you have many records
            - 1000 records in Table A, 2000 in Table B
                - 2,000,000 records (1000 * 2000)
    - SELF JOIN
        - Not really a type of join, but it describes joining a foreign key to a primary key ON THE SAME TABLE
            - If you have an employee table, you might have a manager_id FK, that just points to the id column (PK) in the same table

```sql
SELECT <columns>
FROM <left table>
<JOIN TYPE> JOIN <right table>
ON <left/right table>.column = <right/left table>.column;
```

### Theta Join v. Equi-join
Equi-join
- All equi-join really means is using the = operator within the ON clause
- Most common

Theta Join
- Using something other than `=`, such as `>`, `<`, `!=`

# Set Operations
Set operations are performed using set operators, which are different than joins. Instead of joining tables "horizontally", set operators "join vertically"

These operations don't modify the data (just like how joins do not modify the data in the tables). They just return a "result set" of the data from the database.

Some operators include:
- `UNION` or `UNION ALL`
    - `UNION` does not keep duplicates while `UNION ALL` does
- `INTERSECT`
    - returns records that are common between both sides
- `EXCEPT`
    - removes from our first result set the rows that appear in the second result set
        - In other words, returns to us the first set minus the second set
