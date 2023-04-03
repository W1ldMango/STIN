package com.example.stin.PageController;

import com.example.stin.Mail.EmailDetails;
import com.example.stin.Mail.EmailService;
import com.example.stin.Users.UserInterface.UserRepository;
import com.example.stin.Users.UserServices.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

/**
    * This class is used to handle the verification page
 */
@Controller
public class VerificationPageController {

    public static String whoisit;

    @Autowired
    private EmailService emailService;


    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired
    private UserRepository userRepository;

    /**
        * This method is used to display the verification page
        * To send the verification code to the user email
        * To insert the verification code to the database
     */
    @GetMapping("/verification")
    public String index(Principal principal) {
        whoisit = principal.getName();
        Integer temp_code = codeGenerator.sendCode();
        emailService.sendSimpleMessage(new EmailDetails(whoisit, "Hello, your verification code is " + temp_code, "Your verification code is"));
        userRepository.insertCodeToUser(temp_code, whoisit);
        return "verification";
    }

    /**
        * This method is used to process the verification code
        * @RequestParam code - the verification code
        * @return redirect to main page if the code is correct
        * @return redirect to login page if the code is incorrect
     */
    @PostMapping("/verification")
    public String verification(@RequestParam(value = "code", required = false) Integer code) {
        Integer SystemCode = userRepository.getCodeByEmail(whoisit);
        if (Objects.equals(code, SystemCode)) {
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
