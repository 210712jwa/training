package com.revature;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LockTest {

	private Lock lock;
	
	// Notice how the method here annotated with @BeforeClass is a static method
	// This method runs before ANY tests run. We might specify or start up various resources in this section
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		System.out.println("setUpBeforeClass() invoked");
	}

	// Notice how the method here annotated with @AfterClass is a static method
	// This method runs after ALL tests have run. You might close your resources here that were being used
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		System.out.println("tearDownAfterClass() invoked");
	}

	// Notice that this is a non-static method
	// This method will run BEFORE EVERY test
	@Before
	public void setUp() throws Exception {
//		System.out.println("setUp() invoked");
		lock = new Lock(100); // Before every single test, use a brand new lock w/ a secret key of 100
	}

	// Notice that this is a non-static method
	// This method will run AFTER EVERY test
	@After
	public void tearDown() throws Exception {
//		System.out.println("tearDown() invoked");
	}

	/*
	 * Tests
	 * 
	 * As a generalization, there are two different types of tests at a very high level:
	 * 1.) Positive Tests: This is where something intended occurred
	 * 2.) Negative Tests: This is where we test for unintended use
	 * 
	 * We can break down tests into different categories
	 * 1.) Unit Tests: This is currently what we are looking at. Unit tests isolate individual pieces of code
	 * 					Such as most commonly methods, and ONLY focusing on the logic inside of that method
	 * 2.) Integration Tests: This is where you combine multiple different units together into a more comprehensive test
	 * 					You are "integrating" different components together and making sure that they all work in tandem
	 * 					for each test
	 * 3.) End to End Tests (E2E Tests)
	 */
	
	// Positive test, because we're testing for the intended use of a lock, which is to provide the correct key
	// In order to unlock the lock
	@Test
	public void testUnlock_withCorrectKey() {
		assertTrue(lock.unlock(100));
	}
	
	// Negative test, because we're testing for unintended use of a lock, which is providing an incorrect key
	@Test
	public void testUnlock_withIncorrectKey() {
		for (int i = -999; i <= 999; i++) {
			if (i == 100) continue;
			
			assertFalse(lock.unlock(i));
		}
	}
	
	@Test
	public void testUnlock_lockAlreadyUnlocked() {
		lock.unlock(100);
		
		assertFalse(lock.unlock(100)); // Shouldn't be able to unlock if already unlocked
	}
	
	@Test
	public void testLock_lockAlreadyLocked() {
		// by default, the lock object is already locked
		
		assertFalse(lock.lock());
	}
	
	@Test
	public void testLock_lockUnlocked() {
		lock.unlock(100);
		
		assertTrue(lock.lock());
	}
}
