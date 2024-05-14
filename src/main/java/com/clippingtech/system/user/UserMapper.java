package com.clippingtech.system.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(UserEntity user) {
        return new UserResponseDto(user);
    }

    public UserEntity toEntity(UserCreateDto userCreateDto) {
        UserEntity user = new UserEntity();
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword()); // Assuming password hashing done elsewhere
        return user;
    }

    public UserEntity toEntity(UserUpdateDto userUpdateDto, UserEntity existingUser) {
        existingUser.setFirstName(userUpdateDto.getFirstName());
        existingUser.setLastName(userUpdateDto.getLastName());
        existingUser.setEmail(userUpdateDto.getEmail()); // Consider validation for email updates
        return existingUser;
    }
}
