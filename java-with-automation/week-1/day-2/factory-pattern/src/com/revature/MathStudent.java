package com.revature;

public class MathStudent extends Student {

	public MathStudent(int age, String name) {
		super(age, name, "Mathematics");
	}
	
	@Override
	public void study() {
		System.out.println("Solving differential equations");
	}
	
}
