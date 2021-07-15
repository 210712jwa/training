package com.revature.model;

public class Dog {
	
	// Instance property
	// Belongs to individual Dog objects
	public String name;
	
	// Static property
	// Shared across all object instances AND also belongs to the class itself
	public static int numberOfInstances; // I'm not assigning a value to this field here, so
	// by default it is 0 / 0.0 for numbers, false for booleans, null for reference variables
	
	// Constructor
	// Allows you to populate properties of an object when they are created
	public Dog(String name) {
		this.name = name;
		numberOfInstances++;
	}
	
	// Instance method #1
	public void feed(String treat) {
		System.out.println(name + " is enjoying a " + treat);
	}
	
	// Instance method #2
	public void feed() { // Method overloading between 1st and 2nd method
		System.out.println(name + " is eating normal dog food");
	}
	
	// Instance method #3
	public void bark() {
		System.out.println(name + " is barking");
	}
	
}
