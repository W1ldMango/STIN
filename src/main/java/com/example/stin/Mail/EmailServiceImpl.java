package com.example.stin.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

/**
    * This class is used to send an email to the user
 */
@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender emailSender;

    private static final String NOREPLY_ADDRESS = "semestralworkhotel@gmail.com";

    /**
        * This method is used to send an email to the user
        * @param emailDetails - the email details
        * @return String - the result of the email sending
     */
    @Override
    public String sendSimpleMessage(EmailDetails emailDetails) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NOREPLY_ADDRESS);
            message.setTo(emailDetails.getRecipient());
            message.setSubject(emailDetails.getSubject());
            message.setText(emailDetails.getMsgBody());

            emailSender.send(message);
            return "Email sent";
        } catch (MailException exception) {
            exception.printStackTrace();

            return "Error while sending email";
        }
    }
}
