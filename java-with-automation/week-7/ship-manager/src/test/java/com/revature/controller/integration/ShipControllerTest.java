package com.revature.controller.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.AddShipDTO;
import com.revature.model.Ship;
import com.revature.model.User;
import com.revature.service.AuthenticationService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource("classpath:springorm-test.properties")
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class ShipControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AuthenticationService authService;
		
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		this.objectMapper = new ObjectMapper();
	}

	@Test
	@Transactional
	@Order(0)
	@Commit
	void test_addShip_andReceiveJsonResponse() throws Exception {
		// Add a user to the H2 database for this test class
		Session session = sessionFactory.getCurrentSession();
		session.persist(new User("user12345", "12345"));
		
		User user = authService.login("user12345", "12345"); // use this method to login and retrieve the User object
		
		// Have a MockHttpSession so that it doesn't give us a 401 status code, and instead actually proceeds with the endpoint
		MockHttpSession mockSession = new MockHttpSession();
		mockSession.setAttribute("currentUser", user);
		
		AddShipDTO addShipDto = new AddShipDTO();
		addShipDto.setName("Black Pearl");
		addShipDto.setAge(100);
		
		String addShipDtoJson = objectMapper.writeValueAsString(addShipDto);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/ship")
				.session(mockSession)
				.contentType(MediaType.APPLICATION_JSON)
				.content(addShipDtoJson);
		
		Ship expected = new Ship("Black Pearl", 100);
		expected.setId(1);
		String expectedJson = objectMapper.writeValueAsString(expected);
		
		this.mockMvc
			.perform(builder)
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.content().json(expectedJson));
	}

}
