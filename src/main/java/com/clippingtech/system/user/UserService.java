package com.clippingtech.system.user;

import java.util.List;

public interface UserService {
    UserEntity saveUser(UserEntity UserEntity);

    List<UserEntity> fetchAllUsers();

    UserEntity getUserById(Integer id);

    UserEntity updateUserById(Integer id, UserEntity UserEntity);

    String deleteUserById(Integer id);
}
