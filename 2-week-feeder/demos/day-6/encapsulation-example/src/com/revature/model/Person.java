package com.revature.model;

public class Person {
	
	private String name;
	private int age;
	private String phoneNumber;
	
	public Person(String name, int age, String phoneNumber) {
		setName(name);
		setAge(age);
		setPhoneNumber(phoneNumber);
	}
	
	/*
	 * Getter Methods (Accessors)
	 * 
	 * Used to expose the values of our properties
	 * Usually getter methods have higher accessibility than the properties
	 */
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/*
	 * Setter Methods (Mutators)
	 * 
	 * Used to set the values of our properties
	 * Usually setter methods have higher accessibility than the properties
	 * 
	 * Often contains validation to make sure that we are setting values appropriately for those properties
	 */
	public void setName(String name) {
		// Check to see if name contains only alphabetical characters, spaces, or apostrophes
		// We'll use a regular expression to check for this
		
		// the + means 1 or more
		// in regex there's also the *, which means 0 or more
		if (name.matches("[a-zA-Z\\s']+")) {
			this.name = name;
		} else {
			System.out.println("Invalid value " + name + " for setting name");
		}
	}
	
	public void setAge(int age) {
		if (age < 0 || age > 130) {
			System.out.println("Invalid value " + age + " for setting age");
		} else {
			this.age = age;
		}
	}
	
	public void setPhoneNumber(String phoneNumber) {
		// Use what is known as a "regular expression (regex)" to check our phoneNumber string against some
		// pattern
		// So we want the phoneNumber to match the format xxx-xxx-xxxx
		
		if (phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
			this.phoneNumber = phoneNumber;
		} else {
			System.out.println("Invalid value " + phoneNumber + " for setting phone number. Format must be " + 
								"xxx-xxx-xxxx");
		}
	}
}
