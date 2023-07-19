package com.masai.exception;

public class SomethingWentWrongException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public SomethingWentWrongException(String message) {
		super(message);
	}
}
