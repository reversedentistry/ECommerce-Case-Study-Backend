package com.revature.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class OrderProductPk implements Serializable {
    private static final long serialVersionUID = 476151177562655457L;

    @JsonBackReference
    @Column(name = "user_id")
    private User user;

    @Column(name = "product")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductPk that = (OrderProductPk) o;
        return user.equals(that.user) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, product);
    }
}
