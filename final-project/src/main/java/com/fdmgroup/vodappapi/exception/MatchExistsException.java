package com.fdmgroup.vodappapi.exception;

public class MatchExistsException extends Exception{

	private static final long serialVersionUID = -7329731083612146267L;
	
	public MatchExistsException(String message) {
		super(message);
	}

}
