package com.revature.model;

public class Dog extends Pet {

	public Dog(String name) {
		super(name);
	}
	
	// WE cannot override a final method
//	@Override
//	public String getName() {
//		return "....";
//	}
	
}
