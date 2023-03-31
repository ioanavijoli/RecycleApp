package com.example.demo.exception;

public class UsernameAlreadyUsedException extends Exception {
    public UsernameAlreadyUsedException() {
    }

    public UsernameAlreadyUsedException(String m) {
        super(m);
    }
}

