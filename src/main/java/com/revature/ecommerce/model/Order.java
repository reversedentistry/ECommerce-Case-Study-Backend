package com.revature.ecommerce.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderNumber;
    private int customerId;
    @OneToMany(mappedBy = "pk")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Transient
    public double getOrderTotal() {
        double sum = 0;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct prod : orderProducts) {
            sum += prod.getTotalPrice();
        }
        return sum;
    }

}
