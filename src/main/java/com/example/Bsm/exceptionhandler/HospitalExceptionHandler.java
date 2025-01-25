package com.example.Bsm.exceptionhandler;

import com.example.Bsm.exception.HospitalNotFoundByIdException;
import com.example.Bsm.exception.UserNotFoundByIdException;
import com.example.Bsm.util.ErrorStructure;
import com.example.Bsm.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HospitalExceptionHandler
{
    private  final RestResponseBuilder responseBuilder;


    public<T> ResponseEntity<ErrorStructure<T>> handleHospitalNotFoundById (HospitalNotFoundByIdException ex)
    {
        return  responseBuilder.error(HttpStatus.NOT_FOUND , ex.getMessage(), (T) "Hospital not found by given Id");
    }
}
