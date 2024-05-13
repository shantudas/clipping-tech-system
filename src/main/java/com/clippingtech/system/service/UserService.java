package com.clippingtech.system.service;

import com.clippingtech.system.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User User);

    List<User> fetchAllUsers();

    User getUserById(Integer id);

    User updateUserById(Integer id, User User);

    String deleteUserById(Integer id);
}
