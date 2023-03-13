package com.example.stin;

import com.example.stin.Mail.EmailController;
import com.example.stin.Mail.EmailDetails;
import com.example.stin.Mail.EmailService;
import com.example.stin.Users.UserController;
import com.example.stin.Users.UserEntity;
import com.example.stin.Users.UserRepository;
import com.example.stin.Users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

public class UserCreateTest {

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        EmailController emailController = new EmailController();
        emailController.sendEmail(new EmailDetails("justfoxel@gmail.com", "Hello", "Hello"));


    }

}
