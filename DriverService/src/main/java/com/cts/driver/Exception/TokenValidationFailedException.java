package com.cts.driver.Exception;

public class TokenValidationFailedException extends RuntimeException {
	String message;

	public TokenValidationFailedException() {
		super();
		// TODO Auto-generated constructor stub
			}

			public TokenValidationFailedException(String message, Throwable cause) {
				super(message, cause);
				// TODO Auto-generated constructor stub
			}

			public TokenValidationFailedException(Throwable cause) {
				super(cause);
				// TODO Auto-generated constructor stub
			}

			public TokenValidationFailedException(String message) {
				super();
				this.message = message;
			}

		}

