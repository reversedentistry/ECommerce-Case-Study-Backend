package com.revature.ecommerce.service;

import com.revature.ecommerce.model.OrderProduct;
import com.revature.ecommerce.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Autowired
    OrderProductRepository orderProductRepo;

    public OrderProduct createOrderProduct(OrderProduct orderProduct) {
        return orderProductRepo.save(orderProduct);
    }
}
