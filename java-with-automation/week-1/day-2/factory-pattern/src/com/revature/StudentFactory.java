package com.revature;

public class StudentFactory {

	/*
	 * StudentFactory is a singleton
	 */
	private static StudentFactory instance;
	
	private StudentFactory() {
		super();
	}
	
	public static StudentFactory getInstance() {
		if (StudentFactory.instance == null) {
			StudentFactory.instance = new StudentFactory();
		}
		
		return StudentFactory.instance;
	}
	
	// Factory method
	public Student getStudent(int age, String name, String type) {
		switch (type.toLowerCase()) {
			case "math":
				return new MathStudent(age, name);
			case "english":
				return new EnglishStudent(age, name);
			case "history":
				return new HistoryStudent(age, name);
			default:
				throw new IllegalArgumentException("Type " + type + " is not a valid type of student");
		}
	}
	
}
