package com.example.Bsm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class BloodBankNotFoundByIdException extends RuntimeException
{
    private final  String message;
}