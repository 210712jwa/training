# SQL Study Guide

# Basics
- Schema 
    - A collection of different database objects (For MariaDB, this shows up as a "Databases")
        - Tables
        - Views
        - Stored Procedures
        - Indices
        - Triggers
        - Sequences
        - etc
    - Another definition would be that a schema is a plan / structure for your database
        - Often times modelled through ERDs (Entity Relationship Diagram)
- SQL sublanguages
    - DDL (Data Definition Language)
        - CREATE
            - used to create a new table and define a structure for that table (columns, datatypes, constraints)
        - ALTER
            - alter the structure of the table
                - add columns/constraints
                - remove columns/constraints
                - etc.
        - DROP
            - delete a table
        - TRUNCATE
            - deletes all data from a table, but not the table itself
    - DML (Data Manipulation Language)
        - It encompasses what are known as CRUD operations
        - INSERT: insert rows into a table
        - SELECT: used to query data
            - There is a certain order that your clauses will go in when using SELECT:
                - SELECT
                - FROM
                - JOIN... ON ...
                - WHERE
                - GROUP BY
                - HAVING
                - ORDER BY <column_name> (DESC/ASC)
        - UPDATE: used to update data that already exists within the table
            - Typically used with a WHERE clause
                - If you don't use a WHERE clause, it will update every single record to that value for a particular column
            - ex. `UPDATE jdbc_demo.ship SET name = ?, age = ? WHERE id = ?`
        - DELETE: deletes rows from a table, usually used with WHERE (otherwise you delete everything)
            - ex. `DELETE FROM jdbc_demo.ship WHERE id = ?`
    - DQL (Data Query Language)
        - SELECT
            - SELECT is also part of DML
            - The reason the DQL sublanguage exists, is because there is disagreement within the SQL community whether SELECT should actually be considered part of DML
            - But for our purposes in training, we will also consider SELECT to be part of DML
    - DCL (Data Control Language)
        - Used to control permissions for different users interacting with the database
        - GRANT
        - REVOKE
    - TCL (Transaction Control Language)
        - Used to help us work with SQL transactions
        - COMMIT
        - ROLLBACK
        - SAVEPOINT
        - BEGIN TRANSACTION
- RDBMS systems and popular vendors
    - MariaDB (open source version of MySQL)
    - MySQL
    - PostgreSQL
    - Oracle
    - MS SQL
- SQL Data Types
    - VARCHAR(n)
    - INTEGER
    - NUMERIC
    - BLOB
    - BOOLEAN
    - etc.
- Constraints
    - NOT NULL
    - PRIMARY KEY
    - FOREIGN KEY
    - UNIQUE
    - DEFAULT
    - CHECK
- Composite Keys
    - These are primary keys made up of two or more columns
    - Each column is called a **candidate key**

# Normalization
- 1NF
    - Must have a primary key
    - Data must be atomic (not to be confused with Atomicity from the ACID transaction properties)
        - 1 datum per cell
- 2NF
    - If you don't have a composite key, you are already in 2NF
    - 1NF + no partial dependencies
        - Your columns must describe the entire key, and not a single candidate key
- 3NF
    - 2NF + No transitive dependencies
    - Your columns should describe the key and only the key

- You must have the key (1NF), describe the whole key (2NF), and describe nothing but the key (3NF)

# Relationships
- Known as multiplicity or cardinality relationships
    - One-to-one
        - The foreign key is on either table
        - The foreign key also has a UNIQUE constraint (to prevent duplicate foreign keys, which would make this a one-to-many instead)
    - One-to-many
        - The foreign key is on the many table
    - Many-to-many
        - Requires a junction / join table
            - This third table has foreign key pairs of the other 2 tables

# Queries
- Query clauses
    - SELECT
    - FROM
    - JOIN... ON...
    - WHERE
    - GROUP BY
    - HAVING
    - ORDER BY
- Aliases
    - We can have aliases for things like
        - columns
        - tables
        - subqueries
    - `SELECT p.* FROM person p`
    - `SELECT p.* FROM person p WHERE p.salary > (SELECT avg(salary) FROM person)`
- Joins
    - INNER
    - OUTER
    - LEFT/RIGHT
    - CROSS JOINS (permutations)
    - Conceptual types of joins:
        - SELF: joining a table with itself based on a foreign key that points to a primary key in the same table
            - ex. Employee table with FK manager_id pointing to PK id
        - Equi-join: a join where the condition is based on equality (post.user_id = user.id)
        - Theta-join: a join where the condition is not based on equality (post.user_id > user.id)
- Set Operations
    - UNION (discard duplicate rows)
    - UNION ALL (keeps duplicate rows)
    - INTERSECT (keeps rows that are common between the two result sets)
    - EXCEPT (subtracts rows from one result set by the other that are common)

# Aggregate Functions
- Generally used in combination with GROUP BY
- Used to act upon rows within a group and combine the results into a single value for each group
- MIN
- MAX
- AVG
- COUNT
- SUM
- etc..

# Scalar Functions
- Act individually on each row, and return results for each row independently
- LENGTH
- UPPER
- LOWER
- ABS
- TRIM

# Transactions
- Properties of a transaction (ACID)
    - Atomicity: a transaction either completely succeeds or not at all
    - Consistency: data being modified or inserted into the database need to meet all constraints specified
    - Isolation: transactions should not be interfering with each other
    - Durability: once a transaction is committed, it should be stored in permanent memory (hard drive instead of RAM)
- Read phenomena
    - Dirty reads
    - Non-repeatable reads
    - Phantom reads
- Isolation levels (least strict to most strict)
    - Read uncommitted (does not prevent any read phenomena)
    - Read committed: prevents dirty reads
    - Repeatable read: prevents dirty reads + non-repeatable reads
    - Serializable: prevents dirty reads, non-repeatable reads, and phantom reads

# JDBC (Java Database Connectivity)
JDBC is a built-in API that is included with the JRE that gives us classes and interfaces that provide the ability to interact with a SQL database.

- JDBC classes/interfaces
    - DriverManager (class)
        - Responsible for interfacing with the SQL driver for our database "flavor"
            - A dependency we had to include in our Maven project was the MariaDB driver
            - We then register this driver with the DriverManager via `DriverManager.registerDriver(new Driver())`
        - Also responsible for connecting us with the database
            - This is the class belonging to the JDBC API that returns a Connection object via `DriverManager.getConnection(url, username, password)`
    - Connection (interface)
    - SQLException (class)
        - Represents the checked exception that is associated with various methods that are part of the JDBC API
    - Statement (interface)
        - Obtained from the Connection object using the `createStatement()` method
        - Does not prevent SQL injection (security vulnerability)
    - PreparedStatement (interface)
        - Obtained from the Connection object using the `prepareStatement(sql)` method
        - Prevents SQL injection, because we utilize a pre-defined template for our SQL query when we create the PreparedStatement
            - This prevents arbitrary execution of queries, like in the case of a normal Statement object
    - ResultSet (interface)
        - Allows us to iterate over the rows of a result set obtained through the `executeQuery` method on either a PreparedStatement or Statement
        - `rs.next()`
    - CallableStatement (interface)
        - Allows us to execute stored procedures that exist on our database
            - Stored procedure: essentially a function that has been created and stored as a database object in our schema
- Establishing a connection to the database
    - We made a utility class called ConnectionUtility
        - We defined a static method that returns a `Connection` type called `getConnection()`
            - The purpose of this method is 
                1. To call upon DriverManager to register our MariaDB driver
                2. To obtain the url, username, and password from the system environment variables
                3. To get a Connection object from the DriverManager
                4. Then return the connection object
    - Connection parameters
        - connection string (url)
            - `jdbc:mariadb://<host_name>:<port>/<database name>`
        - username
        - password
    - JDBC autocommit mode
        - Autocommit is on by default
        - We can turn it off by using a Connection object
            - `con.setAutocommit(false)`
        - Why might we do this?
            - If we want to do multiple updates, but treat these updates as a single transaction instead of multiple transactions
    - Data access object (DAO) design pattern
        - We use the dao design pattern in conjunction with the 3-tier architectural style

# 3 Layer Architecture
- Presentation layer (controller layer)
    - Represents the layer that a user of the application interacts with
    - This could be a menu system in the case of a console application
        - Or some sort of GUI
    - More realistically, it might be a layer representing REST API endpoints (like our Javalin application)
- Service layer
    - This contains the business logic of the application
    - This is the intermediary between the presentation layer and the DAO layer
- DAO layer
    - Contains logic related to executing SQL queries, updates, etc.