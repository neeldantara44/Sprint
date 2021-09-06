package com.cg.main.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;




@Entity
@Table
public class Item {
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="bookingId",referencedColumnName="bookingId")
	private Booking bookingId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	@Column
	private String name;
	@Column
	private String color;
	@Column
	private String category;
	@Column
	private Integer quantity;
	@Column
	private String material;
	@Column
	private String description;
	
	public Item() {}

//	public Item(Long itemId, @NotNull(message="Name should not be empty") String name, @NotNull(message="Color should not be empty")String color,String category,@NotNull(message="Quantity should not be empty")Integer quantity,String material,String description) {
//	this.itemId=itemId;
//	this.name=name;
//	this.color=color;
//	this.quantity = quantity;
//	this.material = material;
//	this.description = description;
//	}
	
	public Item(Long itemId, String name, String color, String category, Integer quantity, String material, String description) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.material = material;
		this.description = description;
	}


	public void UpdateIold( String name, String color, String category, Integer quantity, String material,
	String description) {
	
		this.name = name;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.material = material;
		this.description = description;
	}
	
	public Booking getBookingId() {
		return bookingId;
	}

	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", color=" + color + ", category=" + category
				+ ", quantity=" + quantity + ", material=" + material + ", description=" + description + "]";
	}

	
	/*public Customer getUserId() {
		return userId;
	}

	public void setUserId(Customer userId) {
		this.userId = userId;
	}*/

	
	
	
	

}

