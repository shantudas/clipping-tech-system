package com.clippingtech.system.controller;

import com.clippingtech.system.model.User;
import com.clippingtech.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public User saveEmployee(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllEmployees() {
        return userService.fetchAllUsers();
    }
}
