package com.kran.commerce.utils;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kran.commerce.errors.CustomError;
import com.kran.commerce.errors.DatabaseError;
/**
 * InnerErrorHandler
 */
 class ErrorResponse {

    private final int status;
    private final String msg;
    private final String date=new Date().toString();
    public ErrorResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public int getStatus() {
        return status;
    }
    public String getMsg() {
        return msg;
    }
    public String getDate() {
        return date;
    }
     
}
@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorHandler(Exception exp){
        CustomError customError=(CustomError) (exp instanceof CustomError? exp:new DatabaseError(exp.getMessage()));
        ErrorResponse errorResponse=new ErrorResponse(customError.getStatus().value(), customError.getMessage());
        return new ResponseEntity<>(errorResponse,customError.getStatus());
    }
}
