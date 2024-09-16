package com.kran.commerce.errors;

public class UnAuthorizedError extends CustomError{

    public UnAuthorizedError( String message) {
        super(401, message);
        //TODO Auto-generated constructor stub
    }
    
}
