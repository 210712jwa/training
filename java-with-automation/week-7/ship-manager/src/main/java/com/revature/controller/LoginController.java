package com.revature.controller;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.LoginDTO;
import com.revature.dto.MessageDto;
import com.revature.model.User;
import com.revature.service.AuthenticationService;

@RestController
@CrossOrigin(origins = { "http://localhost:4201", "http://ec2-18-225-36-88.us-east-2.compute.amazonaws.com:8081" }, allowCredentials = "true")
public class LoginController {

	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping(path = "/login")
	public ResponseEntity<Object> login(@RequestBody LoginDTO loginDto) {
		
		try {
			User user = this.authService.login(loginDto.getUsername(), loginDto.getPassword());
			
			// true as a parameter means create a new session
			// false as a parameter means do not create a new session if one does not already exist. Return null instead
			HttpSession session = request.getSession(true);
			
			if (session.getAttribute("currentUser") != null) {
				return ResponseEntity.status(400).body(new MessageDto("You are already logged in!"));
			}
			
			session.setAttribute("currentUser", user);

			
			return ResponseEntity.status(200).body(user);
		} catch (LoginException e) {
			return ResponseEntity.status(400).body(new MessageDto(e.getMessage()));
		}
		
	}
	
	@GetMapping(path = "/currentuser")
	public ResponseEntity<Object> getCurrentUser() {
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("currentUser") == null) {
			return ResponseEntity.status(400).body(new MessageDto("You are not logged in!"));
		}
		
		User user = (User) session.getAttribute("currentUser");
		return ResponseEntity.status(200).body(user);
		
	}
	
	@PostMapping(path = "/logout")
	public ResponseEntity<Object> logout() {
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("currentUser") == null) {
			return ResponseEntity.status(400).body(new MessageDto("You are not logged in!"));
		}
		
		session.invalidate(); // invalidate the session
		return ResponseEntity.status(200).body(new MessageDto("Successfully logged out"));
	}

}
