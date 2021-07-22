package com.revature;

import static java.lang.Math.PI;

public class Application {

	public static void main(String[] args) {
		// Let's say I use Math.PI super often in my code here
		// Instead of having to reference the PI property from the Math class as 'Math.PI' every single time
		// I can just do a static import
		
		System.out.println(PI + PI);
		// instead of
		System.out.println(Math.PI + Math.PI);

		int x = 10;
		String s;
	}

}
