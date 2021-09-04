package com.cg.main.exception;

public class PaymentDetailsNotFoundException extends Exception{
	PaymentDetailsNotFoundException() {}
	
	public PaymentDetailsNotFoundException(String msg)
	{
		super(msg);
	}
}
