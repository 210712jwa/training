package com.revature.controller;

import java.util.List;

import com.revature.model.Ship;
import com.revature.service.ShipService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ShipController implements Controller {

	private ShipService shipService;
	
	public ShipController() {
		this.shipService = new ShipService();
	}
	
	private Handler getAllShips = (ctx) -> {
		List<Ship> ships = shipService.getAllShips();
		
		ctx.status(200); // 200 means OK
		ctx.json(ships);
	};
	
	private Handler getShipById = (ctx) -> {
		String shipid = ctx.pathParam("shipid");
		
		Ship ship = shipService.getShipById(shipid);
		ctx.json(ship);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/ship", getAllShips);
		app.get("/ship/:shipid", getShipById);
	}

}
