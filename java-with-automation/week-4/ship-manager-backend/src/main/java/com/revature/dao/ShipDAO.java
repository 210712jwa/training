package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.Ship;
import com.revature.util.SessionFactorySingleton;

public class ShipDAO {

	public List<Ship> getAllShipsFromUserId(int id) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// Get ships by owner id
		List<Ship> ships = session.createQuery("SELECT s FROM Ship s JOIN s.owner u WHERE u.id = :userid").setParameter("userid", id).getResultList();
	
		return ships;
	}
	
}
