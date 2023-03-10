package com.example.stin.PageController;

import com.example.stin.Users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class VerificationPageController {


    @Autowired
    private UserServices userServices;

    @GetMapping("/verification")
    public String index() {
//        System.out.println(userServices.sendCode());
        return "verification";
    }

//    @PostMapping("/verification")
//    public String verification(int code) {
////        int SystemCode = userServices.sendCode();
//        if (code == SystemCode) {
//            return "redirect:/";
//        }
//        return "redirect:/verification";
//    }
}
