package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.dao.PirateDAO;
import com.revature.dao.ShipDAO;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Pirate;
import com.revature.model.Ship;

public class PirateServiceTest {

	private PirateService pirateService;
	private ShipDAO shipDao;
	private PirateDAO pirateDao;
	
	@Before
	public void setUp() {
		this.shipDao = mock(ShipDAO.class);
		this.pirateDao = mock(PirateDAO.class);
		
		this.pirateService = new PirateService(shipDao, pirateDao);
	}
	
	@Test
	public void test_getAllPiratesFromShip_positive() throws BadParameterException, DatabaseException, ShipNotFoundException, SQLException {
		
		when(shipDao.getShipById(eq(10))).thenReturn(new Ship(10, "Flying Dutchman", 100));
		
		List<Pirate> mockPirates = new ArrayList<>();
		mockPirates.add(new Pirate(1, "pirate1", 30));
		mockPirates.add(new Pirate(2, "pirate2", 33));
		
		when(pirateDao.getAllPiratesFromShip(eq(10))).thenReturn(mockPirates);
		
		List<Pirate> actualPirates = pirateService.getAllPiratesFromShip("10");
		
		assertEquals(mockPirates, actualPirates);
	}
	
	@Test
	public void test_getAllPiratesFromShip_shipDoesNotExist() throws BadParameterException, DatabaseException, ShipNotFoundException, SQLException {
		
		try {
			when(shipDao.getShipById(eq(10))).thenReturn(null);
			
			pirateService.getAllPiratesFromShip("10");
			
			fail();
		} catch(ShipNotFoundException e) {
			assertEquals("Ship with id 10 was not found", e.getMessage());
		}
		
	}
	
	@Test
	public void test_getAllPiratesFromShip_invalidFormatShipId() throws DatabaseException, ShipNotFoundException {
		try {
			pirateService.getAllPiratesFromShip("abc");
			
			fail();
		} catch(BadParameterException e) {
			assertEquals("abc was passed in by the user as the id, but it is not an int", e.getMessage());
		}
	}
	
	@Test(expected = DatabaseException.class)
	public void test_getAllPiratesFromShip_SQLExceptionEncountered_fromShipDao_getShipById() throws SQLException, BadParameterException, DatabaseException, ShipNotFoundException {
		when(shipDao.getShipById(eq(10))).thenThrow(SQLException.class);
		
		pirateService.getAllPiratesFromShip("10");
	}
	
	@Test(expected = DatabaseException.class)
	public void test_getAllPiratesFromShip_SQLExceptionEncountered_fromPirateDao_getAllPiratesFromShip() throws SQLException, BadParameterException, DatabaseException, ShipNotFoundException {
		when(shipDao.getShipById(eq(10))).thenReturn(new Ship(10, "Flying Dutchman", 25));
		
		when(pirateDao.getAllPiratesFromShip(eq(10))).thenThrow(SQLException.class);
		
		pirateService.getAllPiratesFromShip("10");
	}
}
