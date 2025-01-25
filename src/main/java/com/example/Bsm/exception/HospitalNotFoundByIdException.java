package com.example.Bsm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HospitalNotFoundByIdException extends RuntimeException
{
    private  final String message;
}
