package com.example.demo.exception;

public class ProductAlreadyAddedException extends Exception{
    public ProductAlreadyAddedException(){
    }
    public ProductAlreadyAddedException(String m){
        super(m);
    }
}
