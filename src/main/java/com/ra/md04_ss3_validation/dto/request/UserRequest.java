package com.ra.md04_ss3_validation.dto.request;

import com.ra.md04_ss3_validation.validator.UserNameExist;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    @UserNameExist
    @NotBlank(message = "username cant be blank")
    private String username;
    @NotBlank(message = "password cant be blank")
    private String password;
    @NotBlank(message = "fullname cant be blank")
    private String fullName;
    @NotBlank(message = "address cant be blank")
    private String address;
    @NotBlank(message = "email cant be blank")
    @Email
    private String email;
    private String phone;
}
