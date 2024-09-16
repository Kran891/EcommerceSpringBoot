package com.kran.commerce.errors;

import org.springframework.http.HttpStatus;

public class NotFoundError extends  CustomError{
  
   public NotFoundError(String message,int status){
    super(HttpStatus.NOT_FOUND,message);
   }
}
