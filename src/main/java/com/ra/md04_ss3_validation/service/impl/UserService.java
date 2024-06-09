package com.ra.md04_ss3_validation.service.impl;

import com.ra.md04_ss3_validation.common.UserCover;
import com.ra.md04_ss3_validation.dto.request.UserRequest;
import com.ra.md04_ss3_validation.entity.User;
import com.ra.md04_ss3_validation.reponsitory.ReponsitoryUser;
import com.ra.md04_ss3_validation.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService implements IUserService {
    @Autowired
    ReponsitoryUser reponsitoryUser;
    @Autowired
    UserCover userCover;

    @Override
    public List<User> getUsers() {
        return reponsitoryUser.findAll();
    }

    @Override
    public User addUser(UserRequest userRequest) {
        return reponsitoryUser.save(userCover.toUser(userRequest));
    }

    @Override
    public User updateUser(User user) {
        reponsitoryUser.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
        user.setPassword((BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12))));
        return reponsitoryUser.save(user);
    }

    @Override
    public void deleteUser(int id) {
        reponsitoryUser.deleteById(id);
    }

    @Override
    public User getUserByUserName(String name) {
        return reponsitoryUser.findUserByUsername(name);
    }

    @Override
    public List<User> getUserByFullName(String name) {
        return reponsitoryUser.findUserByFullNameContains(name);
    }



}
