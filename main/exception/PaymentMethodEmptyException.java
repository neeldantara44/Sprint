package com.cg.main.exception;

public class PaymentMethodEmptyException extends Exception{
	public PaymentMethodEmptyException() {};
	
	public PaymentMethodEmptyException(String msg)
	{
		super(msg);
	}
}
