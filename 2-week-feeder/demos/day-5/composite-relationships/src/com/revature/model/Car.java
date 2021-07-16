package com.revature.model;

// What we are making here is a POJO (Plain old Java Object)
public class Car {

	public String make;
	public String model;
	public Engine engine; // composition, we have a class w/ properties that are other objects
	// themselves
	// so a car HAS AN engine
	
	public Car(String make, String model, Engine engine) {
		this.make = make;
		this.model = model;
		this.engine = engine;
	}

}
