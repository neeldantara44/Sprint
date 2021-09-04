package com.cg.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.main.beans.Order;

public interface IOrderRepositoryIntf extends JpaRepository<Order, Long>{

}
