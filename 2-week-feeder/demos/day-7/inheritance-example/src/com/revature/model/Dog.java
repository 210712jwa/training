package com.revature.model;

// The Dog class is a child class of the Animal class
// child classes are also known as subclasses
// parent classes are also known as superclasses
public class Dog extends Pet {
	
	// The child class constructor ALWAYS needs to invoke the parent class constructor
	// There is no way around that
	// If you don't provide your own super invocation, it will try to automatically insert 'super()'
	// So if the parent class does not have a no-args constructor, it will not work
	// And indeed in our case, the Pet class has no no-args constructor. It only has a constructor that takes a String name
	// and so we need to provide super("some string here");
	public Dog() {
		super("No name");
	}
	
	public Dog(String name) {
		super(name);
	}
	
	// Method Overriding
	// The rules of method overriding are that
	// 1. Same method name as the method in the parent class
	// 2. Covariant return type (must have the same return type as in the parent class, or a child of that return type)
	// 3. Same exact parameters (cannot be different)
	public void makeNoise() {
		System.out.println("Woof!");
	}
	
	public void playFetch() {
		System.out.println(super.name + " is playing fetch!");
	}
	
}
