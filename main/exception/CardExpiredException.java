package com.cg.main.exception;

public class CardExpiredException extends Exception{
	public CardExpiredException() {}
	
	public CardExpiredException(String msg)
	{
		super(msg);
	}
}
