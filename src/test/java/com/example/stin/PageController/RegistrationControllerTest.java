package com.example.stin.PageController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@AutoConfigureWebMvc
class RegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testRegistrationPost() throws Exception {
        // Create a mock UserEntity object
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("testuser@gmail.com");
        userEntity.setPassword("testpassword");

        // Perform a POST request to the "/registration" endpoint with the mock UserEntity object
        mockMvc.perform(MockMvcRequestBuilders.post("/registration")
                        .flashAttr("userEntity", userEntity))
                // Verify that the response has a success status code
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Verify that the expected view is returned
                .andExpect(MockMvcResultMatchers.view().name("registration"));

        // Verify that the UserEntity object is saved to the database with the correct password
        Mockito.verify(userRepo, Mockito.times(1)).save(Mockito.argThat(savedUserEntity ->
                savedUserEntity.getEmail().equals("testuser@gmail.com")
                        && bCryptPasswordEncoder.matches("testpassword", savedUserEntity.getPassword())));
    }
    @Test
    void testRegistration() {
        assertEquals("registration", (new RegistrationController()).registration());
    }

}

