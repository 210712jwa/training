package com.revature;

import com.revature.model.Cat;
import com.revature.model.Dog;
import com.revature.model.Pet;

public class Application {

	public static void main(String[] args) {
		Pet p1 = new Dog("Fido");
		System.out.println(p1.name);
		
		Pet p2 = new Cat("Whiskers");
		System.out.println(p2.name);
		
//		Dog dog2 = new Dog();
//		System.out.println(dog2.name);
		
		p1.makeNoise();
		p2.makeNoise();
		
		p1 = p2; // set p1 to point to the same object as p2 (the Cat object with a name of "Whiskers")
		p1.makeNoise();
		
		p1 = new Dog();
		Dog d1 = (Dog) p1; // We are downcasting from a parent type to a child type
		
		// This is unsafe, because you are not 100% guaranteed that whatever the parent variable is pointing to is actually
		// the child type that you want to cast to
		// For example, p1 could be pointing to either a Cat OR a Dog object
		// So if you try to cast to Dog, when p1 is pointing to a Cat, that is not possible
		// Because a Cat is not a Dog
		// ClassCastException (this is the exception that occurs when you try to cast according to the above situation)
		d1.playFetch();
		
		Pet a1 = d1; // upcasting from Dog type to Pet type
	}

}
