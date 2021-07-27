package com.revature;

import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String shouldContinue = "y";
		while (!shouldContinue.equalsIgnoreCase("n")) {
			System.out.println("Enter the type of student you would like to create: ");
			String type = sc.nextLine();
			
			System.out.println("Enter their age: ");
			int age = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter their name: ");
			String name = sc.nextLine();
			
			try {
				Student student = StudentFactory.getInstance().getStudent(age, name, type);

				student.study();
				
				System.out.println("Should we continue?");
				shouldContinue = sc.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				System.out.println("Please try again");
			}
			
		}

		
	}

}
