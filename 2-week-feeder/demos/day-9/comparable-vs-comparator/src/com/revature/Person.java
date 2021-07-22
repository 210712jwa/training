package com.revature;

// Create a natural ordering for Person objects
// We will implement the Comparable interface and provide an implementation for the compareTo method
public class Person implements Comparable<Person> {

	private String name;
	private int age;
	
	// No-args
	public Person() {
		super();
	}
	
	// Parameterized
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/*
	 * Getters/setters
	 */
	public String getName() {
		return name;
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

	// hashCode overriding (from Object class)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// equals overriding (from Object class)
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
		return true;
	}

	// toString overriding (from Object class)
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		if (this.age == o.age) {
			return this.getName().compareTo(o.getName());
			// this.getName() returns a string. So if we use the compareTo method that was overridden in the String class
			// we will be able to compare to another String (and this will provide alphabetical ordering)
		}
		
		return this.age - o.age;
		
		// The logic above allows us to order by age and then by name
		
		// 0 means equals
		// < 0 means it comes before
		// > 0 means it comes after
	}
	
}
