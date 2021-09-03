package com.revature.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.springbootdemo.dao.ShipDao;
import com.revature.springbootdemo.model.Ship;

@Service
public class ShipService {

	@Autowired
	private ShipDao shipDao;
	
	public List<Ship> getAllShips() {
		return shipDao.findAll();
	}

	public Ship getShipByName(String name) {
		return shipDao.findByName(name);
	}
	
	public List<Ship> getShipByAgeGreaterThan(int greaterThan) {
		return shipDao.findByAgeGreaterThan(greaterThan);
	}
	
	public List<Ship> getShipByAgeLessThan(int lessThan) {
		return shipDao.findByAgeLessThan(lessThan);
	}

	public List<Ship> getShipByAgeLessThanAndGreaterThan(int greaterThan, int lessThan) {
		return shipDao.findByAgeBetween(greaterThan, lessThan);
	}
}
