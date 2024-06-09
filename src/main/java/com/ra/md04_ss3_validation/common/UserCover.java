package com.ra.md04_ss3_validation.common;

import com.ra.md04_ss3_validation.dto.request.UserRequest;
import com.ra.md04_ss3_validation.entity.User;
import lombok.*;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Repository
public class UserCover {
    public User toUser(UserRequest user) {
        return User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .address(user.getAddress())
                .status(true)
                .password(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)))
                .build();
    }
}
