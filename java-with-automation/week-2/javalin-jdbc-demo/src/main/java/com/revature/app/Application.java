package com.revature.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import com.revature.controller.PirateController;
import com.revature.controller.ShipController;
import com.revature.controller.TestController;

import io.javalin.Javalin;

public class Application {

	private static Javalin app;
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		app = Javalin.create();
		
		mapControllers(new ShipController(), new ExceptionController(), new PirateController()); // variable arguments (var-args)
		
		app.before((ctx) -> {
			logger.info(ctx.method() + " request received to the " + ctx.path() + " endpoint");
			// GET request received to the /ship endpoint
		});
		
		app.start(6000); // start up our Javalin server on port 7000
	}
	
	public static void mapControllers(Controller... controllers) {
		for (Controller c : controllers) {
			c.mapEndpoints(app); // Abstraction and polymorphism in action
			// We are implementing the mapEndpoints abstract method from the Controller interface
			// Depending on the object that the Controller c reference varible is pointing to for each iteration
			// We will use the appropriate mapEndpoints implementation
		}
	}

}
