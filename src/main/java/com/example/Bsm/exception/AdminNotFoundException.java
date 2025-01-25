package com.example.Bsm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class AdminNotFoundException extends RuntimeException{
    private  final String message;

    public AdminNotFoundException(String message) {
        this.message = message;
    }
}
