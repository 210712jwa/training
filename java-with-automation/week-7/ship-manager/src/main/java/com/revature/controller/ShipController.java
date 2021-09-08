package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotation.UserProtected;
import com.revature.dto.AddShipDTO;
import com.revature.dto.MessageDto;
import com.revature.exception.BadParameterException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Ship;
import com.revature.service.ShipService;

@RestController
@CrossOrigin(origins = "http://localhost:4201", allowCredentials = "true") // Whenever our browser makes a request
// to the backend, this annotation is what the backend will use to tell the browser
// that the source of the JavaScript code that is sending the request to the backend
// is a "trusted" source
// CORS is a security feature on most modern browsers
// We don't have CORS issues with Postman, because Postman doesn't care
// However, browsers are used by consumers who we should definitely be caring about in terms
// of providing a secure browsing experience

// The reason CORS exists is because users might visit malicious websites that have malicious
// JavaScript that will attempt to send HTTP requests to a backend that is not in their control

// So the backend will inform the browser about what JavaScript sources are actually trusted
public class ShipController {

	@Autowired
	// Singleton scoped bean
	private ShipService shipService;
	
	// Used to inject the mock shipService dependency into this object
	public ShipController(ShipService shipService) {
		this.shipService = shipService;
	}
	
	@PostMapping(path = "/ship")
	@UserProtected // Our own custom annotation that we put on controller layer methods that we would like to protect
	public ResponseEntity<Object> addShip(@RequestBody AddShipDTO addShipDTO) {
		
		try {
			Ship ship = shipService.addShip(addShipDTO);
			
			return ResponseEntity.status(201).body(ship); // 201 created
		} catch (BadParameterException e) {
			return ResponseEntity.status(400).body(new MessageDto(e.getMessage()));
		}
		
	}
	
	@GetMapping(path = "/ship")
	@UserProtected
	public ResponseEntity<Object> getAllShips() {
		try {
			
			List<Ship> ships = shipService.getAllShips();
			
			return ResponseEntity.status(200).body(ships);
		} catch (ShipNotFoundException e) {
			return ResponseEntity.status(404).body(new MessageDto(e.getMessage()));
		}
	}
	
	@GetMapping(path = "/ship/{id}")
	@UserProtected
	public ResponseEntity<Object> getShipById(@PathVariable("id") String id) {
		Ship ship;
		try {
			ship = shipService.getShipById(id);
			
			return ResponseEntity.status(200).body(ship);
		} catch (BadParameterException e) {
			return ResponseEntity.status(400).body(new MessageDto(e.getMessage()));
		}
		
	}
	
}
