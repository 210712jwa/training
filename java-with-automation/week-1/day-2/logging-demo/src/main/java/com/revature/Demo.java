package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

	private static final Logger logger = LoggerFactory.getLogger(Demo.class);
	
	public static void main(String[] args) {
		
		logger.trace("Trace message");
		logger.debug("Debug message");
		logger.info("Hello there from {} {} {}", Demo.class.getSimpleName(), 10, "something else");
		logger.warn("Warn message");
		logger.error("Error message");
		
	}

}
