package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceUnitTest {

	private CalculatorService calculatorService;
	
	@BeforeEach
	public void setUp() {
		this.calculatorService = new CalculatorService();
	}
	
	@Test
	public void test_add_2_and_2_is_4() {
		double actual = this.calculatorService.add(2, 2);
		
		double expected = 4;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_subtract_2_from_8_is_6() {
		double actual = this.calculatorService.subtract(8, 2);
		
		assertEquals(6, actual);
	}
	
}
