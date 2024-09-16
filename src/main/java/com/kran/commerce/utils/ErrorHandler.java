package com.kran.commerce.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kran.commerce.errors.CustomError;
import com.kran.commerce.errors.DatabaseError;


public class ErrorHandler {
    @ExceptionHandler
    public ResponseEntity<CustomError> errorHandler(Exception exp){
        CustomError customError=(CustomError) (exp instanceof CustomError? exp:new DatabaseError(exp.getMessage()));
        return new ResponseEntity<>(customError,customError.getStatus());
    }
}
