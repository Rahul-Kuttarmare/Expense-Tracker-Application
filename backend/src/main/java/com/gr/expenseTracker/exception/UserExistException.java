package com.gr.expenseTracker.exception;

@SuppressWarnings("serial")
public class UserExistException extends RuntimeException {

	public UserExistException(String message)   
	{  
	super(message);  
	}
	public UserExistException(Error error) {
		super(error);
	}
}
