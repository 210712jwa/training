package com.revature;

import java.util.Scanner;

import com.revature.model.AWhiskerAwayMovie;
import com.revature.model.JawsMovie;
import com.revature.model.Movie;
import com.revature.model.StarwarsMovie;

public class Application {

	private static Scanner sc = new Scanner(System.in);

	// This is a good demonstration of runtime polymorphism (method overriding)
	// Because it is at runtime when things are figured out in terms of what object we're pointing to
	// We're taking user input, and depending on the user input, switching what type of object the Movie reference variable is
	// pointing to, and then using the appropriate overridden getMovieDescription() method
	public static void main(String[] args) {
		
		Movie movie = new Movie();
		System.out.println(movie.getMovieDescription());
		
		movie = new AWhiskerAwayMovie();
		System.out.println(movie.getMovieDescription()); // at runtime, the JVM figures out what object the Movie reference variable
		// is pointing to, and if there's an overridden method for this object, then it will use that method
		
		movie = new StarwarsMovie();
		System.out.println(movie.getMovieDescription());
		
		movie = new JawsMovie();
		System.out.println(movie.getMovieDescription());
		
		String choice;
		do {
			System.out.println("====================");
			System.out.println("Enter a movie that you want the description of: ");
			System.out.println("0.) Exit");
			System.out.println("1.) Generic Movie");
			System.out.println("2.) A Whisker Away");
			System.out.println("3.) Starwars");
			System.out.println("4.) Jaws");
			
			choice = sc.nextLine();
			
			Movie movieChoice = null;
			
			switch(choice) {
				case "1":
					movieChoice = new Movie();
					break;
				case "2":
					movieChoice = new AWhiskerAwayMovie();
					break;
				case "3":
					movieChoice = new StarwarsMovie();
					break;
				case "4":
					movieChoice = new JawsMovie();
					break;
			}
			
			if (movieChoice != null) {
				System.out.println(movieChoice.getMovieDescription());
			} else if (!choice.equals("0")) {
				System.out.println("Invalid movie choice, please try again");
			}
			
		} while (!choice.equals("0"));
	}
}
