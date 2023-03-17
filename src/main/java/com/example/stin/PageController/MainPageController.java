package com.example.stin.PageController;

import com.example.stin.Users.UserEntity;
import com.example.stin.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MainPageController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String index() {
        return "main";
    }

    //How to get the current user's details in a controller?
    //https://stackoverflow.com/questions/480214/how-do-you-remove-duplicates-from-a-list-in-java


    @ModelAttribute
    public void getUserDetails(Model model, Principal principal) {
        String email = principal.getName();
        UserEntity user = userRepository.findByEmail(email);
        model.addAttribute("user", user);
    }
}
