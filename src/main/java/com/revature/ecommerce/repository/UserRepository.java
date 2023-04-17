package com.revature.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.ecommerce.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
