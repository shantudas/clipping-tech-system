package com.clippingtech.system.service;

import com.clippingtech.system.model.User;
import com.clippingtech.system.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User updateUserById(Integer id, User User) {
        return null;
    }

    @Override
    public String deleteUserById(Integer id) {
        return "";
    }
}
