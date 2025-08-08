package com.usk.controller;

import com.usk.entity.CartItem;
import com.usk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestParam String email, @RequestParam Long productId, @RequestParam int qty){
        cartService.addToCart(email, productId, qty);
        return "Product add to cart";
    }

    @GetMapping
    public List<CartItem> viewCart(@RequestParam String email) {
        return cartService.getUserCart(email);
    }
}
