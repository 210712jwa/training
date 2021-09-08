package com.revature.controller.unit;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.ShipController;
import com.revature.dto.MessageDto;
import com.revature.exception.BadParameterException;
import com.revature.model.Ship;
import com.revature.service.ShipService;

@ExtendWith(MockitoExtension.class)
class ShipControllerTest {

	private static MockMvc mockMvc;
	
	@Mock
	private ShipService shipServiceMock;
	
	@InjectMocks // This will instantiate the ShipController and inject the shipService mock into it
	private ShipController shipController;
	
	@BeforeEach
	void setUp() throws Exception {		
		mockMvc = MockMvcBuilders.standaloneSetup(shipController).build();
	}

	@Test
	void testGetShipById1_success() throws Exception {
		Ship ship1 = new Ship("Black Pearl", 100);
		ship1.setId(1);
		when(shipServiceMock.getShipById(eq("1"))).thenReturn(ship1);
		
		Ship expectedShip = new Ship("Black Pearl", 100);
		expectedShip.setId(1);
		
		ObjectMapper om = new ObjectMapper();
		String expectedShipJson = om.writeValueAsString(expectedShip); // converting our expected object into JSON
		
		mockMvc
			.perform(get("/ship/1"))
			.andExpect(MockMvcResultMatchers.status().isOk()) // expecting status code 200
			.andExpect(MockMvcResultMatchers.content().json(expectedShipJson)); // expecting our JSON
	}
	
	@Test
	void testGetShipByIdabc_400() throws Exception {
		BadParameterException bpException = new BadParameterException("Id must be an int");
		when(shipServiceMock.getShipById(eq("abc"))).thenThrow(bpException);
		
		MessageDto expectedDto = new MessageDto("Id must be an int");
		
		ObjectMapper om = new ObjectMapper();
		String expectedDtoJson = om.writeValueAsString(expectedDto);
		
		mockMvc
			.perform(get("/ship/abc"))
			.andExpect(MockMvcResultMatchers.status().is4xxClientError())
			.andExpect(MockMvcResultMatchers.content().json(expectedDtoJson));
	}

}
