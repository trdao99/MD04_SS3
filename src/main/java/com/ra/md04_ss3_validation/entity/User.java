package com.ra.md04_ss3_validation.entity;

import com.ra.md04_ss3_validation.validator.UserNameExist;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "username cant be blank")
    private String username;
    @Column(nullable = false,length = 100)
    @NotBlank(message = "password cant be blank")
    private String password;
    @NotBlank(message = "fullName cant be blank")
    @Column(nullable = false,length = 70)
    private String fullName;
    @NotNull(message = "Status is empty")
    private Boolean status;
    @Column(length = 200)
    @NotBlank(message = "address cant be blank")
    private String address;
    @NotBlank(message = "email cant be blank")
    @Column(nullable = false,unique = true)
    @Email
    private String email;
    private String phone;
}
