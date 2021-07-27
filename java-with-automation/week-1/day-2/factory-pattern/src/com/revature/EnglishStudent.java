package com.revature;

public class EnglishStudent extends Student {

	public EnglishStudent(int age, String name) {
		super(age, name, "English");
	}
	
	@Override
	public void study() {
		System.out.println("Reading books");
	}
	
}
