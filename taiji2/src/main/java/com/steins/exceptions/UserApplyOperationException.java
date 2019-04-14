package com.steins.exceptions;

public class UserApplyOperationException extends RuntimeException {
	private static final long serialVersionUID = -1512771573934050550L;
	
	public UserApplyOperationException(String msg) {
		super(msg);
	}
}
