package com.revature.main;

import java.util.Arrays;

import com.revature.helper.ArrayHelper;
import com.revature.helper.DogHelper;
import com.revature.model.Calculator;
//com.revature.model.Dog is what is known as a fully qualified class name
import com.revature.model.Dog;

public class Application {

	public static void main(String[] args) {
		Dog dog1 = new Dog("Fido");
		// ctrl + shift + o for quickly importing different classes
		dog1.feed("ribeye steak");
		dog1.feed();
		
		dog1.bark();
		
		Dog dog2 = new Dog("Daisy");

		dog2.feed("tuna");
		dog2.feed();
		dog2.bark();
		
		System.out.println(DogHelper.getDogInformation(dog1));
		System.out.println(DogHelper.getDogInformation(dog2));
		
		// the toString method here is a helper method
		// located inside of the Arrays utility class
		// This utility class has many useful methods that can operate on our arrays
		// These helper methods are all static methods
		int[] arrayOfInts = { 1, 2, 3, 4, 5, 100, 232, 121, 232 };
		System.out.println(arrayOfInts);
		System.out.println(Arrays.toString(arrayOfInts));
		
		// Use our toString method inside of ArrayHelper, which is basically providing nice formatting
		// for seeing what elements are inside of our array
		System.out.println(ArrayHelper.toString(arrayOfInts));
		
		Calculator c = new Calculator();
		System.out.println(c.add(10, 20)); // will use add(int, int)
		System.out.println(c.add(10.0, 20)); // will use add(double, double, double...)
		
		System.out.println(c.add(10.0, 20, 32.5, 10.2, 1000, 2000, 20.343434));
		
		System.out.println("Number of instances of Dog created: " + Dog.numberOfInstances);
		System.out.println(dog1.numberOfInstances);
		System.out.println(dog2.numberOfInstances);
		
		dog1.numberOfInstances = 100;
		
		// Instances share the same static variable
		// so if I changed the static variable, numberOfInstances on dog1, then if I access the same
		// variable from dog2, it will be the new value
		System.out.println(dog2.numberOfInstances); 
		
		System.out.println(Dog.numberOfInstances);
	}

}
