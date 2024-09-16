package com.kran.commerce.errors;

import org.springframework.http.HttpStatus;

public class UnAuthorizedError extends CustomError{

    public UnAuthorizedError( String message) {
        super(HttpStatus.UNAUTHORIZED, message);
        //TODO Auto-generated constructor stub
    }
    
}
