package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pirate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "pirate_name")
	private String name;
	
	@Column(name = "pirate_age")
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "ship_id") // optional, I just want to give my own name for the foreign key column
	// @JsonManagedReference
	private Ship ship;

	public Pirate() {
		super();
	}

	public Pirate(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ship == null) ? 0 : ship.hashCode());
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
		Pirate other = (Pirate) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ship == null) {
			if (other.ship != null)
				return false;
		} else if (!ship.equals(other.ship))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pirate [id=" + id + ", name=" + name + ", age=" + age + ", ship=" + ship + "]";
	}
	
}
