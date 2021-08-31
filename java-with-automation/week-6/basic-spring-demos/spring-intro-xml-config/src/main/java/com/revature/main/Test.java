package com.revature.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.controller.ShipController;
import com.revature.dao.ShipDao;
import com.revature.model.Ship;
import com.revature.service.ShipService;

public class Test {

	public static void main(String[] args) throws JsonProcessingException {
		
		// ApplicationContext is an interface that extends upon another interface called BeanFactory
		// ApplicationContext and BeanFactory are both used to represent an object that is the IoC container
		// Both of these establish the principle of inversion of control by instantiating beans and storing them
		// inside of the container
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Here we start up the IoC container, which will look at the configuration file and instantiate any bean definitions
		// that we specified
		
		// We can obtain the bean that was instantiated and is currently being managed by the IoC container by calling the .getBean method
		ShipDao myFakeShipDao = (ShipDao) context.getBean("myFakeShipDao");
		List<Ship> ships = myFakeShipDao.getAllShips();
		System.out.println(ships);
		
		// This one only works if you only have a single implementing class for this particular interface, ShipDao
		ShipDao myFakeShipDao2 = (ShipDao) context.getBean(ShipDao.class);
		System.out.println(myFakeShipDao2.getAllShips());
		
		// This prints out true, because objects that are instantiated and managed by Spring are "singletons"
		// A Singleton is a type that has only a single instance
		// Therefore, we are ensured that whatever object we receive will be the exact same object in memory
		// therefore == will yield true because the reference variables will be pointing to the same object
		System.out.println("myFakeShipDao == myFakeShipDao2: " + (myFakeShipDao == myFakeShipDao2));
		
		// Request the ShipService object from the container
		// This will give us the only implementation of the ShipService interface, which is ShipServiceImpl
		ShipService myShipService = (ShipService) context.getBean(ShipService.class);
		System.out.println("myShipService.getAllShips(): " + myShipService.getAllShips());
		
		// Request the ShipController
		ShipController myFakeShipController = (ShipController) context.getBean("myFakeShipController");
		System.out.println(myFakeShipController.getAllShips());

	}

}
