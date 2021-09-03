package com.revature.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


// @Configuration
// @EnableAutoConfiguration // This is where all the magic happens with Spring. There are dependencies that we just need to add to our Spring Boot application
// And Spring Boot will be "smart" enough to automatically configure those dependencies
// "Convention over configuration" <- What Spring boot is all about
// Spring boot = an opinionated way of building Spring applications
// @ComponentScan <- without any parameter, will scan the package that this configuration class is in, and also any subpackages (i.e. com.revature.springbootdemo.*)
@SpringBootApplication // Same as @Configuration, @EnableAutoConfiguration, and @ComponentScan
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@Bean
	public Object someBean() {
		return new Object();
	}

}
