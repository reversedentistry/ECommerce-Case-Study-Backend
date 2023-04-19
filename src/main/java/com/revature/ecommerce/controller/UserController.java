package com.revature.ecommerce.controller;

import com.revature.ecommerce.model.User;
import com.revature.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.createNewUser(user);
        return ResponseEntity.status(200).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        if (userService.userLogin(user)) {
            return ResponseEntity.status(200).body("Successful login!");
        } else {
            return ResponseEntity.status(400).body("There was an error " +
                    "logging in.");
        }
    }
}
