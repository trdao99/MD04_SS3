package com.ra.md04_ss3_validation.validator;

import com.ra.md04_ss3_validation.reponsitory.ReponsitoryUser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNameExistValidator implements ConstraintValidator<UserNameExist,String> {
    @Autowired
    private ReponsitoryUser repositoryUser;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return repositoryUser.findUserByUsername(s) == null;
    }
}
