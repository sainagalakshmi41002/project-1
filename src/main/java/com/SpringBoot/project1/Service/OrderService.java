package com.SpringBoot.project1.Service;

import com.SpringBoot.project1.Entity.Orders;
import com.SpringBoot.project1.Repository.OrdersJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersJpa ordersJpa;

    public List<Orders> getAllOrders() {
        return ordersJpa.findAll();
    }

    public String addNewOrder(Orders order) {
        ordersJpa.save(order);
        return "New order added";
    }
    public String addListOfOrders( List<Orders> newOrders)
    {
//         List<Orders> orderList = new ArrayList<>(newOrders);
//        Iterable<Orders> savedEntities = ordersJpa.saveAll(orderList);
        ordersJpa.saveAll(newOrders);
        return "New Orders added";
    }
    public Orders getById(long id) {
        return ordersJpa.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid order id"));
    }

    public String deleteOrderById(Long id) {
        ordersJpa.deleteById(id);
        return "order cancelled";
    }

    public String updateOrder(Orders order, Long id) {
//             List<Orders> orderList= getAllOrders();
//             for(int i=0;i<orderList.size();i++){
//                Long cId=orderList.get(i).getOrderId();
//                if(cId.equals(id))
//                    orderList.set(i,order);
//             }
//            return "Order has been updated";
        Orders existingOrder=ordersJpa.findById(id).orElse(null);
        if(existingOrder!=null){
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setCustomerName(order.getCustomerName());
            existingOrder.setOrderPayment(order.getOrderPayment());
            existingOrder.setDeleverAdress(order.getDeleverAdress());
            ordersJpa.save(existingOrder);
        }
        return "order has been updated";
    }
}
