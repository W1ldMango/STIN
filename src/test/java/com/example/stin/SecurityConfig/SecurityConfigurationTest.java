package com.example.stin.SecurityConfig;

import com.example.stin.Users.UserDetails.CustomUserDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(addFilters = false)
//@WebMvcTest(SecurityConfiguration.class)
//@AutoConfigureWebMvc
class SecurityConfigurationTest {

//    @Autowired
//    private MockMvc mockMvc;

    @MockBean
    private static BCryptPasswordEncoder bCryptPasswordEncoder;

    @MockBean
    private SecurityConfiguration securityConfiguration;

    @Test
    public void testUserDetailsService() {
        // create user details service
        UserDetailsService userDetailsService = new SecurityConfiguration().userDetailsService();

        // verify that the user details service is not null
        assertNotNull(userDetailsService);
    }

//    @Test
//    public void testAuthenticationProvider() {
//        // create authentication provider
//        UserDetailsService mockUserDetailsService = mock(CustomUserDetailService.class);
//
//        // create authentication provider
//        DaoAuthenticationProvider authProvider = new SecurityConfiguration().authenticationProvider(mockUserDetailsService);
//
////        DaoAuthenticationProvider authProvider = new SecurityConfiguration().authenticationProvider();
//
//        // verify that the authentication provider is not null
//        assertNotNull(authProvider);
//
//        // verify that the authentication provider has the correct user details service set
//        assertEquals(new CustomUserDetailService().getClass(), authProvider.getUserDetailsService().getClass());
//
//        // verify that the authentication provider has a non-null password encoder set
//        PasswordEncoder passwordEncoder = authProvider.getPasswordEncoder();
//        assertNotNull(passwordEncoder);
//        assertTrue(passwordEncoder instanceof BCryptPasswordEncoder);
//    }

    @Test
    public void testAuthenticationManager() throws Exception {
        // mock authentication configuration
        AuthenticationConfiguration authConfig = mock(AuthenticationConfiguration.class);
        AuthenticationManager authManager = mock(AuthenticationManager.class);
        when(authConfig.getAuthenticationManager()).thenReturn(authManager);

        // create authentication manager
        AuthenticationManager manager = new SecurityConfiguration().authenticationManager(authConfig);

        // verify that the returned authentication manager is the same as the mock authentication manager
        assertSame(authManager, manager);
    }

    @Test
    public void testPasswordEncoder() {
        // create password encoder
        BCryptPasswordEncoder encoder = new SecurityConfiguration().passwordEncoder();

        // verify that the encoder is not null
        assertNotNull(encoder);

        // verify that the encoder returns a non-empty string when we encode a password
        String password = "test-password";
        String encodedPassword = encoder.encode(password);
        assertNotNull(encodedPassword);
        assertTrue(encodedPassword.length() > 0);
    }

//    @Test
//    public void testSecurityFilterChain() throws Exception {
//        // configure HttpSecurity
//        HttpSecurity http = mock(HttpSecurity.class);
//        SecurityConfiguration.securityFilterChain(http);
//
//        // create test user
//        String email = "test@example.com";
//        String password = "password123";
//        User user = new User(email, bCryptPasswordEncoder.encode(password), null);
//
//        // authenticate test user
//        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email, password);
//
//        // verify that unauthenticated user is redirected to login page
////        mockMvc.perform(get("/verification"))
////                .andExpect(status().is3xxRedirection())
////                .andExpect(redirectedUrlPattern("**/login"))
////                .andExpect(unauthenticated());
////
////        // verify that login page is accessible
////        mockMvc.perform(get("/login"))
////                .andExpect(status().isOk())
////                .andExpect(authenticated().withAnonymousUser());
//
//        // verify that valid login credentials redirect to verification page
//        mockMvc.perform(SecurityMockMvcRequestBuilders
//                        .formLogin("/login")
//                        .user(email)
//                        .password(password))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/verification"))
//                .andExpect(authenticated().withAuthentication(auth));
//
//        // verify that logout clears authentication and redirects to login page
//        mockMvc.perform(logout("/logout"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/login"))
//                .andExpect(unauthenticated());
//    }
}