package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.ShipDao;
import com.revature.model.Ship;

@Service // We could use @Component or @Service
//Here I will use @Service to be more explicit that we are creating a service spring bean
public class ShipServiceImpl implements ShipService {

	private ShipDao shipDao;
	
	public ShipServiceImpl(ShipDao shipDao) {
		System.out.println("ShipServiceImpl: Constructor injection invoked");
		this.shipDao = shipDao;
	}

	@Override
	public List<Ship> getAllShips() {
		return shipDao.getAllShips();
	}
	
}
