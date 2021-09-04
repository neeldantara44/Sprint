package com.cg.main.service;

import java.util.List;

import com.cg.main.beans.Item;


public interface ICustomerItemServiceIntf {

	public Item addItem(Item item);
	public Item removeItem(Long id);
	public Item updateItem(Long id, Item item);
	public Item getItem(Long id);
	//public List<Item> getItemsByCustomer(Long customerId);
}
