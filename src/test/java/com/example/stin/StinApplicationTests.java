package com.example.stin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@AutoConfigureWebMvc
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(StinApplication.class)
class StinApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Test
//    void mainTest() {
//        StinApplication.main(new String[] {});
//    }



}
