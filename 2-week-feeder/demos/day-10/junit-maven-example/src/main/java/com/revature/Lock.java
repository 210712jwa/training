package com.revature;

public class Lock {

	private int secretKey;
	private boolean isLocked;
	
	public Lock(int secretKey) {
		this.isLocked = true;
		this.secretKey = secretKey;
	}
	
	// This method returns false if lock was not successfully locked and true if it was
	public boolean lock() {
		if (isLocked) { // check to see if the lock is already locked
			return false;
		}
		
		this.isLocked = true;
		return true;
	}
	
	public boolean unlock(int key) {
		if (!isLocked) {
			return false; // If the lock is already unlocked, we can't unlock the lock
		}
		
		if (this.secretKey == key) {
			this.isLocked = false;
			return true;
		}
		
		return false;
	}
	
	// getter method
	public boolean isLocked() {
		return this.isLocked;
	}
	
}
