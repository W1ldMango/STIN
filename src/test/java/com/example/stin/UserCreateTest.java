package com.example.stin;

import com.example.stin.Users.UserController;
import com.example.stin.Users.UserEntity;
import com.example.stin.Users.UserRepository;
import com.example.stin.Users.UserServices;

import java.util.Base64;

public class UserCreateTest {

    private static UserController userRepository;




    public static void main(String[] args) {
        UserServices userServices = new UserServices();
        System.out.println(userServices.codeGenerator());


    }

}
