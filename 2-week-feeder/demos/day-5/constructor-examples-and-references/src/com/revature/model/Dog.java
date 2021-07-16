package com.revature.model;

public class Dog {

	// variables shouldBeNamedLikeThis
	// classes ShouldBeNamedLikeThis
	
	public String name;
	public double weight;
	public String breed;
	public int age;
	
	public static int numOfInstances;
	
	// If we don't provide ANY constructor
	// Then the compiler provides a "default no-args constructor" for us to use
	// and it basically looks like this
	// It is "implicit"
	public Dog() {
		super(); // will be implicitly inserted if I don't provide myself (which in this case I am)
		System.out.println("Dog() invoked");
		// super(); // super() is implicitly provided by the compiler on the first line of the 
		// constructor (unless we provide this(...) as the first line)
	}
	
	public Dog(String name) {
		this();
		System.out.println("Dog(String name) invoked");
		this.name = name;
	}
	
	public Dog(String name, double weight) {
		this(name);
		System.out.println("Dog(String name, double weight) invoked");
		this.weight = weight;
	}
	
	public Dog(String name, double weight, String breed) {
		this(name, weight);
		System.out.println("Dog(String name, double weight, String breed) invoked");
		this.breed = breed;
	}
	
	public Dog(String name, double weight, String breed, int age) {
		this(name, weight, breed);
		System.out.println("Dog(String name, double weight, String breed, int age) invoked");
		this.age = age;
	}
	
	// Some things to keep in mind when learning about constructors
	// we have
	// 1. super(...) - super will always go on the first line of any constructor that doesn't have
	// 		this(...) specified
	// 		The purpose of super(...) is to invoke the parent class constructor
	// 2. this(...) - is used for constructor chaining. If we want to make use of code inside of
	// 					other overloaded constructors, we can use this(...) to invoke them.
	//
	// this() and super() must always be the first line (one or the other)
}
