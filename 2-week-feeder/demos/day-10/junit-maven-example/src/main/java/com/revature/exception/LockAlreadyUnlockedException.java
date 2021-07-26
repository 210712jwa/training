package com.revature.exception;

public class LockAlreadyUnlockedException extends Exception {

	public LockAlreadyUnlockedException() {
	}

	public LockAlreadyUnlockedException(String message) {
		super(message);
	}

	public LockAlreadyUnlockedException(Throwable cause) {
		super(cause);
	}

	public LockAlreadyUnlockedException(String message, Throwable cause) {
		super(message, cause);
	}

	public LockAlreadyUnlockedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
