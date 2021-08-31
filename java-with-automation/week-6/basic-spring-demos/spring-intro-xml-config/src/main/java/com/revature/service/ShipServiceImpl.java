package com.revature.service;

import java.util.List;

import com.revature.dao.ShipDao;
import com.revature.model.Ship;

public class ShipServiceImpl implements ShipService {

	private ShipDao shipDao;
	
	private int someIntPrimitive;
	private String someStringObject;
	
	public ShipServiceImpl(ShipDao shipDao, String value) {
		System.out.println("ShipServiceImpl: Constructor injection invoked");
		this.shipDao = shipDao;
		this.someStringObject = value;
	}

	@Override
	public List<Ship> getAllShips() {
		return shipDao.getAllShips();
	}

	public void setSomeIntPrimitive(int someIntPrimitive) {
		this.someIntPrimitive = someIntPrimitive;
	}
	
}
