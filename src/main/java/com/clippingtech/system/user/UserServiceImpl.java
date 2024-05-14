package com.clippingtech.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Page<UserEntity> fetchAllUsers(int page, int size, String searchTerm) {
        // Search logic (assuming search by name)
        String searchTermLike = "%" + searchTerm + "%";
        Page<UserEntity> userPage;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            userPage = userRepository.findByFirstNameLikeOrLastNameLike(searchTermLike, searchTermLike, PageRequest.of(page, size));
        } else {
            userPage = userRepository.findAll(PageRequest.of(page, size));
        }
        return userPage;
    }

    @Override
    public UserEntity getUserById(Integer id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public UserEntity updateUserById(Integer id, UserEntity userEntity) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            // Update specific fields (replace with your logic)
            existingUser.setFirstName(userEntity.getFirstName());
            existingUser.setLastName(userEntity.getLastName());
            existingUser.setEmail(userEntity.getEmail());
            existingUser.setPassword(userEntity.getPassword()); // Assuming password hashing
            return userRepository.save(existingUser); // Save updated user
        } else {
            return null; // User not found
        }
    }

    @Override
    public String deleteUserById(Integer id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return "User deleted successfully"; // Or return a success code
        } else {
            return "User not found"; // Or return a failure code
        }
    }
}
