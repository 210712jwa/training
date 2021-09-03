package com.revature.springbootdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.springbootdemo.model.Ship;

// We are making use of Spring Data JPA
// It simplifies the process of creating operations in the DAO layer
// All we need to do is define an interface that extends JpaRepository (or CrudRepository, PagingAndSortingRepository)
// From there, we just define methods that meet a certain naming convention in order to query data based on the conditions specified by the naming
public interface ShipDao extends JpaRepository<Ship, Integer> {
	
	public Ship findByName(String name);
	public List<Ship> findByAgeGreaterThan(int age);
	public List<Ship> findByAgeLessThan(int age);
	
	public List<Ship> findByAgeBetween(int greaterThan, int lessThan);
	
}
