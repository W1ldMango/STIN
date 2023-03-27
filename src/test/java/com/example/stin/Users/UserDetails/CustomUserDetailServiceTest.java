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
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomUserDetailServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsService userDetailsService = new CustomUserDetailService();

    @Before
    public void setUp() {
        UserEntity user = new UserEntity();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        when(userRepository.findByEmail(eq("test@example.com"))).thenReturn(user);
    }

    @Test
    public void testLoadUserByUsername() {
        Mockito.doReturn(new UserEntity())
                .when(userRepository)
                .findByEmail("test@gmail.com");
    }

    @Test
    public void testLoadUserByUsernameNotFound() {
        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("nonexistent@example.com");
        });
        when(userRepository.findByEmail(eq("nonexistent@example.com"))).thenReturn(null);
        assertEquals("User not found", exception.getMessage());

    }

}