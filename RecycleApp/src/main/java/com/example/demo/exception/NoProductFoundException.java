package com.example.demo.exception;

public class NoProductFoundException extends Exception{
    public NoProductFoundException(){}
    public NoProductFoundException(String m) {
        super(m);
    }
}
