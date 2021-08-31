package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.controller.FakeShipController;
import com.revature.controller.ShipController;
import com.revature.dao.FakeShipDao;
import com.revature.dao.ShipDao;
import com.revature.service.ShipService;
import com.revature.service.ShipServiceImpl;

// This configuration class is a spring bean itself
// It is a special configuration spring bean
// We can create it by annotation this class with @Configuration
@Configuration
public class BeanConfig {
	
	// The following methods annotated with @Bean are the bean definitions themselves
	// The name of the methods are the names of the beans
	@Bean
	public ShipDao myFakeShipDao() {
		return new FakeShipDao();
	}
	
	@Bean // @Bean carries a special meaning
	// It will "intercept" this method call to determine if that bean already exists in the container or not
	// If it already exists, it will simply return the existing bean instead of running the code that exists inside of this method
	// If it does not exist yet, that is when it will actually run the code inside the method, constructing the new object, then
	// storing it inside the container
	public ShipService myShipService() {
		return new ShipServiceImpl(myFakeShipDao()); // constructor injection
	}
	
	@Bean
	public ShipController myFakeShipController() {
		ShipController controller = new FakeShipController();
		((FakeShipController) controller).setShipService(myShipService()); // setter injection
		
		return controller;
	}
}
