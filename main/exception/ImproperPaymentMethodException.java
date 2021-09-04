package com.cg.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ImproperPaymentMethodException extends Exception {

	
	public ImproperPaymentMethodException(String msg) {
		super(msg);
	
}
}