package com.lcwd.user.service.UserService.exception;

public class ResourceNotFoundException extends RuntimeException{

//    Default Constructor
    public ResourceNotFoundException(){
        super("Resource not found on server !!");
    }

//    Parameterized Constractor
    public ResourceNotFoundException(String message){
        super(message);
    }
}
