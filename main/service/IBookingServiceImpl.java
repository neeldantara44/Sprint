package com.cg.main.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.Collectors;
import com.cg.main.beans.Booking;
import com.cg.main.exception.BookingDetailsNotFoundException;
import com.cg.main.exception.BookingNotFoundException;
import com.cg.main.repository.IBookingRepositoryIntf;
@Service
public class IBookingServiceImpl implements IBookingServiceIntf {


	@Autowired
	private IBookingRepositoryIntf bookingrepository;
//	@Autowired
//	private ICustomerServiceImpl icsi;

	public Booking addBooking(Booking booking) {
		/*
   	 Customer customer2 = icsi.getCustomer(userId);
           Booking order1= new Booking();
           order1.setOrderId(order.getOrderId());
           
//         System.out.println(customer2);
           order1.setBillingDate(order.getBillingDate());
           order1.setAmount(order.getAmount());
           order1.setPaymentMethod(order.getPaymentMethod());
           order1.setCustomer(order.getCustomer());
           
           return orderrepository.saveAndFlush(order1);
   	 * */
		return bookingrepository.saveAndFlush(booking);
		
	}




//	public Booking removeBooking(long bookingId) {
//		 bookingrepository.deleteById(bookingId);
//		return null;
//		
//		
//	}
	@Override
	public Booking removeBooking(long bookingId) {
		Booking retrievedBookingVal=null;
		try {
			 retrievedBookingVal=bookingrepository.findById(bookingId).orElseThrow(()-> new BookingNotFoundException("booking details not found"));
			 bookingrepository.deleteById(bookingId);
			 return retrievedBookingVal;
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			return null;
			}
		}

	public void updateBooking(Long bookingId, Booking booking) {
		/*
	   	 Customer customer2 = icsi.getCustomer(userId);
	           Booking order1= new Booking();
	           order1.setOrderId(order.getOrderId());
	           
//	         System.out.println(customer2);
	           order1.setBillingDate(order.getBillingDate());
	           order1.setAmount(order.getAmount());
	           order1.setPaymentMethod(order.getPaymentMethod());
	           order1.setCustomer(order.getCustomer());
	           
	           return orderrepository.saveAndFlush(order1);
	   	 * */
		bookingrepository.deleteById(bookingId);
		bookingrepository.saveAndFlush(booking);
		
	}

	

//	public Booking getBooking(Long bookingId) {
//		// TODO Auto-generated method stub
//		return bookingrepository.findById(bookingId).get();
//	}
	public Booking getBookingDetails(Long bookingId) {
		// TODO Auto-generated method stub
		try
		{
			return bookingrepository.findById(bookingId).orElseThrow(() -> new BookingDetailsNotFoundException("booking detail not found!"));			
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}



	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingrepository.findAll();
	}
//	public List<Booking> getBookingsByDate() {
//		// TODO Auto-generated method stub

//	}
//	public List<Booking> getBookingByDate(LocalDate ld)
//	{
//		ArrayList<Booking> allDetails = (ArrayList<Booking>) bookingrepository.findAll();
//		List<Booking> acceptedTypes = allDetails.
//									  stream().
//									  filter(ad -> ad.getBookingDate().compareTo(ld) == 0).
//									  collect(Collectors.toList());
//		return acceptedTypes;
//	}
//



	



//
//@Override
//public Booking getBooking(Long bookingId) {
//	// TODO Auto-generated method stub
//	return null;
//}

//	
//	
//	public List<Booking> getBookingsByCustomer(long customerId) {
//		// TODO Auto-generated method stub
//		return bookingrepository.getBookingsByCustomer(customerId);
//	}
//	


}
