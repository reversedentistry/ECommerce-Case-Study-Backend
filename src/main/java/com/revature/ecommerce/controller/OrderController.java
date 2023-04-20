package com.revature.ecommerce.controller;

import com.revature.ecommerce.model.Order;
import com.revature.ecommerce.service.OrderProductService;
import com.revature.ecommerce.service.OrderService;
import com.revature.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Order> submitOrder(@RequestBody Order order) {
        Order submittedOrder = orderService.submitNewOrder(order);
        return ResponseEntity.status(200).body(order);
    }
}
