package com.revature.model;

public interface Drawable {
	
	double PI = Math.PI; // This is implicitly a public static final variable.
	// final means I cannot change the value of this variable, after it has already been set.
	// same as typing out
	// public static final double PI = Math.PI;
	
	// Interfaces are designed to be a "contract" in which various abstract methods are defined that you must implement in 
	// concrete classes
	
	// Classes can only extend ONE class
	// But Classes can implement MANY interfaces
	// This is one of the reasons to use a interface v. an abstract class
	
	public void draw(); // This is an abstract method. Within the context of interfaces, we don't need to provide the "abstract" keyword
	// but this is the same as writing
	// public abstract void draw(); The 'abstract' keyword is implicitly provided
	
	// Normally when we think of interfaces, we might say 'interfaces can only contain abstract methods'
	// This is not true as of Java 8
	// Java 8 introduced this idea of default methods in interfaces
	// This allows us to actually provide a default implementation inside of our interface
	// The reason for this addition is to prevent old code from breaking whenever we added a new method
	public default void erase() { // the default keyword allows us to create a concrete method inside of our interface
		// This is usually done to prevent breaking old code.
		System.out.println("Erasing...");
	}
	
	public static void staticMethod() {
		System.out.println("This is an example of a static method inside an interface");
	}
}
