package com.example.demo.exception;

public class CategoryAlreadyAddedException extends Exception{
    public CategoryAlreadyAddedException(){

    }
    public CategoryAlreadyAddedException(String m){
        super(m);
    }
}
