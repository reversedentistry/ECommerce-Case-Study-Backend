package com.revature.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
