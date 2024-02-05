package com.cg.bsappl.exception;

public class TransactionException extends Exception{

	public TransactionException() {
		super();
		
	}

	public TransactionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public TransactionException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public TransactionException(String message) {
		super(message);
		System.out.println(message);
	}

	public TransactionException(Throwable cause) {
		super(cause);
		
	}

}
