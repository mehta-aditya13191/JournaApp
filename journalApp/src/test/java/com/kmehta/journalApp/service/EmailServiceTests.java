package com.kmehta.journalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
     void testSendEmail(){
        emailService.sendEmail(
                "amehta13191@gmail.com",
                "Checking mail sender",
                "Hi,app kaise hai bhaiya ?"
        );
    }
}
