package com.revature;

public class NoElementException extends RuntimeException {

	public NoElementException() {
		super();
	}

	public NoElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoElementException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoElementException(String message) {
		super(message);
	}

	public NoElementException(Throwable cause) {
		super(cause);
	}

}
