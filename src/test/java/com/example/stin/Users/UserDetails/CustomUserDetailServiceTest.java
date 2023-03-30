package com.example.stin.Users.UserDetails;

import com.example.stin.Users.UserInterface.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CustomUserDetailService.class})
class CustomUserDetailServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        UserEntity user = new UserEntity();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        when(userRepository.findByEmail(eq("test@example.com"))).thenReturn(user);
    }

    @Test
    public void testLoadUserByUsername() {
        UserEntity user = new UserEntity();
        Mockito.doReturn(user)
                .when(userRepository)
                .findByEmail("test@gmail.com");
    }

    @Test
    public void testLoadUserByUsernameNotExists() {
        UserEntity user = new UserEntity();
        Mockito.doReturn(null)
                .when(userRepository)
                .findByEmail("nonexistent@example.com");
    }

}