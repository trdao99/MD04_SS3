package com.ra.md04_ss3_validation.advice;

import com.ra.md04_ss3_validation.dto.reponse.DataError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ApiValidateAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataError<Map<String,String>> handleMethodArgument(MethodArgumentNotValidException ex){
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < ex.getAllErrors().size(); i++) {
            ObjectError error = ex.getAllErrors().get(i);
            map.put("error "+(i+1), error.getDefaultMessage());
        }
        return new DataError<>(map, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TransactionSystemException.class)
    public DataError<Map<String,String>> handleTransactionSystemException(TransactionSystemException ex){
        Map<String,String> map = new HashMap<>();
        map.put("error", ex.getMessage());
        return new DataError<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public DataError<Map<String,String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        Map<String,String> map = new HashMap<>();
        map.put("error", "email existed");
        return new DataError<>(map, HttpStatus.BAD_REQUEST);
    }
}
