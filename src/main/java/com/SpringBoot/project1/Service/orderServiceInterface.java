package com.SpringBoot.project1.Service;

import com.SpringBoot.project1.Entity.Orders;

import java.util.List;

public interface orderServiceInterface {
    public List<Orders> getAllOrders();
    public String addNewOrder();
    public String addListOfOrders( List<Orders> newOrders);
    public Orders getById(long id);
    public String deleteOrderById(Long id);
    public String updateOrder(Orders order, Long id);

}
