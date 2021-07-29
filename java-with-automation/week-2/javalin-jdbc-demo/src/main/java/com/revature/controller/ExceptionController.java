package com.revature.controller;

import com.revature.dto.ExceptionMessageDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ShipNotFoundException;

import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;

public class ExceptionController implements Controller {

	private ExceptionHandler<DatabaseException> databaseExceptionHandler = (e, ctx) -> {
		ctx.status(500); // 500 means "Internal Server Error"
		// That status code makes sense for a DatabaseException, because it either means something weird is going on with
		// our DAOs or the Database might not be able to be connected to
		
		// Here we encapsulate the exception message into a DTO that will be sent as JSON back to the user
		ExceptionMessageDTO messageDTO = new ExceptionMessageDTO();
		messageDTO.setMessage(e.getMessage());
		
		ctx.json(messageDTO);
	};
	
	private ExceptionHandler<ShipNotFoundException> shipNotFoundExceptionHandler = (e, ctx) -> {
		ctx.status(404); // 404 is "Not Found"
		
		ExceptionMessageDTO messageDTO = new ExceptionMessageDTO();
		messageDTO.setMessage(e.getMessage());
		
		ctx.json(messageDTO);
	};
	
	private ExceptionHandler<BadParameterException> badParameterExceptionHandler = (e, ctx) -> {
		ctx.status(400);
		
		ExceptionMessageDTO messageDTO = new ExceptionMessageDTO();
		messageDTO.setMessage(e.getMessage());
		
		ctx.json(messageDTO);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.exception(DatabaseException.class, databaseExceptionHandler);
		app.exception(ShipNotFoundException.class, shipNotFoundExceptionHandler);
		app.exception(BadParameterException.class, badParameterExceptionHandler);
	}

}
