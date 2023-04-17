package com.revature.ecommerce.service;

import com.revature.ecommerce.model.User;
import com.revature.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public User createNewUser(User user) {
        return userRepo.save(user);
    }

    public boolean userLogin(String username, String password) {
        User loginAttempt = userRepo.findByUsername(username);
        if (loginAttempt != null) {
            String userPassword = loginAttempt.getPassword();
            return password.equals(userPassword);
        } else {
            return false;
        }
    }
}
