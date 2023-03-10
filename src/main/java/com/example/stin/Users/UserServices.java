package com.example.stin.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {


    public int codeGenerator() {
        int code = (int) (Math.random() * 1000000);
        return code;
    }

    public int sendCode() {
        int code = codeGenerator();
        System.out.println(code);
        return code;
    }

}
