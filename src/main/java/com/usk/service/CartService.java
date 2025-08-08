package com.usk.service;

import com.usk.entity.CartItem;
import com.usk.entity.Product;
import com.usk.entity.User;
import com.usk.repository.CartRepository;
import com.usk.repository.ProductRepository;
import com.usk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getUserCart(String email){
        User user = userRepository.findByEmail(email).orElseThrow();
        return cartRepository.findByUser(user);
    }

    public void addToCart(String email, Long productId, int quantity){
        User user = userRepository.findByEmail(email).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();

        CartItem item = new CartItem();
        item.setUser(user);
        item.setProduct(product);
        item.setQuantity(quantity);
        cartRepository.save(item);
    }

}
