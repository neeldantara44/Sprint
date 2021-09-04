package com.cg.main.beans;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
//	@OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "orderId", referencedColumnName = "orderId")
//	private Order orderId;
	@Column
	private String type;
	@Column
	private String status;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "card", referencedColumnName = "cardNumber")
	private Card card;
	
	public Payment() {}

//	public Payment(Long paymentId, Order orderid, String type, String status, Card card) {
//		super();
//		this.paymentId = paymentId;
//		this.orderId = orderid;
//		this.type = type;
//		this.status = status;
//		this.card = card;
//	}
	
	public Payment(Long paymentId, String type, Card card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.card = card;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

//	public Order getOrderid() {
//		return orderId;
//	}
//
//	public void setOrderid(Order orderid) {
//		this.orderId = orderid;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "\nPayment [\npaymentId=" + paymentId + ", \ntype=" + type + ", \nstatus=" + status + ", \ncard=" + card;
	}
	
}
