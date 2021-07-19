package com.revature.demo;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		
		/*
		 * There is a wrapper class for every primitive in Java
		 * It is a way to treat primitives as objects
		 * 
		 * So,
		 * For boolean it is Boolean
		 * For char it is Character
		 * For double it is Double
		 * For float it is Float
		 * For int it is Integer
		 * For long it is Long
		 * For short it is Short
		 * For byte it is Byte
		 */
		
		// We have this idea of autoboxing and unboxing
		// Autoboxing: the automatic creation of a wrapper object based on a primitive value
		// Unboxing: the automatic extraction of a primitive value from a wrapper object
		
		// autoboxing example
		Integer i1 = 100; // 100 is an "int literal". So this 100 is actually an int primitive itself
		// The above line creates an Integer object based on the value 100
		
		Integer i2 = new Integer(100); // This is really what is happening behind the scenes
		
		// unboxing example
		int int1 = i2; // We are taking the value from the Integer object i2 is pointing to, then we are setting
		// int1 equal to that value
		
		int int2 = i2.intValue(); // This is really what is happening behind the scenes
		
		// an example of autoboxing and unboxing occurring in tandem
		Integer i3 = 5;
		Integer result = i3 + 50; // i3 gets unboxed (we extract the value of 5 from i3). 5 + 50 yields 55
		// 55 then gets autoboxed into an Integer wrapper object
		
		Integer result2 = new Integer(i3.intValue() + 50); // This is really what is happening behind the scenes
		
		System.out.println(i1 + i3); // i1 and i3 get unboxed into primitives, which are then added together
		
		// Each wrapper class will also have convenience properties and methods
		// These are static members of the wrapper class
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int a = Integer.parseInt("10");
		Integer b = Integer.valueOf("10"); // this does the same thing as parseInt, but it returns 
		// an Integer wrapper object
		
		Integer b1 = new Integer(10);
		Integer b2 = new Integer(10);
		System.out.println("b1 == b2: " + (b1 == b2));
		System.out.println("b1.equals(b2): " + (b1.equals(b2)));
		
		// Why do we even really need to use wrapper classes?
		// One of the most common reasons is to be able to store primitives inside Collections
		// Collections are a "collection" of objects
		// One of the most common is an ArrayList
		ArrayList<Integer> al = new ArrayList<>();
		al.add(10); // 10 gets autoboxed into an Integer object w/ value 10, and then stored into this ArrayList
		al.add(12);
		al.add(new Integer(-100));
		
		// If I tried to specify the type that the ArrayList can have as "int", it will not work
//		ArrayList<int> al2 = new ArrayList<>(); // NOT ALLOWED!
		
		// the <> is known as a "generic", which is a parameterized type
		// So in the above examples, <Integer> is just being specified to notate that the ArrayList should store
		// only Integer objects
	}

}
