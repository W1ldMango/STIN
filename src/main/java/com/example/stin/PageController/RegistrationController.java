package com.example.stin.PageController;

import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
    * This class is used to handle the registration page
    * Created only for backend purposes
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
        * This method is used to display the registration page
        * @return String - the registration page
     */
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /**
        * This method is used to process the registration request
        * @ModelAttribute UserEntity userEntity - the user entity
        * @return String - the registration page
     */
    @PostMapping("/registration")
    public String registrationPost(@ModelAttribute UserEntity userEntity, HttpSession session) {
        if (userEntity != null) {
            userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
            userRepo.save(userEntity);
            session.setAttribute("user", userEntity);
        }
        return "registration";
    }

}
