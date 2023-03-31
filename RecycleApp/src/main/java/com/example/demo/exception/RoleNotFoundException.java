package com.example.demo.exception;

public class RoleNotFoundException extends Exception{
    public RoleNotFoundException(){}
    public RoleNotFoundException(String m) {
        super(m);
    }
}
