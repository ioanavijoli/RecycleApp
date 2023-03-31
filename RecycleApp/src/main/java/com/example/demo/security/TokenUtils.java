package com.example.demo.security;

import org.apache.commons.lang3.RandomStringUtils;

public class TokenUtils {

    private static final int TOKEN_LENGTH = 8;

    public static String generateConfirmationToken() {
        return RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH);
    }

}
