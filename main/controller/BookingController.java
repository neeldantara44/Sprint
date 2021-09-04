package com.cg.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.Booking;
import com.cg.main.service.IBookingServiceImpl;





@RestController
public class BookingController {
	@Autowired
	private IBookingServiceImpl bsi ;
	@PostMapping("/addb/{custId}")
	public void add(@PathVariable String custId, @RequestBody Booking b) {
	bsi.addBooking(custId, b);	
}
	@DeleteMapping("/removeb/{id}")
public void remove(@PathVariable long id) {
		bsi.removeBooking(id);
	
}
	@PutMapping("/updateb/{bookingId}")
public void update(@PathVariable Long bookingId, @RequestBody Booking booking) {
		bsi.updateBooking( bookingId, booking);
	
}
	@GetMapping("/getb/{id}")
public Booking get(@PathVariable Long id) {
	return bsi.getBookingDetails(id);
		
	
}
	@GetMapping("/getallb")
	public List<Booking> getAllBookings() {
			return bsi.getAllBookings();
		
	
}
//	{
//	    "bookingId": "13",
//	    "bookingDate": "2008-12-03",
//	    "bookingTime": "10:16:30",
//	    "serviceType": "b"
	//}
//	@GetMapping("/getbookingbydateb")
//	public void getBookingsByDate() {
//			return bsi.getBookingByDate(LocalDate id);
//		
//	}
	  
//	@GetMapping("/getbookingbydateb")
//	public List<Booking> getBookingsByDate(@RequestParam("ld") String ld) {
//		
//		  LocalDate localDate = LocalDate.parse(date, formatter);
//			return bsi.getBookingByDate(ld);
//		//	  LocalDate localDate = LocalDate.parse(date, formatter);
//			
//	}
}

//	@PostMapping("/getbookingbycustomerb")
//	public void getBookingsByCustomer(long customerId) {
//			bsi.getBookingsByCustomer(customerId);
//		
//	}
