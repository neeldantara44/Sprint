package com.cg.main.exception;

public class WrongCardDetailException extends Exception{
	
	public WrongCardDetailException(){}
	
	public WrongCardDetailException(String msg)
	{
		super(msg);
	}
}
