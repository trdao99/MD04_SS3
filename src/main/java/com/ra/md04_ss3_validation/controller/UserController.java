package com.ra.md04_ss3_validation.controller;

import com.ra.md04_ss3_validation.dto.request.UserRequest;
import com.ra.md04_ss3_validation.entity.User;
import com.ra.md04_ss3_validation.service.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getByUserName/{userName}")
    public User getUserByUserName(@PathVariable("userName") String userName) {
        return userService.getUserByUserName(userName);
    }

    @GetMapping("/getByFullName/{fullName}")
    public List<User> getUserByFullName(@PathVariable("fullName") String fullName) {
        return userService.getUserByFullName(fullName);
    }

    @PostMapping("/add")
    public User addUser(@Validated @RequestBody UserRequest userRequest) {
       return userService.addUser(userRequest);
    }

    @PutMapping("/update")
    public User updateUser(@Validated @RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
