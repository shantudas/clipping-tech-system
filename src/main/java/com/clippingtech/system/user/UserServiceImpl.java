package com.clippingtech.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Integer id) {
        return null;
    }

    @Override
    public UserEntity updateUserById(Integer id, UserEntity UserEntity) {
        return null;
    }

    @Override
    public String deleteUserById(Integer id) {
        return "";
    }
}
