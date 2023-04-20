package com.revature.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class OrderProduct {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPk pk;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return quantity == that.quantity && pk.equals(that.pk) && user.equals(that.user) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, user, product, quantity);
    }
}
