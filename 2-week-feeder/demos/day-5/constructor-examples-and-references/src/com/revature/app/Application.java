package com.revature.app;

import com.revature.model.Dog;

public class Application {

	public static void main(String[] args) {
		Dog dog1;
		dog1 = new Dog("Fido", 20.3, "Dachshund", 10);
		System.out.println(dog1.name);
		System.out.println(dog1.weight);
		System.out.println(dog1.breed);
		System.out.println(dog1.age);
		
		// What type of variable is dog1?
		// 1. primitive variables
		// 2. reference variables
		// dog1 is a reference variable of the type Dog
		// A reference variable works differently than a primitive variable
		// Reference variables "point" to the location of objects
		// "dog1 references (points) to a Dog object that was constructed"
		int x;
		x = 5000;
		
		// pass-by-value
		// Java is pass-by-value, meaning we pass the values contained inside of our variables
		// whenever we pass in arguments to a method
		// We don't actually pass the reference to that variable itself
		tryToChangeIntValue(x);
		System.out.println(x); // 5000
		
		tryToChangeNameOfDog(dog1, "Daisy");
		System.out.println(dog1.name); // Daisy
	}
	
	public static void tryToChangeIntValue(int y) {
		y = 99999999;
	}
	
	public static void tryToChangeNameOfDog(Dog d, String name) {
		d.name = name;
	}

}
