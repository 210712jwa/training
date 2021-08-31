package com.revature.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.ShipService;

public class FakeShipController implements ShipController {

	private ShipService shipService;
	
	public FakeShipController() {
		System.out.println("FakeShipController: Constructor Invoked");
	}

	// Setter injection
	
	// setShipService -> drop the "set" -> ShipService -> Lowercase the first letter -> shipService
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
