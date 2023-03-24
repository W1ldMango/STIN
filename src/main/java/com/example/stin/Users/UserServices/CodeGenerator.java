package com.example.stin.Users.UserServices;

import org.springframework.stereotype.Service;
import java.util.Random;

/*
    * This class is used to create a random generating code
 */
@Service
public class CodeGenerator {

    public Integer sendCode() {
        return new Random().nextInt(999999);
    }
}
