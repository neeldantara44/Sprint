package com.cg.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.main.beans.Payment;

@Repository
public interface IPaymentRepositoryIntf  extends JpaRepository<Payment, Long>{
	
}
