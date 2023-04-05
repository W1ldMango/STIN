package com.example.stin.PageController;

import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.catalina.connector.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

//@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWebMvc
@WebMvcTest(LoginPageController.class)
class LoginPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testIndex() {
        assertEquals("login", (new LoginPageController()).index());
    }

    @Test
    void testLogout() {
        LoginPageController loginPageController = new LoginPageController();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("redirect:/login", loginPageController.logout(request, new Response()));
    }

    @Test
    void testLogout2() {
        LoginPageController loginPageController = new LoginPageController();
        HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
        assertEquals("redirect:/login", loginPageController.logout(request, new Response()));
    }

    @Test
    public void testLogout3() throws Exception {
        // Perform a GET request to the "/logout" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/logout"))
                // Verify that the response has a redirect status code
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

        // Verify that the authentication object is null after the logout request has been processed
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Assert.assertNull(auth);
    }


}
