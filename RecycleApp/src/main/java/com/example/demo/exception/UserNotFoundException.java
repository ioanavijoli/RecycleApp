package com.example.demo.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){}
    public UserNotFoundException(String m){
        super(m);
    }
}

