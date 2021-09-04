package com.cg.main.beans;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookingId;
	@Column
	private LocalDate bookingDate;
	@Column
	private LocalTime bookingTime;
	@Column
	private String serviceType;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", referencedColumnName = "id")
	private Customer customerDetails;
//	@OneToMany(mappedBy="customerItem")
//  @JoinColumn(name = "bookingId")
//	private Set <CustomerItem> oSet;
	
	public Booking() {}
	
	public Booking(Long bookingId,LocalDate bookingDate,LocalTime bookingTime,String serviceType,Customer customerDetails) {
		super();
		this.bookingId= bookingId;
		this.bookingDate= bookingDate;
		this.bookingTime= bookingTime;
		this.serviceType= serviceType;
		this.customerDetails= customerDetails;
	}

	public Customer getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalTime getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	
//	public Customer getCustomerDetails() {
//		return customerDetails;
//	}
//	public void setCustomerDetails(Customer customerDetails) {
//		this.customerDetails = customerDetails;
//	}
//	
//	
//	public Set<CustomerItem> getoSet() {
//		return oSet;
//	}
//	public void setoSet(Set<CustomerItem> oSet) {
//		this.oSet = oSet;
//	}
//	@Override
//	public String toString() {
//		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime
//				+ ", serviceType=" + serviceType + ", customerDetails=" + customerDetails + "]";
//	}
//	
//	
	

}
