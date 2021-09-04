package com.cg.main.service;
import java.util.List;

 

import com.cg.main.beans.Order;

public interface IOrderServiceIntf {
    public Order addOrder(String custId, Order order);
    public  Order removeOrder(Long orderId) ;
    public Order updateOrder(Long orderId,Order order);
    public Order getOrderDetails(Long orderId);
    public List<Order> getAllOrders();
}

