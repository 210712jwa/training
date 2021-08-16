package com.revature.app;

import com.revature.controller.Controller;
import com.revature.dto.MessageDTO;
import com.revature.exception.InvalidLoginException;
import com.revature.exception.NotAuthorizedException;

import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;

public class ExceptionController implements Controller {

	private ExceptionHandler<InvalidLoginException> invalidLoginExceptionHandler = (e, ctx) -> {
		
		ctx.status(400);
		
		ctx.json(new MessageDTO(e.getMessage()));
	};
	
	private ExceptionHandler<NotAuthorizedException> notAuthorizedExceptionHandler = (e, ctx) -> {
		ctx.status(401); // Not Authorized
		
		ctx.json(new MessageDTO(e.getMessage()));
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.exception(InvalidLoginException.class, invalidLoginExceptionHandler);
		app.exception(NotAuthorizedException.class, notAuthorizedExceptionHandler);
	}

}
