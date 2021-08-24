package com.revature.controller;

import javax.servlet.http.HttpSession;

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
		
		User user = loginService.login(loginDto);
		
		HttpSession httpSession = ctx.req.getSession();
		httpSession.setAttribute("currentUser", user);
		
		ctx.json(user);
		ctx.status(200);
	};
	
	private Handler currentUserHandler = (ctx) -> {
		HttpSession httpSession = ctx.req.getSession();
		if (httpSession.getAttribute("currentUser") == null) {
			ctx.json(new MessageDTO("User is currently not logged in"));
			ctx.status(401);
		} else {
			User user = (User) httpSession.getAttribute("currentUser");
			ctx.json(user);
			ctx.status(200);
		}
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.post("/login", loginHandler);
		app.get("currentuser", currentUserHandler);
	}

}
