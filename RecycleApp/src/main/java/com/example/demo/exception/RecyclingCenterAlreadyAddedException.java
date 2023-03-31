package com.example.demo.exception;

import com.example.demo.repository.RecyclingCenterRepository;

public class RecyclingCenterAlreadyAddedException extends Exception{
    public RecyclingCenterAlreadyAddedException(){

    }
    public RecyclingCenterAlreadyAddedException(String m){
        super(m);
    }
}
