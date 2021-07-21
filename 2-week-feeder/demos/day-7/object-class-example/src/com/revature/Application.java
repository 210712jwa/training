package com.revature;

import com.revature.model.Person;

public class Application {

	public static void main(String[] args) {
		Person person1 = new Person("John", 40, "111-111-1111");
				
		System.out.println(person1); // println(Object o) behind the scenes will basically invoke the toString() method
		// this toString() method returns a String representation of that object
		// the Object class is what defines this toString() method
		
		Person person2 = new Person("John", 40, "111-111-1111");
		
		System.out.println("person1 == person2: " + (person1 == person2));
		System.out.println("person1.equals(person2): " + (person1.equals(person2)));
		
		// second requirement of hashCode
		// if .equals is true for both objects, both objects' hashCodes must be the same
		System.out.println("person1 hashcode: " + person1.hashCode());
		System.out.println("person2 hashcode: " + person2.hashCode());
		
		// But it is not required that if .equals is false for two objects, that the hashcodes are different
		// No specific example for this last one, but think of a hashcode as a result for some hash function
		// What is a hash function?
		// It is where we take some input -> output, but you can't go in the reverse
		
		// f(x) = x + 2; <- NOT a hash function
		// Because if we know that f(x) = 12 -> we know that x was 10
		// this function, you can go from the output and know what the input was by just working backwards
		
		// f(x) = x mod 2 <- IS a hash function
		// if f(x) = 0, we don't know what x was. It could be ANY even number
		// if f(x) = 1, we don't know what x was. It could be ANY odd number
		// So a particular output for a hash function has an infinite number of inputs
		
		// So for the guideline above about .equals being false but having the same hashcode,
		// an example would be 12 and 10
		// They are not equal, but they have the same hashCode for hash function f(x) = x mod 2
		
		person1 = null; // the object that person1 was pointing to will no longer have any reference
		// this allows the garbage collector to kick in and garbage collect that Person object
		
		// We can suggest to the garbage collector that it should probably run
		// We can't force the garbage collector to run, however. It is just a suggestion
		System.gc();
		
	}

}
