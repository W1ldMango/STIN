package com.example.stin.Mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EmailServiceImplTest {
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @MockBean
    private JavaMailSender javaMailSender;

    @Test
    void testSendSimpleMessage() throws MailException {
        doNothing().when(javaMailSender).send(Mockito.<SimpleMailMessage>any());
        assertEquals("Email sent", emailServiceImpl.sendSimpleMessage(
                new EmailDetails("Recipient", "Not all who wander are lost", "Hello from the Dreaming Spires")));
        verify(javaMailSender).send(Mockito.<SimpleMailMessage>any());
    }
    @Test
    void testSendSimpleMessage3() throws MailException {
        doNothing().when(javaMailSender).send(Mockito.<SimpleMailMessage>any());
        EmailDetails emailDetails = mock(EmailDetails.class);
        when(emailDetails.getMsgBody()).thenThrow(new MailAuthenticationException("Msg"));
        when(emailDetails.getRecipient()).thenThrow(new MailAuthenticationException("Msg"));
        when(emailDetails.getSubject()).thenThrow(new MailAuthenticationException("Msg"));
        assertEquals("Error while sending email", emailServiceImpl.sendSimpleMessage(emailDetails));
        verify(emailDetails).getRecipient();
    }
}

