package com.example.Bsm.exceptionhandler;

import com.example.Bsm.util.ErrorStructure;
import com.example.Bsm.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
@AllArgsConstructor
public class BloodBankExceptionHandler {
          private  final RestResponseBuilder responseBuilder;

        public<T> ResponseEntity<ErrorStructure<T>> handleBloodBankNotFoundById (BloodBankExceptionHandler ex)
        {
            return  responseBuilder.error(HttpStatus.NOT_FOUND , ex.getMessage(), (T) "BloodBank not found by given Id");
        }

    String getMessage() {
            return  null;
    }
}


