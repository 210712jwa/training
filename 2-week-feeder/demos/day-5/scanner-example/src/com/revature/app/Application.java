package com.revature.app;

import java.util.Scanner;

import com.revature.model.Dog;

public class Application {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String shouldContinue;
		do {
			System.out.println("Enter a name, weight, and breed of a Dog: ");
			
			String name = sc.nextLine();
			
			// Option #1 for getting around the issue of pressing enter after entering the weight
			// and not having the ability to enter the breed
//			double weight = sc.nextDouble();
//			sc.nextLine();
			
			// Option #2 for getting around the issue of pressing enter after entering the weight
			// and not having the ability to enter the breed
			double weight = Double.parseDouble(sc.nextLine());
			
			String breed = sc.nextLine();
			
			Dog dog = new Dog(name, weight, breed);
			System.out.println(dog.name);
			System.out.println(dog.weight);
			System.out.println(dog.breed);
			
			System.out.println("Should we enter another Dog? (y/n)");
			shouldContinue = sc.nextLine();
		} while (shouldContinue.equals("y"));
		
	}

}
