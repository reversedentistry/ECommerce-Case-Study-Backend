package com.revature.ecommerce.repository;

import com.revature.ecommerce.model.OrderProduct;
import com.revature.ecommerce.model.OrderProductPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct,
        OrderProductPk> {
}
