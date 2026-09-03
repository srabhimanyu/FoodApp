package com.phegon.FoodApp.auth_users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class RegistrationRequest {
    @NotBlank(message="name is required")
    private String name;

    @NotBlank(message="Email is required")
    @Email(message="Invalid email format")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min=3,message="Password must be at least 4 characters long")
    private String password;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "PhoneNumber is required")
    private String phoneNumber;
    private List<String> roles;
}
