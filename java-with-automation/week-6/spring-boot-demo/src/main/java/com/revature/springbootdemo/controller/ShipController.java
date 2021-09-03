package com.revature.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springbootdemo.model.Ship;
import com.revature.springbootdemo.service.ShipService;

@RestController
public class ShipController {

	@Autowired
	private ShipService shipService;
	
	@GetMapping(path = "/ship")
	public ResponseEntity<Object> getAllShips() {		
		return ResponseEntity.status(200).body(shipService.getAllShips());
	}
	
	@GetMapping(path = "/ship", params = {"name"})
	public ResponseEntity<Object> getShipByName(@RequestParam("name") String name) {
		Ship ship = shipService.getShipByName(name);
		
		return ResponseEntity.status(200).body(ship);
	}
	
	@GetMapping(path = "/ship", params = {"ageLessThan"})
	public ResponseEntity<Object> getShipByAgeLessThan(@RequestParam("ageLessThan") int lessThan) {
		List<Ship> ship = shipService.getShipByAgeLessThan(lessThan);
		
		return ResponseEntity.status(200).body(ship);
	}
	
	@GetMapping(path = "/ship", params = {"ageGreaterThan"})
	public ResponseEntity<Object> getShipByAgeGreaterThan(@RequestParam("ageGreaterThan") int greaterThan) {
		List<Ship> ship = shipService.getShipByAgeGreaterThan(greaterThan);
		
		return ResponseEntity.status(200).body(ship);
	}
	
	@GetMapping(path = "/ship", params = {"ageLessThan", "ageGreaterThan"})
	public ResponseEntity<Object> getShipByAgeGreaterThan(@RequestParam("ageGreaterThan") int greaterThan, @RequestParam("ageLessThan") int lessThan) {
		List<Ship> ship = shipService.getShipByAgeLessThanAndGreaterThan(greaterThan, lessThan);
		
		return ResponseEntity.status(200).body(ship);
	}
}
