package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Pirate;

public interface PirateDAO {

	List<Pirate> getAllPiratesFromShip(int shipId) throws SQLException;
	
}
