package com.revature.exception;

public class DenominatorIsZeroException extends Exception {
	// If I extend RuntimeException, I am creating an unchecked exception
	// If I extend Exception, I am creating a checked exception
	
	public DenominatorIsZeroException() {
		super();
	}

	public DenominatorIsZeroException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DenominatorIsZeroException(String message, Throwable cause) {
		super(message, cause);
	}

	public DenominatorIsZeroException(String message) {
		super(message);
	}

	public DenominatorIsZeroException(Throwable cause) {
		super(cause);
	} 
	
}
