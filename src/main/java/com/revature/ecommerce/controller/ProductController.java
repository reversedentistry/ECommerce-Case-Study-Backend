package com.revature.ecommerce.controller;

import com.revature.ecommerce.model.Product;
import com.revature.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(int productId) {
        try {
            Product product = productService.getProduct(productId);
            return ResponseEntity.status(200).body(product);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
