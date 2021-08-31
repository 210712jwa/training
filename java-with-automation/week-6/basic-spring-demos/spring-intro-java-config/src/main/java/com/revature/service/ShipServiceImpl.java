package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ShipDao;
import com.revature.model.Ship;

public class ShipServiceImpl implements ShipService {

	private ShipDao shipDao;
	
	@Autowired // Constructor Injection
	public ShipServiceImpl(ShipDao shipDao) {
		System.out.println("ShipServiceImpl: Constructor injection invoked");
		this.shipDao = shipDao;
	}

	@Override
	public List<Ship> getAllShips() {
		return shipDao.getAllShips();
	}
	
}
