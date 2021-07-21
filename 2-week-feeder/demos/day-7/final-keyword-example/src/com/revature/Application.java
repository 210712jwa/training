package com.revature;

import java.util.Arrays;

// The Application class is probably not a class I would want anybody to extend
// Because the sole purpose of this class is just to contain our main method
// So, to prevent any other class from being able to extend this class, I can make it final
public final class Application {

	public static void main(String[] args) {
		
		/*
		 * Summary of the below code:
		 * 
		 * For final primitives, you can't change the value
		 * For final reference variables, you can't change the object the variable is pointing to
		 * (but you can still change the internal properties of that object)
		 */
		
		final int a = 10; // using final with a variable means we can't change the variable's value later
		// a = 20; // Not allowed
		
		final int[] ints = new int[10];
		// We can't change what int array object the variable ints is pointing to
		// But we can still modify internally the properties of that object
		// So yes, we can change the elements of that int array
		ints[0] = 10;
		
		System.out.println(Arrays.toString(ints)); // do not confuse this toString method with the one inside of the Object class
		// Just looking at Arrays.toString tells me it is a static method. The toString method in the Object class is an instance method
		// that gets inherited by any classes that we create. Therefore this toString method is entirely different from the one we learned
		// about for the Object class
		
		// ints = new int[20]; // I cannot have the ints variable point to another object. Once I have decided on what it should point to,
		// it will always point to that object
	}

}
