package com.example.stin;

import com.example.stin.PageController.LoginPageController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static javax.swing.UIManager.get;
import static org.springframework.security.config.http.MatcherType.mvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ComponentScan(basePackages = {"com.example.stin"})
class StinApplicationTests {

    //Test if the context loads
    @Test
    void contextLoads() {


    }

    @Test
    void isLoginPageAlive() {
        LoginPageController loginPageController = new LoginPageController();
        String response = loginPageController.index();
        assert response.equals("login");
    }

//    @Test
//    void isLoginSuccessful() {
//        LoginPageController loginPageController = new LoginPageController();
//        String response = loginPageController.logout();
//        assert response.equals("redirect:/login");
//    }

}
