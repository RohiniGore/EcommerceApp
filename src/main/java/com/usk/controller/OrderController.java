package com.usk.controller;

import com.usk.entity.Order;
import com.usk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public String checkout(@RequestParam String email, @RequestParam String accountNumber){
        return orderService.placeOrder(email, accountNumber);
    }
  /* @GetMapping("/history")
    public List<Order> getOrderHistory(@RequestParam String email,
                                      @RequestParam int duration,
                                       @RequestParam String unit){
        return orderService.getOrderHitory(email, duration, unit);
    }*/
}
