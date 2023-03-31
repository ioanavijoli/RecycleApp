package com.example.demo.service;

import org.springframework.stereotype.Component;


@Component
public interface MailService {
    void sendEmail(String to, String subject, String text);
}
