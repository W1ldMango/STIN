package com.example.stin.PageController;

import com.example.stin.Mail.EmailDetails;
import com.example.stin.Mail.EmailService;
import com.example.stin.Users.UserEntity;
import com.example.stin.Users.UserRepository;
import com.example.stin.Users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginPageController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserServices userServices;

    @Autowired
    private EmailService emailService;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        System.out.println(userRepo.findByEmail(email));
        System.out.println(userRepo.findByEmail(email).getPassword());
        System.out.println(bCryptPasswordEncoder.matches(password, userRepo.findByEmail(email).getPassword()));
        if ((userRepo.findByEmail(email) != null) && (bCryptPasswordEncoder.matches(password, userRepo.findByEmail(email).getPassword()))) {
            Integer temp_code = userServices.sendCode();
//            emailService.sendSimpleMessage(new EmailDetails(email, "Hello, your verification code is " + temp_code, "Your verification code is"));
            userRepo.insertCodeToUser(temp_code, email);
            return "redirect:/verification?email=" + email;
//            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }


}
