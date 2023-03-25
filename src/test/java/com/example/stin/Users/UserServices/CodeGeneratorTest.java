package com.example.stin.Users.UserServices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeGeneratorTest {

    @Test
    void sendCode() {
        CodeGenerator codeGenerator = new CodeGenerator();
        Integer code = codeGenerator.sendCode();
        assertTrue(code >= 0 && code <= 999999);
    }
}