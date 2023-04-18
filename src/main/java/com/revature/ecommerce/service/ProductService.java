package com.revature.ecommerce.service;

import com.revature.ecommerce.model.Product;
import com.revature.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(int productId) throws NoSuchElementException{
        return productRepo.findById(productId).get();
    }

    public Product addProductToDatabase(Product product) {
        return productRepo.save(product);
    }
}
