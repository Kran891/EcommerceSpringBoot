package com.kran.commerce.errors;

import org.springframework.http.HttpStatus;

public class CustomError extends RuntimeException{
    private final HttpStatus status;
 
    public CustomError(HttpStatus status, String message) {
        super(message);
        this.status = status;
 
    }
    public HttpStatus getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return "CustomError [getStatus()=" + getStatus() + ", getMessage()=" + getMessage() + "]";
    }
    
    
    
}
