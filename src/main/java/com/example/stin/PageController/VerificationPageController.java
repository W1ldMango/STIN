package com.example.stin.PageController;

import com.example.stin.Mail.EmailDetails;
import com.example.stin.Mail.EmailService;
import com.example.stin.Users.UserEntity;
import com.example.stin.Users.UserRepository;
import com.example.stin.Users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Objects;

@Controller
public class VerificationPageController {

    private static String whoisit;

    @Autowired
    private EmailService emailService;


    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/verification")
    public String index(Principal principal) {
        whoisit = principal.getName();
        Integer temp_code = userServices.sendCode();
        emailService.sendSimpleMessage(new EmailDetails(whoisit, "Hello, your verification code is " + temp_code, "Your verification code is"));
        userRepository.insertCodeToUser(temp_code, whoisit);
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
