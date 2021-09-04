package com.cg.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.beans.Booking;




public interface IBookingServiceIntf { 
	public Booking addBooking(Booking booking);
	public Booking removeBooking(long bookingId);
	public void updateBooking(Long bookingId, Booking booking);
	public Booking getBookingDetails(Long bookingId);
	public List<Booking> getAllBookings();
	//public List<Booking> getBookingsByDate();
	//public List<Booking> getBookingsByCustomer(long customerId);
}
