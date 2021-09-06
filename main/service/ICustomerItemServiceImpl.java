package com.cg.main.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.beans.Booking;
import com.cg.main.beans.Item;
import com.cg.main.exception.ItemDetailsNotFoundException;
import com.cg.main.exception.ItemNameEmptyException;
import com.cg.main.repository.ICustomerItemRepositoryIntf;



@Service

public class ICustomerItemServiceImpl implements ICustomerItemServiceIntf{

	@Autowired
	private ICustomerItemRepositoryIntf itemrepository;
	@Autowired
	private IBookingServiceImpl bsi;
	
	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		 /*
   	 Customer customer2 = icsi.getCustomer(userId);
           Item order1= new Item();
           order1.setOrderId(order.getOrderId());
           
//         System.out.println(customer2);
           order1.setBillingDate(order.getBillingDate());
           order1.setAmount(order.getAmount());
           order1.setPaymentMethod(order.getPaymentMethod());
           order1.setCustomer(order.getCustomer());
           
           return orderrepository.saveAndFlush(order1);
   	    */
		try {
			if(item.getName().isEmpty() || item.getName().length()==0) {
				throw new ItemNameEmptyException("Item name is Empty, Please provide proper item name");
			}
			return itemrepository.saveAndFlush(item);
		}catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
		 
		
	}
	
	public Item removeItem(Long id) {
		// TODO Auto-generated method stub
		//itemrepository.deleteById(id);
		Item retrievedItemVal = null;
		try
		{
			retrievedItemVal = itemrepository.findById(id).orElseThrow(() -> new ItemDetailsNotFoundException("Item detail not found!"));
			itemrepository.deleteById(id);
			return retrievedItemVal;
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
		
	}

	
	public Item updateItem(Long id, Item item) {
		// TODO Auto-generated method stub
		/*
	   	 Customer customer2 = icsi.getCustomer(userId);
	           Item order1= new Item();
	           order1.setOrderId(order.getItemId());
	           
//	         System.out.println(customer2);
	           order1.setBillingDate(order.getBillingDate());
	           order1.setAmount(order.getAmount());
	           order1.setPaymentMethod(order.getPaymentMethod());
	           order1.setCustomer(order.getCustomer());
	           
	           return orderrepository.saveAndFlush(order1);
	   	*/
		
		//itemrepository.deleteById(id);
		//itemrepository.saveAndFlush(item);
		//itemrepository.findById(id).get().UpdateIold(item.getItemId(),item.getName(),item.getColor(),item.getCategory(),item.getQuantity(),item.getMaterial(),item.getDescription());
		Item retrievedItemVal = null;
		try {
		retrievedItemVal  = itemrepository.findById(id).orElseThrow(() -> new ItemDetailsNotFoundException("Item detail not found!"));
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		retrievedItemVal.UpdateIold(item.getName(),item.getColor(),item.getCategory(),item.getQuantity(),item.getMaterial(),item.getDescription());
		Item updatedItemVal=null;
	
		updatedItemVal = itemrepository.save(retrievedItemVal);
		return updatedItemVal;
	}

	
	public Item getItem(Long id) {
		// TODO Auto-generated method stub
		return itemrepository.findById(id).get();
	}

	
	public List<Item> getItemsByCustomer(String customerId) {
		// TODO Auto-generated method stub
		List<Booking> b_list = bsi.getAllBookings();
		for(Booking b : b_list)
		{
			if(b.getCustomerDetails().getUserId().compareToIgnoreCase(customerId) == 0)
			{
				return b.getItem();
			}
			else
			{
				return null;
			}
		}
		return null;
	}
}

