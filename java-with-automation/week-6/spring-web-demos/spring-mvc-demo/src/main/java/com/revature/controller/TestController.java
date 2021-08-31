package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.LoginDTO;

@RestController // I changed the annotation from @Controller to @RestController
// So I do not need to put @ResponseBody on my methods anymore
// @ResponseBody's purpose is to specify that the return type should be serialized into, for example, JSON and placed into the 
// body of our HTTP response
public class TestController {

	@GetMapping(path = "/hello", produces = "application/json")
	public String hello() {
		return "Hello world!";
	}
	
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public LoginDTO login(@RequestBody LoginDTO loginDto) {
		return loginDto;
	}
	
}
