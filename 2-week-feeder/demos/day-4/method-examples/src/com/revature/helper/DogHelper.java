package com.revature.helper;

import com.revature.model.Dog;

// DogHelper is a class that will contain useful utility methods for
// getting information about Dogs
public class DogHelper {

	// Helper methods are typically static and belong inside of what are called utility classes
	public static String getDogInformation(Dog dog) {
		String info = "Name of Dog: " + dog.name;
		
		return info;
	}
	
}
