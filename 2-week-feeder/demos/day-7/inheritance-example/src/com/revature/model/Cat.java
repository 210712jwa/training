package com.revature.model;

public class Cat extends Pet {

	public Cat() {
		super("No name");
	}
	
	public Cat(String name) {
		super(name);
	}
	
	public void makeNoise() {
		System.out.println("Meow!");
	}
}
