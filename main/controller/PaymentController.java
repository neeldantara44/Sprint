package com.cg.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.Payment;
import com.cg.main.service.IPaymentServiceImpl;

/*
 *  public void addPayment(Payment payment);
	public void removePayment(Long id);
	public void updatePayment(Long id, Payment payment);
	public Payment getPaymentDetails(Long id);
	public List<Payment> getAllPaymentDetails();
	
	{
    "paymentId" : 123456789,
    "orderId" : {
        "orderId" : 987654321,
        "amount" : 2500.0,
        "billingDate" : "2019-01-25T11:03:36Z",
        "PaymentMethod" : "online"
    },  
    "type" : "card",
    "status" : "processing",
    "card" : {
        "customer" : {
            "userId" : "himetta",
            "name" : "himanshi",
            "email" : "abc@xyz.com",
            "contactNo" : "123456789",
            "dob" : "2019-01-25T11:03:36Z"
        },
        "cardName" : "galaxy",
        "cardNumber" : "1234567890123456",
        "expiryDate" : "2007-12-03",
        "bankName" : "galactic",
        "cvv" : 123
    }
}

 * */



@RestController
@RequestMapping("/pay")
public class PaymentController {
		
	@Autowired
	private IPaymentServiceImpl ipsi;
	
	@PostMapping("/addPay")
	public Payment addPayment(@RequestBody Payment payment)
	{
		return ipsi.addPayment(payment);
	}
	
	@DeleteMapping("/deletePay/{id}")
	public Payment removePayment(@PathVariable Long id)
	{
		return ipsi.removePayment(id);
	}
	
	@PatchMapping("/updatePay/{id}")
	public Payment updatePayment(@PathVariable("id")Long id, @RequestBody Payment payment) 
	{
		return ipsi.updatePayment(id, payment);
	}
	
	@GetMapping("/getId/{id}")
	public Payment getPaymentDetails(@PathVariable Long id)
	{
		return ipsi.getPaymentDetails(id);
	}
	
	@GetMapping("/gapd")
	public List<Payment> getAllPaymentDetails()
	{
		return ipsi.getAllPaymentDetails();
	}
	
//	@GetMapping("/getEd")
//	public List<Payment> getExpiryDetails(@RequestBody LocalDate ld)
//	{
//		return ipsi.getPaymentByDate(ld);
//	}

}
