package com.example.Bsm.exceptionhandler;

import com.example.Bsm.exception.HospitalNotFoundByIdException;
import com.example.Bsm.util.ErrorStructure;
import com.example.Bsm.util.RestResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserNameNotFoundExecptionHandler {
    private final RestResponseBuilder restResponseBuilder;

    public UserNameNotFoundExecptionHandler(RestResponseBuilder restResponseBuilder) {
        this.restResponseBuilder = restResponseBuilder;
    }
    public <T> ResponseEntity<ErrorStructure<T>> handleUserNameNotFoundById (BloodBankExceptionHandler ex)
    {
        return  restResponseBuilder.error(HttpStatus.NOT_FOUND , ex.getMessage(), (T) "Hospital not found by given Id");
    }
}

