package com.revature;

import java.util.Scanner;

import com.revature.exception.DenominatorIsZeroException;
import com.revature.exception.SomeException;

public class Application {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		try {
			method2();
			
			double result = method1();
			
			System.out.println("Result of divison: " + result);
			
		} catch (DenominatorIsZeroException e) { // Handling our custom checked exception 
			
			System.out.println(e.getMessage());
			
		} catch (NumberFormatException e) { // Handling a built in unchecked exception that could be propagated from method1(), which calls Integer.parseInt()
		
			System.out.println("User input an invalid integer for either the numerator or denominator");
		
		} catch (RuntimeException | SomeException e) { // You can put multiple exceptions into the same catch block
			
			System.out.println("Something else happened that we didn't really account for");
			
		} finally {
			System.out.println("This will always execute no matter what! (except some special cases)");
		}
		// Rule for catch blocks: If you have multiple catch blocks for different exceptions, the more specific exceptions
		// must come before the less specific exceptions
		// For example, NumberFormatException IS-A RuntimeException IS-A Exception
		// So NumberFormatException should come before RuntimeException, which should then come before Exception
		
		
		System.out.println("We have reached the end of the program");

	}
	
	public static double method1() throws DenominatorIsZeroException { // the throws keyword is basically declaring that this method
		// has the potential to throw a checked exception by the name of DenominatorIsZeroException
		// Any method, such as the main method, for example, that calls method1(), will either have to use "throws" once again
		// or have a try-catch block for that exception.
		
		System.out.println("Enter an integer numerator: ");
		int numerator = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter an integer denominator: ");
		int denominator = Integer.parseInt(sc.nextLine());
		
		if (denominator == 0) {
			DenominatorIsZeroException e = new DenominatorIsZeroException("User entered a 0 for the denominator"); // exceptions work just like when we create normal objects
			
			// The difference is once you create this exception object, you can then throw it
			throw e;
			
			// throw new DenominatorIsZeroException();
		}
		
		double result = (double) numerator / denominator; // this becomes a double / int -> double / double = double
		
		return result;
	}
	
	public static void method2() throws SomeException {
		
	}

}
