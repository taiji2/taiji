package com.steins.exceptions;

public class GameApplyOperationException extends RuntimeException {
	private static final long serialVersionUID = -1512771573934050550L;
	
	public GameApplyOperationException(String msg) {
		super(msg);
	}
}
