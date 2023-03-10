package com.example.stin.PageController;

import com.example.stin.Users.UserEntity;
import com.example.stin.Users.UserRepository;
import com.example.stin.Users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginPageController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserServices userServices;

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
//        String encodedPass = userRepo.encodePassword(password);
        if (userRepo.findByEmail(email) != null && userRepo.findByPassword(password) != null) {
//            userServices.sendCode();
            return "redirect:/verification";
        }

        return "redirect:/login";
    }


}
