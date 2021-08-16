package com.revature.app;

import com.revature.controller.Controller;
import com.revature.dto.LoginDTO;
import com.revature.dto.MessageDTO;
import com.revature.model.User;
import com.revature.service.LoginService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class LoginController implements Controller {

	private LoginService loginService;
	
	public LoginController() {
		this.loginService = new LoginService();
	}
	
	private Handler loginHandler = (ctx) -> {
		LoginDTO loginDto = ctx.bodyAsClass(LoginDTO.class);
		
		User user = loginService.login(loginDto.getUsername(), loginDto.getPassword());
		
		ctx.sessionAttribute("user", user);
		ctx.json(user);
	};
	
	private Handler currentUserHandler = (ctx) -> {
		User user = (User) ctx.sessionAttribute("user");
		
		if (user != null) {
			ctx.json(user);
		} else {
			ctx.json(new MessageDTO("User is currently not logged in!"));
		}
	};
	
	private Handler logoutHandler = (ctx) -> {
		if (ctx.sessionAttribute("user") == null) {
			ctx.json(new MessageDTO("User is already logged out"));
			ctx.status(400);
		} else {
			ctx.req.getSession().invalidate();
			ctx.json(new MessageDTO("User successfully logged out"));
			ctx.status(200);
		}
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
	
		app.post("/login", loginHandler);
		app.post("/logout", logoutHandler);
		
		app.get("/currentuser", currentUserHandler);
	}

}
