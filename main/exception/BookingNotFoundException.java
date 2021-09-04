package com.cg.main.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends Exception{
public BookingNotFoundException(String msg) {
	super(msg);
}
}
