package com.cg.main.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;


@Entity
@Table

public class Customer {
	@Id
    @Column(name="id")
	private String userId;
	
	@Column
	@NotEmpty(message="Name is Required")
	private String name;
	
	@Column
	@NotEmpty(message="Email ID can't be empty")
    @Size(min=2, max=30, message="Enter Valid Email ID ")
    @Email(message="Enter Valid Email ID Format!")
	private String email;
	
	@Column
	@NotEmpty(message="Contact Number Required! it can't be empty")
    @Size(min=10, max=12, message="Invalid Contact Number! Enter Valid Number")
	private String contactNo;
	
	@Column
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address",referencedColumnName = "id")
    private Address address;
		
	//private Order order;
	
	public Customer() {}
	
	public Customer(String userId, String name, String email, String contactNo, LocalDate dob, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + "]";
	}

}
