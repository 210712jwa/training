package com.revature.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ORMConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		
		dataSource.setUrl(System.getenv("db_url"));
		dataSource.setUsername(System.getenv("db_username"));
		dataSource.setPassword(System.getenv("db_password"));
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource()); // setter injection
		sessionFactory.setPackagesToScan("com.revature.model");
		
		// Create the properties object
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "validate"); // create and validate
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB103Dialect");
		
		// Configure hibernate properties
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		return sessionFactory;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}
	
}
