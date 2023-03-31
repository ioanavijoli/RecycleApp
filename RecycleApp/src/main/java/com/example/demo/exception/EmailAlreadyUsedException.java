package com.example.demo.exception;

public class EmailAlreadyUsedException extends Exception{
    public EmailAlreadyUsedException(){

    }
    public EmailAlreadyUsedException(String m){
        super(m);
    }
}
