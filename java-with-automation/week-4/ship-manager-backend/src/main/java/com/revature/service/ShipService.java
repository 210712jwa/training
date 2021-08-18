package com.revature.service;

import java.util.List;

import com.revature.dao.ShipDAO;
import com.revature.model.Ship;

public class ShipService {

	private ShipDAO shipDao;
	
	public ShipService() {
		this.shipDao = new ShipDAO();
	}
	
	public List<Ship> getAllShipsFromUserId(String userId) {
		int id = Integer.parseInt(userId);
		
		List<Ship> ships = shipDao.getAllShipsFromUserId(id);
		
		return ships;
	}
	
}
