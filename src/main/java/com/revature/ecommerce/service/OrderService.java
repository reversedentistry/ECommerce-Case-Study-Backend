package com.revature.ecommerce.service;

import com.revature.ecommerce.model.Order;
import com.revature.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;

    public Order submitNewOrder(Order order) {
        return orderRepo.save(order);
    }
}
