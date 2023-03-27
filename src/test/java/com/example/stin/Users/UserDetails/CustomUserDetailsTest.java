package com.example.stin.Users.UserDetails;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CustomUserDetails.class})
class CustomUserDetailsTest {

    @MockBean
    private UserEntity userEntity;

    @Test
    void getAuthorities() {
        CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
        assertNull(customUserDetails.getAuthorities());
    }



    @Test
    void isAccountNonExpired() {
        CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
        assertTrue(customUserDetails.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
        assertTrue(customUserDetails.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
        assertTrue(customUserDetails.isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {
        CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
        assertTrue(customUserDetails.isEnabled());
    }
}