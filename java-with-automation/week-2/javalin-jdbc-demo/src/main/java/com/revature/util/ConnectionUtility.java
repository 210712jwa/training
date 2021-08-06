package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Driver;

// This class will contain a static method that interacts w/ the JDBC API to return a Connection object
public class ConnectionUtility {

	// This is a utility class that just contains a single static method
	// We don't need to instantiate this class
	// Therefore, we make a private constructor to restrict instantiation
	private ConnectionUtility() {	
	}
	
	// Define a static method that will interact w/ the DriverManager class from the JDBC API to return a Connection object
	public static Connection getConnection() throws SQLException {
		
		// The first step is to register the MariaDB driver (which was a dependency we obtained through Mvnrepository)
		// The purpose of driver is to allow JDBC to be able to communicate w/ the database
		DriverManager.registerDriver(new Driver());
		
		/*
		 * Hardcoding credentials is bad
		 * 
		 * We should use environment variables instead
		 */
		
		/*
		 * Using environment variables
		 * 
		 * We can use System.getenv(<environment variable name>)
		 */
		String url = System.getenv("db_url");
		String username = System.getenv("db_username");
		String password = System.getenv("db_password");
		
		// Here we actually obtain a connection object using the DriverManager getConnection() method
		Connection connection = DriverManager.getConnection(url, username, password);
		// DriverManager.getConnection is where all of the magic happens for connecting to the MariaDB database
		
		return connection;
	}
	
}
