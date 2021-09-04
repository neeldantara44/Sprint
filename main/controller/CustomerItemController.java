package com.cg.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.Item;
import com.cg.main.service.ICustomerItemServiceImpl;
import com.cg.main.service.ICustomerServiceImpl;

/*
public void addItem(Item item);
public void removeItem(Long id); 
public void updateItem(Long id,CustomerItem item);
public Item getItem(Long id);
public List<Item> getItemsByCustomer();

{

	"name" : "malini",
	"color" : "Blue",
	"category" : "chudidhar",
	"quantity" : 2,
	"material" : "cotton",
	"description" : "xyz"
}

{
	"name" : "achutha",
	"color" : "black",
	"category" : "pant",
	"quantity" : 3,
	"material" : "cotton",
	"description" : "pqr"
}

{
	"name" : "srigowri",
	"color" : "purple",
	"category" : "saree",
	"quantity" : 3,
	"material" : "silk",
	"description" : "abc"
}

{
	"name" : "shreelakshmi",
	"color" : "pink",
	"category" : "t-shirt",
	"quantity" : 3,
	"material" : "nylon",
	"description" : "mno"
}

*/


@RestController
@RequestMapping("/item")
public class CustomerItemController {
	
	@Autowired
	private ICustomerItemServiceImpl cis;
	
	@PostMapping("/addItem")
	/*public void addItem(@RequestBody Item item) {
		 cis.addItem(item);
	}*/
	
	
	public Item addItem(@RequestBody Item item) {
		return cis.addItem(item);
	}
	
	@DeleteMapping("/removeItem/{id}")
	public void removeItem(@PathVariable Long id) {
		cis.removeItem(id);
	}
	
	@PutMapping("/updateItem/{id}")
	public Item updateItem(@PathVariable Long id,@RequestBody Item item) {
		return cis.updateItem(id, item);
	}
	
	@GetMapping(value="/getItem/{id}")
	public Item getItem(@PathVariable Long id) {
		return cis.getItem(id);
	}
	
	
}
