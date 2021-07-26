package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Application {

	private static Javalin app;
	
	public static void main(String[] args) {
		
		Person p = new Person("John Doe", 25);
		
		app = Javalin.create();

		// Send HTML in the form of <h1>Hello World!</h1> whenever an HTTP client sends a GET request to /hello
		app.get("/hello", (Context ctx) -> {
			ctx.html("<h1>Hello World!</h1>");
		});
		
		app.get("/person", (Context ctx) -> {
			ctx.json(p); // In order to use the .json method, we need the Jackson Databind dependency
			// What this dependency does is it converts Java objects into JSON
			// OR converts JSON into Java objects
		});
		
		app.start(3000);
	}

}
