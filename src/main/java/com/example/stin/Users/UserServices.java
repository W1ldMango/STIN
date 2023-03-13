package com.example.stin.Users;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServices {


    public Integer sendCode() {
        return new Random().nextInt(999999);
    }

}
