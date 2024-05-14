package com.clippingtech.system.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Enter a valid email address")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(length = 60) // Adjust length based on hashing algorithm
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "First name is mandatory") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name is mandatory") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Last name is mandatory") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Last name is mandatory") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Email is mandatory") @Email(message = "Enter a valid email address") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") @Email(message = "Enter a valid email address") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is mandatory") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") String password) {
        this.password = password;
    }
}
