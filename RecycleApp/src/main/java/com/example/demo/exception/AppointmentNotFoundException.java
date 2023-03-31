package com.example.demo.exception;

public class AppointmentNotFoundException extends Exception{
    public AppointmentNotFoundException(){}
    public AppointmentNotFoundException(String m){
        super(m);
    }
}
