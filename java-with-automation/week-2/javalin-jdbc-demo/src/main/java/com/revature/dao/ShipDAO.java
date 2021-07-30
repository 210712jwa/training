package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.dto.AddOrEditShipDTO;
import com.revature.model.Ship;

public interface ShipDAO {

	public abstract List<Ship> getAllShips() throws SQLException;
	
	/**
	 * This method returns a Ship from the database
	 * 
	 * @param id is an int that represents the id
	 * @return Ship a representation of ship, or null if none was found
	 */
	public abstract Ship getShipById(int id) throws SQLException;
	
	// Here we are making use of a parameter known as AddShipDTO, which is a Data Transfer Object
	// DTOs are classes that are used to pass data around that might not completely conform to the actual "Model" class
	// The "Model" class in this case is the Ship class, which will define ALL of the attributes associated with the data inside the
	// database
	public abstract Ship addShip(AddOrEditShipDTO ship) throws SQLException;
	
	public abstract Ship editShip(int shipId, AddOrEditShipDTO ship) throws SQLException;
	
	public abstract void deleteShip(int shipId) throws SQLException;
}
