package com.revature.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // I changed the annotation from @Controller to @RestController
// So I do not need to put @ResponseBody on my methods anymore
// @ResponseBody's purpose is to specify that the return type should be serialized into, for example, JSON and placed into the 
// body of our HTTP response
@CrossOrigin(origins = "http://localhost:4201", allowCredentials = "true")
public class TestController {
	
	@GetMapping(path = "/hello", produces = "application/json")
	public String hello() {
		return "Hello world!";
	}
	
}
