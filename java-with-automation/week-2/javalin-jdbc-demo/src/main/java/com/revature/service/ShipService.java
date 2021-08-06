package com.revature.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.PirateDAO;
import com.revature.dao.PirateDAOImpl;
import com.revature.dao.ShipDAO;
import com.revature.dao.ShipDAOImpl;
import com.revature.dto.AddOrEditShipDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Pirate;
import com.revature.model.Ship;

public class ShipService {

	private Logger logger = LoggerFactory.getLogger(ShipService.class);
	
	// ShipDAO is a dependency of ShipService
	private ShipDAO shipDao;
	private PirateDAO pirateDao;
	
	// This constructor will instantiate a REAL ShipDAO object making use of the ShipDAOImpl class
	public ShipService() {
		this.shipDao = new ShipDAOImpl();
		this.pirateDao = new PirateDAOImpl();
	}
	
	// This constructor is used to "inject" a fake ShipDAO object whenever I am instantiating a ShipService object
	// that I want to perform unit tests on
	public ShipService(ShipDAO mockedShipDaoObject, PirateDAO mockedPirateDaoObject) {
		this.shipDao = mockedShipDaoObject;
		this.pirateDao = mockedPirateDaoObject;
	}
	
	// This method is dependent on a ShipDAO object to function
	// Because we're invoking the getAllShips() method from ShipDAO
	public List<Ship> getAllShips() throws DatabaseException {
		List<Ship> ships;
		try {
			ships = shipDao.getAllShips();
			
			for (Ship ship : ships) {
				List<Pirate> pirates = pirateDao.getAllPiratesFromShip(ship.getId());
				ship.setPirates(pirates);
			}
			
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
		
		return ships;
	}
	
	public Ship getShipById(String stringId) throws DatabaseException, ShipNotFoundException, BadParameterException {
		try {
			int id = Integer.parseInt(stringId);
			
			Ship ship = shipDao.getShipById(id);
			
			if (ship == null) {
				throw new ShipNotFoundException("Ship with id " + id + " was not found");
			}
			
			List<Pirate> pirates = pirateDao.getAllPiratesFromShip(id);
			ship.setPirates(pirates);
			
			return ship;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		} catch (NumberFormatException e) {
			throw new BadParameterException(stringId + " was passed in by the user as the id, " + "but it is not an int");
		}
	}
	
	public Ship addShip(AddOrEditShipDTO ship) throws DatabaseException, BadParameterException {
		if (ship.getName().trim().equals("") && ship.getAge() < 0) {
			throw new BadParameterException("Ship name cannot be blank and age cannot be less than 0");
		}
		
		if (ship.getName().trim().equals("")) {
			throw new BadParameterException("Ship name cannot be blank");
		}
		
		if (ship.getAge() < 0) {
			throw new BadParameterException("Ship age cannot be less than 0");
		}
		
		try {
			Ship addedShip = shipDao.addShip(ship);
			addedShip.setPirates(new ArrayList<>());
			
			return addedShip;
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Ship editShip(String stringId, AddOrEditShipDTO ship) throws DatabaseException, ShipNotFoundException, BadParameterException {
		
		try {
			int shipId = Integer.parseInt(stringId);
			
			// Before we can edit a Ship, see if the ship already exists, and if not, throw an Exception
			if (shipDao.getShipById(shipId) == null) {
				throw new ShipNotFoundException("Ship with id " + shipId + " was not found");
			}
			
			// If ship exists, we proceed to edit the ship
			Ship editedShip = shipDao.editShip(shipId, ship);
			
			List<Pirate> pirates = pirateDao.getAllPiratesFromShip(shipId);
			editedShip.setPirates(pirates);
			
			return editedShip;
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		} catch (NumberFormatException e) {
			throw new BadParameterException(stringId + " was passed in by the user as the id, " + "but it is not an int");
		}

	}

	public void deleteShip(String shipId) throws BadParameterException, DatabaseException, ShipNotFoundException {
		
		// Check to see if the ship exists
		try {
			int id = Integer.parseInt(shipId);
			
			Ship ship = shipDao.getShipById(id);
			if (ship == null) {
				throw new ShipNotFoundException("Trying to delete ship with an id of " + id + ", but it does not exist");
			}
			
			shipDao.deleteShip(id);
			
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		} catch (NumberFormatException e) {
			throw new BadParameterException(shipId + " was passed in by the user as the id, " + "but it is not an int");
		}
		
	}

	public void getShipsWithAgeBetween(int i, String queryParam) {
		
		
	}
	
}
