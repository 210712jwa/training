package com.revature.model;

public class Calculator {

	// double... nums is a variable argument
	// This means we can add in an arbitary number of arguments that will then be treated
	// as a double array
	// so nums can be accessed via array indexing
	public double add(double a, double b, double...nums) {
		double sum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		
		return sum + a + b;
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
}
