# JDBC
JDBC stands for Java Database Connectivity. It is a relatively low-level API used to write Java code that interacts with relational databases via SQL.

The JDBC API has classes and interfaces that are located in the `java.sql` and `javax.sql` packages. There are several key classes and interfaces that are commonly encountered when writing JDBC code.

- `DriverManager` class: used to register a database driver. It is also used to obtain a Connection object that essentially represents our application's connection to the database
- `Connection` interface: represents the actual connection with the database
    - `DataSource` interface: used to retrieve connections as an alternative to `DriverManager` (not really important at the moment)
- `SQLException` class: this is a checked exception that acts as the general exception for JDBC operations
- `Statement` interface: used in order to execute SQL statements
    - This interface will not avoid the security vulnerability of SQL injection
        - The reason for this, is that if you want to execute a SQL statement, you will simply pass in a raw SQL string to a method such as execute(String sql). This means that if your SQL statement is somehow coupled with user input, a malicious user could just input arbitrary SQL queries and destroy your database or obtain sensitive information.
- `PreparedStatement` interface: represents a pre-compiled SQL statement. It basically serves as a template that we can pass parameters into. Therefore it's not possible to write arbitrary SQL and have that executed at runtime.
    - Prevents SQL injection through this predefined, precompiled template
- `CallableStatement` interface: used to execute stored procedures (user defined functions)
- `ResultSet` interface: represents a "pointer" to a SQL query's results

# Creating a Database Connection
To obtain a connection to the database, we need to have credentials to our database. The location of the database is known as a **connection string**, which includes information about what SQL driver we're going to be using, the ip address/domain, the port, and what the database name is.

Since we're utilizing MariaDB, the beginning of our connection string will specifically be

`jdbc:mariadb:`

The final form of the connection string, including everything, will be

`jdbc:mariadb://<HOST_NAME>:<PORT>/<DB_NAME>`

So for example, my own connection to my RDS instance will be

`jdbc:mariadb://database-3.clwebyd8kmnl.us-east-2.rds.amazonaws.com:3306/training`

In summary, what we need is
- A connection string
- A username
- A password

Steps to utilize JDBC:
1. Register the JDBC driver (DriverManager)
2. Open a Connection (DriverManager)
3. Execute JDBC statements using either
    - A Statement
    - A PreparedStatement
    - A CallableStatement
4. Retrieve the results that are returned in a `ResultSet` object (if applicable, such as if your SQL statement was a SELECT statement)