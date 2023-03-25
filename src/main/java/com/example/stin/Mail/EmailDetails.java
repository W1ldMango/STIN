package com.example.stin.Mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * This class is used to create a template for the email
    * @AllArgsConstructor - creates a constructor with all the fields
    * @NoArgsConstructor - creates a constructor with no fields
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
}
