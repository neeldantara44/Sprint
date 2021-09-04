package com.cg.main.beans;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "card")
public class Card implements Serializable{
//	@OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "customer", referencedColumnName = "userId")
//	private Customer customer;
//	@OneToOne(mappedBy = "payment")
//	private Payment paymentId;
	@Column
	private String cardName;
	@Id
	private String cardNumber;
	@Column
	private LocalDate expiryDate;
	@Column
	private String bankName;
	@Column
	private Integer cvv;
	
	public Card() {}
	

//	public Card(Customer customer, String cardName, String cardNumber, LocalDate expiryDate, String bankName, Integer cvv) {
//		super();
//		this.customer = customer;
//		this.cardName = cardName;
//		this.cardNumber = cardNumber;
//		this.expiryDate = expiryDate;
//		this.bankName = bankName;
//		this.cvv = cvv;
//	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	public Card(Payment paymentId, String cardName, String cardNumber, LocalDate expiryDate, String bankName,
			Integer cvv) {
		super();
//		this.paymentId = paymentId;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankName = bankName;
		this.cvv = cvv;
	}

//	public Payment getPaymentId() {
//		return paymentId;
//	}
//
//
//	public void setPaymentId(Payment paymentId) {
//		this.paymentId = paymentId;
//	}
	
	public String getCardName() {
		return cardName;
	}
	
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

//	@Override
//	public String toString() {
//		return "Card [payment=" + paymentId + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expiryDate="
//				+ expiryDate + ", bankName=" + bankName + ", cvv=" + cvv + "]";
//	}

//	@Override
//	public String toString() {
//		return "\nCard [\nuserid=" + customer.getUserId() + ", \ncardName=" + cardName + ", \ncardNumber=" + cardNumber + ", \nexpiryDate=" + expiryDate
//				+ ", \nbankName=" + bankName + "\n]";
//	}
	
	
}
