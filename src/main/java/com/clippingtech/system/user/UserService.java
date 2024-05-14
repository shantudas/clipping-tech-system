package com.clippingtech.system.user;

import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    UserEntity saveUser(UserEntity UserEntity);

    List<UserEntity> fetchAllUsers();

    Page<UserEntity> fetchAllUsers(int page, int size, String searchTerm);

    UserEntity getUserById(Integer id);

    UserEntity updateUserById(Integer id, UserEntity UserEntity);

    String deleteUserById(Integer id);
}
