package com.vehicle.exception;

public class TokenValidationException extends RuntimeException {
	private String message;

	public TokenValidationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TokenValidationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TokenValidationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TokenValidationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public TokenValidationException(String message) {
		super();
		this.message = message;
	} 
	
}
