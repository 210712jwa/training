package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ship")
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Ship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ship_name")
	private String shipName;
	
	@Column(name = "age")
	private int age;
	
	public Ship(String name, int age) {
		this.shipName = name;
		this.age = age;
	}
}
