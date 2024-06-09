package com.ra.md04_ss3_validation.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataError<T> {
    private String message;
    private T content;
    private HttpStatus httpStatus;

    public DataError(Map<String, String> map, HttpStatus httpStatus) {
        this.message = "Validation failed";
        this.content = (T) map;
        this.httpStatus = httpStatus;
    }
}
