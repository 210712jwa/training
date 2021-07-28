package com.revature;

import org.junit.Before;
import org.junit.Test;

import com.revature.exception.InvalidKeyException;
import com.revature.exception.LockAlreadyLockedException;
import com.revature.exception.LockAlreadyUnlockedException;

public class LockWithExceptionsTest {

	private LockWithExceptions lock;
	
	@Before
	public void setUp() throws Exception {
		lock = new LockWithExceptions(100);
	}

	// Positive Test
	// If we encounter any exceptions, it will fail our test
	// But here we are not expecting any exception to be thrown, so it SHOULD pass (theoretically)
	@Test
	public void testUnlock_correctKey() throws LockAlreadyUnlockedException, InvalidKeyException {
		lock.unlock(100);
	}
	
	// Negative test
	@Test(expected = InvalidKeyException.class)
	public void testUnlock_incorrectKey() throws LockAlreadyUnlockedException, InvalidKeyException {
		lock.unlock(302);
	}
	
	@Test(expected = LockAlreadyUnlockedException.class)
	public void testUnlock_lockAlreadyUnlocked() throws LockAlreadyUnlockedException, InvalidKeyException {
		lock.unlock(100);
		
		lock.unlock(100);
	}
	
	@Test(expected = LockAlreadyLockedException.class)
	public void testLock_lockAlreadyLocked() throws LockAlreadyLockedException {
		lock.lock();
	}
	
	@Test
	public void testLock_lockUnlocked() throws LockAlreadyLockedException, LockAlreadyUnlockedException, InvalidKeyException {
		lock.unlock(100);
		
		lock.lock();
	}
}
