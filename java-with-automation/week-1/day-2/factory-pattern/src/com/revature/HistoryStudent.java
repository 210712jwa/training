package com.revature;

public class HistoryStudent extends Student {

	public HistoryStudent(int age, String name) {
		super(age, name, "History");
	}
	
	@Override
	public void study() {
		System.out.println("Reading about the postwar era");
	}
	
}
