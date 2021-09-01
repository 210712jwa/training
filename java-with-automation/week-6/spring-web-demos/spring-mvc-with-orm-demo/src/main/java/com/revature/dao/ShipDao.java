package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dto.AddShipDTO;
import com.revature.model.Ship;

@Repository
public class ShipDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional // by default, this method will use the outer transaction or create a new transaction if non is available
	public Ship addShip(AddShipDTO addShipDto) {
		Session session = sessionFactory.getCurrentSession();
		
		Ship newShip = new Ship(addShipDto.getName(), addShipDto.getAge());
		
		session.persist(newShip);
		
		return newShip;
	}

	@Transactional
	public List<Ship> getAllShips() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Ship> ships = session.createQuery("FROM Ship s").getResultList();
		
		return ships;
	}
	
}
