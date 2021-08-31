package com.revature.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ShipController {

	public abstract String getAllShips() throws JsonProcessingException;
	
}
