package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pirate_ship")
public class Ship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pirate_ship_id")
	private int id;
	
	@Column(name = "ship_name", length = 50)
	private String name;
	
	@Column(name = "ship_age")
	private int age;
	
//	@OneToMany(mappedBy = "ship", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	// @JsonBackReference This is an annotation that comes from the Jackson databind dependency if we were utilizing Javalin
	// Javalin depends on Jackson databind for converting between an object to JSON and vice versa.
//	private List<Pirate> pirates;

	public Ship() {
		super();
	}

	public Ship(String name, int age) {
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

	@Override
	public String toString() {
		return "Ship [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
