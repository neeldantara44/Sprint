package com.cg.main.service;

 


import java.util.List;

 
/*
 {
 "orderId" : 123,
 "amount": 2510.56,
 "billingDate": "2020-08-31",
 "paymentMethod":{
    "type" : "online",
    "card" : {
        "cardName" : "galaxy",
        "cardNumber" : "1234567890165456",
        "expiryDate" : "2027-12-03",
        "bankName" : "galactic",
        "cvv" : 123
        }
    }
}
 * */
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cg.main.exception.OrderNotFoundException;
import com.cg.main.exception.PaymentMethodEmptyException;

import com.cg.main.beans.Order;
import com.cg.main.beans.Payment;
import com.cg.main.exception.ImproperPaymentMethodException;
import com.cg.main.repository.IOrderRepositoryIntf;
import com.cg.main.repository.IPaymentRepositoryIntf;

 

@Service
public class IOrderServiceImpl implements IOrderServiceIntf {
    
    @Autowired
    private IOrderRepositoryIntf orderrepository;
//  @Autowired
//	private ICustomerServiceImpl icsi;
    @Autowired
    private IPaymentServiceImpl ipsi;
    
    @Override
	public Order addOrder(Order order) {
    	/*
    	 Customer customer2 = br.getCustomer(userId);
            Order order1= new Order();
            order1.setOrderId(order.getOrderId());
            
//            System.out.println(customer2);
            order1.setBillingDate(order.getBillingDate());
            order1.setAmount(order.getAmount());
            order1.setPaymentMethod(order.getPaymentMethod());
            order1.setCustomer(order.getCustomer());
            
            return orderrepository.saveAndFlush(order1);
    	 * */
		Order order1 = new Order();
		order1.setOrderId(order.getOrderId());
		order1.setAmount(order.getAmount());
		order1.setBillingDate(order.getBillingDate());
		order1.setPaymentMethod(ipsi.addPayment(order.getPaymentMethod()));
		return orderrepository.save(order1);
	}
//		if(order.getPaymentMethod().compareToIgnoreCase("offline")==0||order.getPaymentMethod().compareToIgnoreCase("online")==0)
//		{
//			orderrepository.saveAndFlush(order);
//			return order;
//		}
//		try {
//			(order.getPaymentMethod().compareToIgnoreCase("offline")!=0||order.getPaymentMethod().compareToIgnoreCase("online")!=0)
//		};
//		throw new ImproperPaymentMethodException("Payment method improper");
//	}
		
	

	@Override
	public Order removeOrder(Long orderId) {
		Order retrievedOrderVal=null;
		try {
			retrievedOrderVal=orderrepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException("Order details not found"));
			 orderrepository.deleteById(orderId);
			 return retrievedOrderVal;
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			return null;
			}
		}
		 


	@Override
	public Order updateOrder(Long orderId,Order order) {	
		/*
		 Customer customer2 = br.getCustomer(userId);
            Order order1= new Order();
            order1.setOrderId(order.getOrderId());
            
//            System.out.println(customer2);
            order1.setBillingDate(order.getBillingDate());
            order1.setAmount(order.getAmount());
            order1.setPaymentMethod(order.getPaymentMethod());
            order1.setCustomer(order.getCustomer());
            
            return orderrepository.saveAndFlush(order1);
		  */
		Order pid1 = orderrepository.findById(orderId).get();
		Payment pid2 = pid1.getPaymentMethod();
		Long pid3 = pid2.getPaymentId();
		System.out.println("PaymentId : "+pid3);
		 orderrepository.deleteById(orderId);
		 Order order1 = new Order();
			order1.setOrderId(orderId);
			order1.setAmount(order.getAmount());
			order1.setBillingDate(order.getBillingDate());
			order1.setPaymentMethod(ipsi.updatePayment(pid3, order.getPaymentMethod()));
			return orderrepository.saveAndFlush(order1);
//		 orderrepository.saveAndFlush(order);
//		orderrepository.findById(orderId).get().UpdateWold(order.getAmount(),order.getBillingDate(),order.getPaymentMethod());
					
	}

	@Override
	public Order getOrderDetails(Long orderId) {
		try {
			return orderrepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException("Order details not found!"));
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			return null;
		}
		// return orderrepository.findById(orderId).get();
	}

	@Override
	public List<Order> getAllOrders() {
		
		return orderrepository.findAll() ;
	}
	public static boolean isNotNumeric(String str) {
		try {
			Long.parseLong(str);
			return false;
		}
		catch(NumberFormatException e) {
			System.out.println(e.toString());
			return true;
		}
	}   
        }