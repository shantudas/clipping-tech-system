package com.clippingtech.system.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserCreateDto userCreateDto, Errors errors) {
        UserEntity savedUser = userService.saveUser(userMapper.toEntity(userCreateDto));
        return new ResponseEntity<>(userMapper.toDto(savedUser), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String searchTerm) {

        Page<UserEntity> userPage = userService.fetchAllUsers(page, size, searchTerm);

        // Mapping to UserResponseDto and returning paginated response
        List<UserResponseDto> userResponseDtos = userPage.getContent()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(userPage.map(UserResponseDto::new), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Integer id) {
        UserEntity user = userService.getUserById(id);
        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable Integer id, @RequestBody @Valid UserUpdateDto userUpdateDto) {
        UserEntity existingUser = userService.getUserById(id);
        UserEntity updatedUser = userService.updateUserById(id, userMapper.toEntity(userUpdateDto, existingUser));
        return new ResponseEntity<>(userMapper.toDto(updatedUser), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
