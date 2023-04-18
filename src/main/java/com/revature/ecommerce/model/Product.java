package com.revature.ecommerce.model;

import com.sun.istack.NotNull;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productId;

    @NotNull
    private String productName;
    @NotNull
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.price
                , price) == 0 && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price);
    }
}
