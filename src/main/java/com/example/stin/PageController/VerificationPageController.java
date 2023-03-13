package com.example.stin.PageController;

import com.example.stin.Users.UserRepository;
import com.example.stin.Users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class VerificationPageController {

    private static String whoisit;


    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/verification")
    public String index(@RequestParam(value = "email", required = false) String email) {
        whoisit = email;
        return "verification";
    }


    @PostMapping("/verification")
    public String verification(@RequestParam(value = "code", required = false) Integer code) {
        Integer SystemCode = userRepository.getCodeByEmail(whoisit);
        if (Objects.equals(code, SystemCode)) {
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
