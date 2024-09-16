package com.kran.commerce.errors;

import org.springframework.http.HttpStatus;

public class ServiceError extends CustomError{
    
    public ServiceError( String message) {
        super(HttpStatus.CONFLICT, message);
        //TODO Auto-generated constructor stub
    }
    
}
