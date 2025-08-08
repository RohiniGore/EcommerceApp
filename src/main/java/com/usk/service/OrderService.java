package com.usk.service;

import com.usk.client.BankingClient;
import com.usk.dto.PaymentRequest;
import com.usk.entity.CartItem;
import com.usk.entity.Order;
import com.usk.entity.User;
import com.usk.repository.CartRepository;
import com.usk.repository.OrderRepository;
import com.usk.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BankingClient bankingClient;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public String placeOrder(String email, String accountNumber) {
        User user = userRepository.findByEmail(email).orElseThrow();
        List<CartItem> cartItems = cartRepository.findByUser(user);

        if (cartItems.isEmpty()) {
            return "Cart is empty.";
        }
        double total = cartItems.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
        PaymentRequest request = new PaymentRequest(accountNumber, total);

        try {
            String result = bankingClient.verifyAndDeduct(request);
            if (!"Approved".equalsIgnoreCase(result)) {
                return "Payment declined: Insufficient funds.";
            }

        } catch (Exception e) {
            return "Banking service unavailable. Please try again later.";
        }

        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(total);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        orderRepository.save(order);

        return "Order placed successfully.";
    }
}




