package com.example.stin.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
    * This class is used to send an email to the user
 */
@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    public String sendEmail(EmailDetails emailDetails) {
        return emailService.sendSimpleMessage(emailDetails);
    }
}
