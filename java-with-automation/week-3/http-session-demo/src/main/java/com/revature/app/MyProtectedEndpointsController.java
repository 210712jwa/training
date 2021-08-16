package com.revature.app;

import com.revature.controller.Controller;
import com.revature.dto.MessageDTO;
import com.revature.service.AuthorizationService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class MyProtectedEndpointsController implements Controller {

	private AuthorizationService authService;
	
	public MyProtectedEndpointsController() {
		this.authService = new AuthorizationService();
	}
	
	private Handler protectedActionHandler = (ctx) -> {
		authService.guard(ctx); // If they make it past this method, that means they're logged in
		// and can access the subsequent actions we take for this endpoint
		
		// reimbursementService.addReimbursement(...);
		// etc.
		ctx.json(new MessageDTO("You were logged in, so that's why you're seeing this"));
		
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.post("/doSomethingOnlyLoggedInUsersCanDo", protectedActionHandler);
	}

}
