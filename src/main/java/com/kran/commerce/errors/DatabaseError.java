package com.kran.commerce.errors;

import org.springframework.http.HttpStatus;

public class DatabaseError extends CustomError{

    public DatabaseError(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
        //TODO Auto-generated constructor stub
    }
    
}
