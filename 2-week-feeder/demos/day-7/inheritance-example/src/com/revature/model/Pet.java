package com.revature.model;

public class Pet {

	public String name;
	
	// Since we defined this constructor, we no longer are provided with a default no-args constructor
	public Pet(String name) {
		this.name = name;
	}
	
	// So this default no args constructor is no longer available
//	public Pet() {
//		super();
//	}
	
	public void makeNoise() {
		System.out.println("**GENERIC Animal noises**");
	}

}
