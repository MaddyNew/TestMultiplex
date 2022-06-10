package com.micro.multiplex.exception;

public class ScreenLimitExtendedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ScreenLimitExtendedException(String errorMessage)
	{
	         super(errorMessage);
	}
}
