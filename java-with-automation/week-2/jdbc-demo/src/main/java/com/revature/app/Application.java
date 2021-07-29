package com.revature.app;

import java.util.List;

import com.revature.dto.AddOrEditShipDTO;
import com.revature.exception.DatabaseException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Ship;
import com.revature.service.ShipService;

public class Application {

	public static void main(String[] args) {
		
//		try {
//			Connection connection = ConnectionUtility.getConnection();
//			
//			System.out.println(connection);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		ShipService shipService = new ShipService();
		
		/*
		 * getAllShips example
		 */
		try {
			
			List<Ship> ships = shipService.getAllShips();
			System.out.println(ships);
			
		} catch (DatabaseException e) {
			System.out.println("Something went wrong when interacting with the database");
			// When it comes to HTTP response codes, this would probably be where you set the response code to 500
		}
		
		/*
		 * getShipById example
		 */
		try {
			Ship ship = shipService.getShipById(4);
			
			System.out.println(ship);
		} catch (DatabaseException e) {
			System.out.println("Something went wrong when interacting with the database");
		} catch (ShipNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		/*
		 * addShip example
		 */
//		try {
//			AddOrEditShipDTO shipDto = new AddOrEditShipDTO();
//			shipDto.setName("Fancy");
//			shipDto.setAge(6);
//			
//			Ship createdShip = shipService.addShip(shipDto);
//			System.out.println("Ship Added: " + createdShip);
//		} catch (DatabaseException e) {
//			System.out.println("Something went wrong when interacting with the database");
//		}
		
		/*
		 * editShip example
		 */
		try {
			AddOrEditShipDTO shipDto = new AddOrEditShipDTO();
			shipDto.setName("Black Pearl");
			shipDto.setAge(100);
			
			Ship ship = shipService.editShip(1, shipDto);
			System.out.println(ship);
		} catch (ShipNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (DatabaseException e) {
			System.out.println("Something went wrong when interacting with the database");
		}
	}

}
