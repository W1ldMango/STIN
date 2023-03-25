package com.example.stin.Mail;

/**
    * This interface is used to send an email to the user
 */
public interface EmailService {
    String sendSimpleMessage(EmailDetails emailDetails);
}
