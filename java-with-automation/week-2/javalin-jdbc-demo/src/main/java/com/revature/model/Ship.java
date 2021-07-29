package com.revature.model;

public class Ship {

	private int id;
	private String name;
	private int age;
	
	// No-args constructor
	public Ship() {
		super();
	}
	
	// Parameterized constructor
	public Ship(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	// Getters/Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	// hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Ship [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
