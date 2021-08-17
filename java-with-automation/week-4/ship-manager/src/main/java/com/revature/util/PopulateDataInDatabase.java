package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.ShipStatus;
import com.revature.model.ShipType;
import com.revature.model.User;
import com.revature.model.UserRole;

public class PopulateDataInDatabase {

	public static void main(String[] args) {
		populateShipStatus_ShipType_UserRole();
		addSampleUsers();
	}
	
	private static void populateShipStatus_ShipType_UserRole() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		UserRole admin = new UserRole("admin");
		UserRole user = new UserRole("user");
		session.persist(admin);
		session.persist(user);
		
		ShipStatus pending = new ShipStatus("pending");
		ShipStatus approved = new ShipStatus("approved");
		ShipStatus denied = new ShipStatus("denied");
		session.persist(pending);
		session.persist(approved);
		session.persist(denied);
		
		ShipType container = new ShipType("container");
		ShipType tanker = new ShipType("tanker");
		ShipType naval = new ShipType("naval");
		session.persist(container);
		session.persist(tanker);
		session.persist(naval);
		
		tx.commit();
		session.close();
	}
	
	private static void addSampleUsers() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User adminUser1 = new User("Bach", "Tran", "bach.tran@revature.com", "bach12345", "12345");
		UserRole admin = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'admin'").getSingleResult();
		adminUser1.setUserRole(admin);
		session.persist(adminUser1);
		
		UserRole user = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'user'").getSingleResult();
		User regularUser1 = new User("Test1", "testing", "test@test.com", "test12345", "12345");
		regularUser1.setUserRole(user);
		User regularUser2 = new User("John", "Doe", "johndoe@email.com", "johnny123", "password123");
		regularUser2.setUserRole(user);
		
		session.persist(regularUser1);
		session.persist(regularUser2);
		
		tx.commit();
		session.close();
	}

}
