package com.revature.controller;

import java.util.List;

import com.revature.model.Pirate;
import com.revature.service.PirateService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class PirateController implements Controller {

	private PirateService pirateService;
	
	public PirateController() {
		this.pirateService = new PirateService();
	}
	
	private Handler getPirateFromShip = (ctx) -> {
		String shipId = ctx.pathParam("shipid");
		
		List<Pirate> piratesFromShip = pirateService.getAllPiratesFromShip(shipId);
		
		ctx.json(piratesFromShip);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/ship/:shipid/pirate", getPirateFromShip);
	}

}
