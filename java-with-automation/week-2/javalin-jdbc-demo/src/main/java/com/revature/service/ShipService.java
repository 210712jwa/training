package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.ShipDAO;
import com.revature.dao.ShipDAOImpl;
import com.revature.dto.AddOrEditShipDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Ship;

public class ShipService {

	// ShipDAO is a dependency of ShipService
	private ShipDAO shipDao;
	
	public ShipService() {
		this.shipDao = new ShipDAOImpl();
	}
	
	// This method is dependent on a ShipDAO object to function
	// Because we're invoking the getAllShips() method from ShipDAO
	public List<Ship> getAllShips() throws DatabaseException {
		try {
			List<Ship> ships = shipDao.getAllShips();
			
			return ships;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}
	
	public Ship getShipById(String stringId) throws DatabaseException, ShipNotFoundException, BadParameterException {
		
		try {
			int id = Integer.parseInt(stringId);
			
			Ship ship = shipDao.getShipById(id);
			
			if (ship == null) {
				throw new ShipNotFoundException("Ship with id " + id + " was not found");
			}
			
			return ship;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		} catch (NumberFormatException e) {
			throw new BadParameterException(stringId + " was passed in by the user as the id, " + "but it is not an int");
		}
	}
	
	public Ship addShip(AddOrEditShipDTO ship) throws DatabaseException {
		try {
			Ship addedShip = shipDao.addShip(ship);
			
			return addedShip;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}
	
	public Ship editShip(int shipId, AddOrEditShipDTO ship) throws DatabaseException, ShipNotFoundException {
		
		try {
			// Before we can edit a Ship, see if the ship already exists, and if not, throw an Exception
			if (shipDao.getShipById(shipId) == null) {
				throw new ShipNotFoundException("Ship with id " + shipId + " was not found");
			}
			
			// If ship exists, we proceed to edit the ship
			Ship editedShip = shipDao.editShip(shipId, ship);
			
			return editedShip;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}

	}
	
}
