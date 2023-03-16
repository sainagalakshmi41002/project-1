package com.SpringBoot.project1.Controller;

import com.SpringBoot.project1.Entity.Orders;
import com.SpringBoot.project1.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {

    private OrderService orderService;
    @GetMapping("/getAllOrders")
    public List<Orders> getALLOrders(){
        List<Orders> orderlist= orderService.getAllOrders();
        return orderlist;
    }
    @PostMapping("add")
    public String addOrder(@RequestBody Orders order){
        orderService.addNewOrder(order);
        return "New order added";
    }
    @PostMapping("/add/objects")
    public String createObjects(@RequestBody List<Orders> newOrderList) {
        orderService.addListOfOrders(newOrderList);
        return "New Orders added";
    }

    @GetMapping("getById/{id}")
    public Orders getById(@PathVariable long id){
        return orderService.getById(id);
    }
    @DeleteMapping("/cancelOrderById/{id}")
    public String deleteById(@PathVariable Long id){
        orderService.deleteOrderById(id);
        return "order deleted";
    }
    @PutMapping("/update/{id}")
    public String updateOrder(@RequestBody Orders order, @PathVariable("id") Long id){
        orderService.updateOrder(order,id);
        return "Order has been updated";
    }

}
