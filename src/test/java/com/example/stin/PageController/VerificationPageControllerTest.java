package com.example.stin.PageController;

import com.example.stin.Mail.EmailService;
import com.example.stin.Users.UserInterface.UserRepository;
import com.example.stin.Users.UserServices.CodeGenerator;
import com.sun.security.auth.UserPrincipal;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.connector.CoyotePrincipal;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class VerificationPageControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private CodeGenerator codeGenerator;
//
//    @MockBean
//    private EmailService emailService;
//
//    @Test
//    public void testIndex() throws Exception {
//        // Create a mock Principal object to simulate a user being authenticated
//        Principal principal = new Principal() {
//            @Override
//            public String getName() {
//                return "testuser";
//            }
//        };
//
//        // Mock the code generator to return a fixed code
//        Mockito.when(codeGenerator.sendCode()).thenReturn(1234);
//
//        // Perform a GET request to the "/verification" endpoint with the mock Principal object
//        mockMvc.perform(MockMvcRequestBuilders.get("/verification")
//                        .principal(principal))
//                // Verify that the response has a success status code
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                // Verify that the expected view is returned
//                .andExpect(MockMvcResultMatchers.view().name("verification"));
//
//        // Verify that the UserRepository insertCodeToUser() method is called with the expected arguments
//        Mockito.verify(userRepository, Mockito.times(1)).insertCodeToUser(1234, "testuser");
//    }
//
//    @Test
//    void testVerification() throws Exception {
//        // Set up test data
//        String whoisit = "testuser@example.com";
//        Integer systemCode = 1234;
//
//        // Mock UserRepository
//        UserRepository userRepository = mock(UserRepository.class);
//        when(userRepository.getCodeByEmail(whoisit)).thenReturn(systemCode);
//
//
//        // Verify that valid code returns redirect to "/"
//        mockMvc.perform(post("/verification").param("code", String.valueOf(systemCode)))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/login"));
//
//        // Verify that invalid code returns redirect to "/login"
//        mockMvc.perform(post("/verification").param("code", "9999"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/login"));
//    }
//



}