package com.example.stin.Mail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class EmailDetailsTest {

    @Test
    void testEmailDetailsNotNULL() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        assertNotNull(emailDetails);

    }

    @Test
    void testEmailDetailsNotNull() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        assertNotNull(emailDetails.getRecipient());
        assertNotNull(emailDetails.getMsgBody());
        assertNotNull(emailDetails.getSubject());
    }

    @Test
    void testEmailDetailsIsEmpty() {
        EmailDetails emailDetails = new EmailDetails();
        assertNull(emailDetails.getRecipient());
        assertNull(emailDetails.getMsgBody());
        assertNull(emailDetails.getSubject());
    }

    @Test
    void getRecipient() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        assertEquals("test", emailDetails.getRecipient());
    }

    @Test
    void getMsgBody() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        assertEquals("test", emailDetails.getMsgBody());
    }

    @Test
    void getSubject() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        assertEquals("test", emailDetails.getSubject());
    }

    @Test
    void setRecipient() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient("test");
        assertEquals("test", emailDetails.getRecipient());
    }

    @Test
    void setMsgBody() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setMsgBody("test");
        assertEquals("test", emailDetails.getMsgBody());
    }

    @Test
    void setSubject() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setSubject("test");
        assertEquals("test", emailDetails.getSubject());
    }

    @Test
    void testEquals() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        EmailDetails emailDetails1 = new EmailDetails("test", "test", "test");
        assertEquals(emailDetails, emailDetails1);
        assertEquals(emailDetails.getMsgBody(), emailDetails1.getMsgBody());
        assertEquals(emailDetails.getRecipient(), emailDetails1.getRecipient());
        assertEquals(emailDetails.getSubject(), emailDetails1.getSubject());
    }

    @Test
    void canEqual() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        EmailDetails emailDetails1 = new EmailDetails("test", "test", "test");
        assertTrue(emailDetails.canEqual(emailDetails1));
    }

    @Test
    void testHashCode() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        EmailDetails emailDetails1 = new EmailDetails("test", "test", "test");
        assertEquals(emailDetails.hashCode(), emailDetails1.hashCode());
        assertEquals(emailDetails.getMsgBody().hashCode(), emailDetails1.getMsgBody().hashCode());
        assertEquals(emailDetails.getRecipient().hashCode(), emailDetails1.getRecipient().hashCode());
        assertEquals(emailDetails.getSubject().hashCode(), emailDetails1.getSubject().hashCode());

    }

    @Test
    void testToString() {
        EmailDetails emailDetails = new EmailDetails("test", "test", "test");
        String toString = "EmailDetails(recipient=test, msgBody=test, subject=test)";
        assertEquals(toString, emailDetails.toString());
    }
}