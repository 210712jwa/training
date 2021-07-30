package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*; // You may need to type this import manually to make use of 
// the argument matchers for Mockito, such as eq() or any()

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.dao.ShipDAO;
import com.revature.dto.AddOrEditShipDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Ship;

public class ShipServiceTest {
	
	private ShipService shipService;
	private ShipDAO shipDao;
	
	@Before
	public void setUp() throws Exception {
		this.shipDao = mock(ShipDAO.class); // I'm using Mockito to create a fake shipDao object
		
		this.shipService = new ShipService(shipDao); // Here I am injecting the mocked object into a ShipService object
	}

	// Positive test case / "happy path"
	@Test
	public void test_getAllShips_positive() throws DatabaseException, SQLException {
		// Because we're not using a real ShipDAO object and instead a mocked ShipDAO, 
		// we need to actually specify what we want the mocked ShipDAO to return whenever we invoke the shipDao.getAllShips() method
		List<Ship> mockReturnValues = new ArrayList<>();
		mockReturnValues.add(new Ship(1, "Black Pearlssss", 40));
		mockReturnValues.add(new Ship(2, "Royal Fortune", 10));
		when(shipDao.getAllShips()).thenReturn(mockReturnValues);
		
		// actual = the real data being returned by the getAllShips method from shipService
		List<Ship> actual = shipService.getAllShips();
		
		// expected = what we expect for the ships List to contain
		List<Ship> expected = new ArrayList<>();
		expected.add(new Ship(1, "Black Pearlssss", 40));
		expected.add(new Ship(2, "Royal Fortune", 10));
		
		// So, we do an assertEquals, to have these two compared to each other
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_getAllShips_negative() throws SQLException {
		when(shipDao.getAllShips()).thenThrow(SQLException.class);
		// Simulate a situation where shipDao.getAllShips() throws a SQLException
		
		try {
			shipService.getAllShips();
			
			fail(); // We only reach the fail() assertion IF DatabaseException is not thrown and caught
			// So this allows us to test for the DatabaseException occurring.
			// Additionally, in the catch block, we're also checking the exception message itself
		} catch (DatabaseException e) {
			String exceptionMessage = e.getMessage();
			assertEquals("Something went wrong with our DAO operations", exceptionMessage);
		}
		
	}
	
//	@Test(expected = BadParameterException.class)
//	public void test_getShipById_idStringIsNotAnInt() throws DatabaseException, ShipNotFoundException, BadParameterException {
//		shipService.getShipById("asdfsdf");
//	}
	
	@Test
	public void test_getShipById_idStringIsNotAnInt() throws DatabaseException, ShipNotFoundException {
		try {
			shipService.getShipById("asdfasdf");
			
			fail();
		} catch (BadParameterException e) {
			assertEquals("asdfasdf was passed in by the user as the id, but it is not an int", e.getMessage());
		}
	}
	
	@Test
	public void test_getShipById_existingId() throws SQLException, DatabaseException, ShipNotFoundException, BadParameterException {
		when(shipDao.getShipById(eq(1))).thenReturn(new Ship(1, "Black Pearl", 1));
		
		Ship actual = shipService.getShipById("1");
		
		Ship expected = new Ship(1, "Black Pearl", 1);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_getShipById_shipDoesNotExist() throws DatabaseException, ShipNotFoundException, BadParameterException {
		try {
			shipService.getShipById("10"); // Because I'm not providing a mock response for getShipId when the int parameter
			// passed into that method is 10, it will by default return a null value
			
			fail();
		} catch (ShipNotFoundException e) {
			assertEquals("Ship with id 10 was not found", e.getMessage());
		}
	}
	
	@Test
	public void test_getShipById_sqlExceptionEncountered() throws SQLException, ShipNotFoundException, BadParameterException {
		try {
			when(shipDao.getShipById(anyInt())).thenThrow(SQLException.class);
			
			shipService.getShipById("1");
			
			fail();
		} catch (DatabaseException e) {
			assertEquals("Something went wrong with our DAO operations", e.getMessage());
		}
	}
	
	@Test
	public void test_addShip_positivePath() throws SQLException, DatabaseException, BadParameterException {
		
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("Black Pearl");
		dto.setAge(10);
		
		when(shipDao.addShip(eq(dto))).thenReturn(new Ship(1, "Black Pearl", 10));
		
		Ship actual = shipService.addShip(dto);
		
		assertEquals(new Ship(1, "Black Pearl", 10), actual);
	}
	
	@Test
	public void test_addShip_blankName() throws DatabaseException {
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("");
		dto.setAge(10);
		
		try {
			shipService.addShip(dto);
			
			fail();
		} catch (BadParameterException e) {
			assertEquals("Ship name cannot be blank", e.getMessage());
		}
		
	}
	
	@Test
	public void test_addShip_blankNameWithSpaces() throws DatabaseException {
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("                        ");
		dto.setAge(10);
		
		try {
			shipService.addShip(dto);
			
			fail();
		} catch (BadParameterException e) {
			assertEquals("Ship name cannot be blank", e.getMessage());
		}
	}

	@Test
	public void test_addShip_negativeAge() throws DatabaseException {
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("Bach's Ship");
		dto.setAge(-1);
		
		try {
			shipService.addShip(dto);
			
			fail();
		} catch (BadParameterException e) {
			assertEquals("Ship age cannot be less than 0", e.getMessage());
		}
		
	}
	
	@Test
	public void test_addShip_negativeAgeAndBlankName() throws DatabaseException {
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("");
		dto.setAge(-10);
		
		try {
			shipService.addShip(dto);
			
			fail();
		} catch (BadParameterException e) {
			assertEquals("Ship name cannot be blank and age cannot be less than 0", e.getMessage());
		}
		
	}
	
	@Test(expected = DatabaseException.class)
	public void test_addShip_SQLExceptionEncountered() throws SQLException, DatabaseException, BadParameterException {
		when(shipDao.addShip(any())).thenThrow(SQLException.class);
		
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("Black Pearl");
		dto.setAge(10);
		shipService.addShip(dto);
	}
	
	@Test
	public void test_editShip_positivePath() throws DatabaseException, ShipNotFoundException, BadParameterException, SQLException {
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("Black Pearl");
		dto.setAge(100);
		
		Ship shipWithId10 = new Ship(10, "Jolly Roger", 5);
		when(shipDao.getShipById(eq(10))).thenReturn(shipWithId10);
		
		when(shipDao.editShip(eq(10), eq(dto))).thenReturn(new Ship(10, "Black Pearl", 100));
		
		Ship actual = shipService.editShip("10", dto);
		
		Ship expected = new Ship(10, "Black Pearl", 100);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_editShip_shipDoesNotExist() throws DatabaseException, BadParameterException {
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("Black Pearl");
		dto.setAge(100);
		
		try {
			shipService.editShip("1000", dto);
			
			fail();
		} catch (ShipNotFoundException e) {
			assertEquals("Ship with id 1000 was not found", e.getMessage());
		}
		
	}
	
	@Test(expected = BadParameterException.class)
	public void test_editShip_invalidId() throws DatabaseException, ShipNotFoundException, BadParameterException {
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("Black Pearl");
		dto.setAge(100);
		
		shipService.editShip("abc", dto);
	}
	
	@Test(expected = DatabaseException.class)
	public void test_editShip_SQLExceptionEncountered() throws SQLException, DatabaseException, ShipNotFoundException, BadParameterException {
		AddOrEditShipDTO dto = new AddOrEditShipDTO();
		dto.setName("Black Pearl");
		dto.setAge(100);
		
		when(shipDao.getShipById(eq(10))).thenReturn(new Ship(10, "Jolly Roger", 5));
		when(shipDao.editShip(eq(10), eq(dto))).thenThrow(SQLException.class);
		
		shipService.editShip("10", dto);
	}
	
	/*
	 * Exercise: Create tests for DeleteShip and have full test coverage
	 */
}
