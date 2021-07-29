package com.revature.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import com.revature.controller.ShipController;
import com.revature.controller.TestController;

import io.javalin.Javalin;

public class Application {

	private static Javalin app;
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		app = Javalin.create();
		
		mapControllers(new TestController(), new ShipController(), new ExceptionController());
		
		app.start(7000); // start up our Javalin server on port 7000
	}
	
	public static void mapControllers(Controller... controllers) {
		for (Controller c : controllers) {
			c.mapEndpoints(Application.app);
		}
	}

}
