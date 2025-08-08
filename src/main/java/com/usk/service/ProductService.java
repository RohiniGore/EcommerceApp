package com.usk.service;

import com.usk.dto.ProductRequest;
import com.usk.dto.ProductResponse;
import com.usk.entity.Product;
import com.usk.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        Product savedProduct = productRepository.save(product);

        ProductResponse productResponse  = new ProductResponse();
        BeanUtils.copyProperties(savedProduct, productResponse);
        return productResponse;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> searchProducts(String keyword){
        return productRepository.findByNameContainingIgnoreCase(keyword);
        }

        public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

}
