package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.ShipService;

//@Component specifies to Spring that it should treat this as a Spring bean class
//This means that Spring will know to automatically instantiate and configure this class (and store it inside of the Spring IoC container)
//This replaces the <bean> tag inside of the xml configuration
@Component
public class FakeShipController implements ShipController {

	private ShipService shipService;
	
	public FakeShipController() {
		System.out.println("FakeShipController: Constructor Invoked");
	}

	// Autowired can be utilized for 3 different types of injection:
	// 1. Field Injection (where we place the autowired annotation directly on the variable itself (which will then use the 
	// Java Reflection API to set the value of that variable without using constructors or setters)
	// 2. Constructor Injection (where we place the autowired annotation directly on the constructor)
	// 3. Setter Injection (where we place the autowired annotation directly on the setter method)
	@Autowired
	public void setShipService(ShipService shipService) {
		System.out.println("FakeShipController: Setter injection invoked");
		this.shipService = shipService;
	}

	@Override
	public String getAllShips() throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
			
		String json = om.writeValueAsString(shipService.getAllShips());
		
		return json;
	}
	
}
