package com.revature;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MathTest {

	@Test
	public void testIsEven_for_number_12() {
		Math math = new Math();
		
		assertTrue(math.isEven(12));
	}
	
}
