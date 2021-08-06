package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.PirateDAO;
import com.revature.dao.PirateDAOImpl;
import com.revature.dao.ShipDAO;
import com.revature.dao.ShipDAOImpl;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Pirate;

public class PirateService {

	private PirateDAO pirateDao;
	private ShipDAO shipDao;
	
	public PirateService() {
		this.pirateDao = new PirateDAOImpl();
		this.shipDao = new ShipDAOImpl();
	}
	
	// Define a constructor that takes in PirateDAO and ShipDAO to allow us to "inject" mockito mocked objects into
	// a PirateService instance
	public PirateService(ShipDAO shipDao, PirateDAO pirateDao) {
		this.shipDao = shipDao;
		this.pirateDao = pirateDao;
	}
	
	public List<Pirate> getAllPiratesFromShip(String shipIdString) throws BadParameterException, DatabaseException, ShipNotFoundException {
		try {
			
			int shipId = Integer.parseInt(shipIdString);
			
			if(shipDao.getShipById(shipId) == null) {
				throw new ShipNotFoundException("Ship with id " + shipId + " was not found");
			}
			
			List<Pirate> pirates = pirateDao.getAllPiratesFromShip(shipId);
			
			return pirates;
			
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		} catch (NumberFormatException e) {
			throw new BadParameterException(shipIdString + " was passed in by the user as the id, " + "but it is not an int");
		}
	}
	
}
