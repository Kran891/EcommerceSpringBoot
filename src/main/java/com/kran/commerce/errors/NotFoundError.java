package com.kran.commerce.errors;

public class NotFoundError extends  CustomError{
  
   public NotFoundError(String message,int status){
    super(404,message);
   }
}
