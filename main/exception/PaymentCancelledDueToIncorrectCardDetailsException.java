package com.cg.main.exception;

public class PaymentCancelledDueToIncorrectCardDetailsException extends Exception{
	public PaymentCancelledDueToIncorrectCardDetailsException() {}
	
	public PaymentCancelledDueToIncorrectCardDetailsException(String msg)
	{
		super(msg);
	}
}
