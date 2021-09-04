package com.cg.main.exception;

public class PaymentOnHoldDueToWrongCardDetailException extends Exception{
	
	public PaymentOnHoldDueToWrongCardDetailException() {}
	
	public PaymentOnHoldDueToWrongCardDetailException(String msg)
	{
		super(msg);
	}
}
