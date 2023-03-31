package com.example.demo.exception;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(){}
    public CategoryNotFoundException(String m){
        super(m);
    }
}
