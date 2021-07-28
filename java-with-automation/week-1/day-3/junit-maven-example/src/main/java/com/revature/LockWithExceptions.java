package com.revature;

import com.revature.exception.InvalidKeyException;
import com.revature.exception.LockAlreadyLockedException;
import com.revature.exception.LockAlreadyUnlockedException;

public class LockWithExceptions {

	private int secretKey;
	private boolean isLocked;
	
	public LockWithExceptions(int secretKey) {
		this.isLocked = true;
		this.secretKey = secretKey;
	}
	
	// This method returns false if lock was not successfully locked and true if it was
	public void lock() throws LockAlreadyLockedException {
		if (isLocked) { // check to see if the lock is already locked
			throw new LockAlreadyLockedException();
		}
		
		this.isLocked = true;
	}
	
	public void unlock(int key) throws LockAlreadyUnlockedException, InvalidKeyException {
		if (!isLocked) {
			throw new LockAlreadyUnlockedException();
		}
		
		if (this.secretKey != key) {
			throw new InvalidKeyException();
		}
		
		this.isLocked = false;
	}
	
	// getter method
	public boolean isLocked() {
		return this.isLocked;
	}
	
}
