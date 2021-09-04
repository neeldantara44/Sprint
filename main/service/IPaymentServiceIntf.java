package com.cg.main.service;

import java.util.List;

import com.cg.main.beans.Payment;

public interface IPaymentServiceIntf {
	public Payment addPayment(Payment payment);
	public Payment removePayment(Long id);
	public Payment updatePayment(Long id, Payment payment);
	public Payment getPaymentDetails(Long id);
	public List<Payment> getAllPaymentDetails();
}
