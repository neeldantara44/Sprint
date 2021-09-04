package com.cg.main.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.beans.Card;
import com.cg.main.beans.Payment;
import com.cg.main.exception.CardExpiredException;
import com.cg.main.exception.PaymentDetailsNotFoundException;
import com.cg.main.exception.PaymentOnHoldDueToWrongCardDetailException;
import com.cg.main.exception.WrongCardDetailException;
import com.cg.main.repository.IPaymentRepositoryIntf;

//add the repository class's object and then use their object.method()
@Service
public class IPaymentServiceImpl implements IPaymentServiceIntf{

	@Autowired
	private IPaymentRepositoryIntf payrepository;
	
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		if(payment.getType().compareToIgnoreCase("offline") == 0)
		{
			//System.out.println("on comparing value "+payment.getType().compareToIgnoreCase("offline"));
			payment.setStatus("successful");
			payrepository.saveAndFlush(payment);
			System.out.println("1 "+payment);
			return payment;
		}
		try 
		{
			Card flag_card = checkCardDetails(payment.getCard());
			if(flag_card == null)
			{
				throw new PaymentOnHoldDueToWrongCardDetailException("Payment on hold due to incorrect card values!\nUpdate card values again!!");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			payment.setStatus("on hold");
			payment.setType("online");
			payment.setCard(null);
			payrepository.saveAndFlush(payment);
			System.out.println("2 "+payment);
			return payment;
		}
		payment.setType("online");
		payment.setStatus("successful");
		payrepository.saveAndFlush(payment);
		System.out.println("3 "+payment);
		return payment;
	}

	public Payment removePayment(Long id) {
		// TODO Auto-generated method stub
		Payment retrievedPaymentVal = null;
		try
		{
			retrievedPaymentVal = payrepository.findById(id).orElseThrow(() -> new PaymentDetailsNotFoundException("Payment detail not found!"));			
			payrepository.deleteById(id);
			return retrievedPaymentVal;
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}

	public Payment updatePayment(Long id, Payment payment) {
		// TODO Auto-generated method stub
		Payment retrievedPaymentVal = null;
		Payment updatedPayment = null;
		try
		{			
			retrievedPaymentVal  = payrepository.findById(id).orElseThrow(() -> new PaymentDetailsNotFoundException("Payment detail not found!"));
			//checking if the payment is already successful or not
			//System.out.println("successful : "+retrievedPaymentVal.getStatus()+" "+(payment.getStatus() == "successful"));
			if(retrievedPaymentVal.getStatus().compareToIgnoreCase("successful") == 0)
			{
				System.out.println("Update option not valid for successful transactions.");
				System.out.println(retrievedPaymentVal);
				return retrievedPaymentVal;
			}
			else
			{
				retrievedPaymentVal.setStatus("processing");
			}
			retrievedPaymentVal.setType("online");
			retrievedPaymentVal.setCard(checkCardDetails(payment.getCard()));
			if(checkCardDetails(payment.getCard()) != null)
			{
				retrievedPaymentVal.setStatus("successful");
			}
			else
			{
				retrievedPaymentVal.setStatus("on hold");
			}
			updatedPayment = payrepository.save(retrievedPaymentVal);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e.toString());
		}
		System.out.println(updatedPayment);
		return updatedPayment;
	}

	public Payment getPaymentDetails(Long id) {
		// TODO Auto-generated method stub
		try
		{
			return payrepository.findById(id).orElseThrow(() -> new PaymentDetailsNotFoundException("Payment detail not found!"));			
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}

	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		return payrepository.findAll();
	}
	
	public Card checkCardDetails(Card card)
	{
		Card correct_card = new Card();
		LocalDate now = LocalDate.now();
		try
		{
			//for card name no check
			correct_card.setCardName(card.getCardName());
			
			//for card number there is a check
			if(card.getCardNumber().length()!=16 || isNotNumeric(card.getCardNumber()))
			{
				//System.out.println(card.getCardNumber().length());
				//System.out.println(isNotNumeric(card.getCardNumber()));
				throw new WrongCardDetailException("Card Number is incorrect!");
			}
			else correct_card.setCardNumber(card.getCardNumber());
			
			//for expiry date there is a check
			if(card.getExpiryDate().isBefore(now))
			{
				throw new CardExpiredException("Your card has expired!");
			}
			else correct_card.setExpiryDate(card.getExpiryDate());
			
			//for bank name there is no check
			correct_card.setBankName(card.getBankName());
			
			//for cvv there is a check
			if(String.valueOf(card.getCvv()).length() != 3)
			{
				throw new WrongCardDetailException("Card cvv is incorrect!");
			}
			else correct_card.setCvv(card.getCvv());
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
		
		return correct_card;
	}
	
	public static boolean isNotNumeric(String str) { 
		  try {  
		    Long.parseLong(str); 
		    return false;
		  } catch(NumberFormatException e){  
			System.out.println(e.toString());
		    return true;  
		  }  
		}
	
	
	
//	public List<Payment> getPaymentByDate(LocalDate ld)
//	{
//		ArrayList<Payment> allDetails = (ArrayList<Payment>) payrepository.findAll();
//		List<Payment> acceptedTypes = allDetails.
//									  stream().
//									  filter(ad -> ad.getCard().getExpiryDate().compareTo(ld) == 0).
//									  collect(Collectors.toList());
//		return acceptedTypes;
//	}

}
