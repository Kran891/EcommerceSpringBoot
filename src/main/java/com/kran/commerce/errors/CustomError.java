package com.kran.commerce.errors;

public class CustomError extends RuntimeException{
    private int status;
 
    public CustomError(int status, String message) {
        super(message);
        this.status = status;
 
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
