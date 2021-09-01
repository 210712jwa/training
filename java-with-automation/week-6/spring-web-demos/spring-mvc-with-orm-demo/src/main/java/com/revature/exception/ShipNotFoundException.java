package com.revature.exception;

public class ShipNotFoundException extends Exception {

	public ShipNotFoundException() {
	}

	public ShipNotFoundException(String message) {
		super(message);
	}

	public ShipNotFoundException(Throwable cause) {
		super(cause);
	}

	public ShipNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShipNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
