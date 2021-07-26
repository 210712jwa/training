package com.revature;

import com.revature.exception.InvalidKeyException;
import com.revature.exception.LockAlreadyLockedException;
import com.revature.exception.LockAlreadyUnlockedException;

public class Application {

	public static void main(String[] args) {
		
//		Lock lock = new Lock(314);
		
//		System.out.println(lock.isLocked());
//		System.out.println(lock.lock());
//		System.out.println(lock.unlock(100));
//		System.out.println(lock.unlock(314));
//		System.out.println(lock.isLocked());
		
		LockWithExceptions lock2 = new LockWithExceptions(101);

		try {
			lock2.unlock(101);
			lock2.lock();
			lock2.lock();
		} catch (LockAlreadyLockedException | LockAlreadyUnlockedException | InvalidKeyException e) {
			System.out.println("Exception " + e.getClass().getSimpleName() + " occurred");
		}
		
		System.out.println("Program does not crash, but continues execution after the catch block");
	}

}
