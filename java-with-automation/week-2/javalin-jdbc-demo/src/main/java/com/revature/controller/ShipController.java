package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dto.AddOrEditShipDTO;
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
		
//		if (ctx.queryParam("ageLessThan")!= null && ctx.queryParam("ageMoreThan") != null) {
//			shipService.getShipsWithAgeBetween(ctx.queryParam("ageLessThan"), ctx.queryParam("ageMoreThan"));
//		} else if (ctx.queryParam("ageLessThan") != null) {
//			shipService.getShipsWithAgeBetween(ctx.queryParam("ageLessThan"), "-1");
//		} else if (ctx.queryParam("ageMoreThan") != null) {
//			shipService.getShipsWithAgeBetween("-1", ctx.queryParam("ageMoreThan"));
//		}
		
		List<Ship> ships = shipService.getAllShips();
		
		ctx.status(200); // 200 means OK
		ctx.json(ships);
	};
	
	private Handler getShipById = (ctx) -> {
		String shipid = ctx.pathParam("shipid");
		
		Ship ship = shipService.getShipById(shipid);
		ctx.json(ship);
	};
	
	private Handler addShip = (ctx) -> {
		AddOrEditShipDTO shipToAdd = ctx.bodyAsClass(AddOrEditShipDTO.class);
		
		Ship addedShip = shipService.addShip(shipToAdd);
		ctx.json(addedShip);
	};
	
	private Handler editShip = (ctx) -> {
		AddOrEditShipDTO shipToEdit = ctx.bodyAsClass(AddOrEditShipDTO.class);
		
		String shipId = ctx.pathParam("shipid");
		Ship editedShip = shipService.editShip(shipId, shipToEdit);
		
		ctx.json(editedShip);
	};
	
	private Handler deleteShip = (ctx) -> {
		String shipId = ctx.pathParam("shipid");
		
		shipService.deleteShip(shipId);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/ship", getAllShips);
		app.get("/ship/:shipid", getShipById);
		app.post("/ship", addShip);
		app.put("/ship/:shipid", editShip);
		app.delete("/ship/:shipid", deleteShip);
	}

}
