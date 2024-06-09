package com.ra.md04_ss3_validation.service;

import com.ra.md04_ss3_validation.dto.request.UserRequest;
import com.ra.md04_ss3_validation.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User addUser(UserRequest userRequest);
    User updateUser(User user);
    void deleteUser(int id);
    User getUserByUserName(String name);
    List<User> getUserByFullName(String name);
}
