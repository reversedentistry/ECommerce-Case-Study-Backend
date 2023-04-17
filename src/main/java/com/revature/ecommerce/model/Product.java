package com.revature.ecommerce.model;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private int productId;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price);
    }
}
