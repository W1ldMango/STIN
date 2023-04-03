package com.example.stin.Users.UserDetails;

import com.example.stin.Users.UserInterface.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CustomUserDetailService.class})
class CustomUserDetailServiceTest {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(new UserEntity());
        assertNull(customUserDetailService.loadUserByUsername("janedoe").getAuthorities());
        verify(userRepository).findByEmail(Mockito.<String>any());
    }

    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> customUserDetailService.loadUserByUsername("janedoe"));
        verify(userRepository).findByEmail(Mockito.<String>any());
    }

    @Test
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        when(userRepository.findByEmail(Mockito.<String>any()))
                .thenThrow(new UsernameNotFoundException("User not found"));
        assertThrows(UsernameNotFoundException.class, () -> customUserDetailService.loadUserByUsername("janedoe"));
        verify(userRepository).findByEmail(Mockito.<String>any());
    }

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
    public void testLoadUserByUsernameNotExists() {
        Mockito.doReturn(null)
                .when(userRepository)
                .findByEmail("nonexistent@example.com");
    }

}