package com.revature.model;

public class Person {

	private String name;
	private int age;
	private String phoneNumber;
	
	public Person(String name, int age, String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	// we are overriding the toString method that is defined in the Object class
	// this is possible because we are inheriting from the Object class
	// the toString method is used to provide a String representation of an object
	// So, typically, the toString method is used to return the properties of an object
	@Override
	public String toString() {
		return "Person [name=" + this.name + ", age=" + this.age + ", phoneNumber=" + this.phoneNumber + "]";
	}
	
	/*
	 * The general contract of hashCode is:

	Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
	If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
	It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	// By default, the equals(Object o) method defined in the Object class works exactly the same as ==
	// == would just compare whether the 2 reference variables point to the same object or not
	// Typically, we would override the equals method in order to base our comparison not around whether they are the same object or not
	// but whether they have the same properties or not
	// So the equals overridden method below will return true if the name, age, and phoneNumber are the same
	// and false if any of those properties are different
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
	@Override
	// finalize is called by the garbage collector before an object is garbage collected
	// typically we might override this method in order to do some sort of cleanup beforehand
	// not really commonly overridden
	public void finalize() {
		System.out.println("Person object is about to be deleted");
	}
	
	/*
	 * Getters/Setters
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
