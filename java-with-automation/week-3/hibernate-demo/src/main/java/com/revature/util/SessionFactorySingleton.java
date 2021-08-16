package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingleton {

	// This is a singleton SessionFactory, which means only a single instance of SessionFactory will exist
	// during the lifetime of our application running
	private static SessionFactory sessionFactory;
	
	public synchronized static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			config.setProperty("hibernate.connection.username", System.getenv("db_username"));
			config.setProperty("hibernate.connection.password", System.getenv("db_password"));
			config.configure("hibernate.cfg.xml");
			
			sessionFactory = config.buildSessionFactory();
		}
		
		return sessionFactory;
	}
}
