package com.cg.bsappl.exception;

public class AccountException extends Exception{

	public AccountException() {
		super();
		
	}

	public AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountException(String message) {
		super(message);
		System.out.println(message);
	}

	public AccountException(Throwable cause) {
		super(cause);
		
	}

}
