package com.revature;

public class Application {

	public static void main(String[] args) {
		
		// Anonymous class that is implementing this interface and then constructing an object out of it
		FunctionalInterfaceExample fie = new FunctionalInterfaceExample() {
			
			@Override
			public boolean test(String s) {
				return s.length() > 5;
			}
			
		};
		
		System.out.println(testString("dfd", fie));
		
		// Lambda expression
		FunctionalInterfaceExample lambda1 = (String s) -> s.length() > 1; // What we have here is equivalent to what we have above
		
		System.out.println(testString("asdf", lambda1));
		
		// We can even just pass in a lambda expression as an argument directly
		System.out.println(testString("12345", (String s) -> {
			System.out.println("We can have a multi-line lambda expression");
			return s.length() == 5;
		}));
		
		// Using functional interfaces allows us to work with lambda expressions to make it look like we're passing functions
		// around like variables (we're not actually, but it's almost like we are)
		// This is a way for Java to be able to replicate "functional programming" in other languages like JavaScript (where functions
		// are actually treated like 'first-class citizen' that are treated on the same level as variables)
	}
	
	public static boolean testString(String s, FunctionalInterfaceExample fie) {
		return fie.test(s);
	}

}
