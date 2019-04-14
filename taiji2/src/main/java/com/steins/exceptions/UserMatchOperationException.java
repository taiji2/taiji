package com.steins.exceptions;

public class UserMatchOperationException extends RuntimeException {
	private static final long serialVersionUID = -1512771573934050550L;
	
	public UserMatchOperationException(String msg) {
		super(msg);
	}
}
