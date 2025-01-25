package com.example.Bsm.exceptionhandler;

import com.example.Bsm.exception.UserNotFoundByIdException;
import lombok.AllArgsConstructor;
import com.example.Bsm.util.ErrorStructure;
import com.example.Bsm.util.RestResponseBuilder;
import org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor

public class UserExceptionHandler
{

    private  final RestResponseBuilder responseBuilder;

    public<T> ResponseEntity<ErrorStructure<T>> handleUserNotFoundById (UserNotFoundByIdException ex)
    {
        return  responseBuilder.error(HttpStatus.NOT_FOUND , ex.getMessage(), (T) "User not found by given Id");
    }
}
