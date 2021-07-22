package com.revature.model;

// If we want to create a natural ordering for our Cars
// Kind of like how the natural ordering for Strings is alphabetically
// We need to implement the Comparable interface
public class Car implements Comparable<Car> {

	// This is a POJO (plain old Java object)
	// Used as a blueprint to create Car objects
	// So typically we want to 
	// 1. Make our properties private
	// 2. Have a no-args constructor
	// 3. Have an all-args constructor
	// 4. Have getters and setters
	// 5. Have equals() and hashCode() overridden
	// 6. Have toString() overridden
	
	private int year;
	private String make;
	private String model;
	
	public Car() {
		super();
	}
	
	public Car(int year, String make, String model) {
		this.year = year;
		this.make = make;
		this.model = model;
	}
	
	// Provides the logic for natural ordering
	@Override
	public int compareTo(Car o) {
		
		if (this.year == o.year) {
			if (this.getMake().equals(o.getMake())) return this.getModel().compareTo(o.getModel());
			
			return this.getMake().compareTo(o.getMake());
		}
		
		return this.year - o.year;
		
		// We should return an int of 0 if the two Cars have the same ordering (same year)
		// We should return an int that is < 0 if THIS car object comes before the other car object
		// We should return an int that is > 0 if THIS car object comes after the other car object
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + year;
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
		Car other = (Car) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [year=" + year + ", make=" + make + ", model=" + model + "]";
	}
	
}
