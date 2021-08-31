package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.controller.ShipController;

public class Test {

	public static void main(String[] args) throws JsonProcessingException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ShipController shipController = (ShipController) context.getBean(ShipController.class);
		
		String json = shipController.getAllShips();
		
		System.out.println(json);
		
	}

}
