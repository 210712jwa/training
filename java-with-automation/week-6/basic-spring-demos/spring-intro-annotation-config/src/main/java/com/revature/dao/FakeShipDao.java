package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.model.Ship;

@Component
public class FakeShipDao implements ShipDao {

	private List<Ship> fakeDatabase = Arrays.asList(new Ship(1, "Black Pearl"), new Ship(2, "Queen Anne's Revenge"), new Ship(3, "Jolly Roger"));
	
	public FakeShipDao() {
		System.out.println("FakeShipDao: Constructor Invoked");
	}
	
	public List<Ship> getAllShips() {
		return fakeDatabase;
	}

}
