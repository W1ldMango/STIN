package com.example.stin.SecurityConfig;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigurationTest {

    @Test
    void passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = "password";
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        assertTrue(bCryptPasswordEncoder.matches(password, encodedPassword));
    }
}