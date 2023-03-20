package com.example.stin.PageController;

import com.example.stin.Bank.AccountEntity;
import com.example.stin.Bank.AccountRepository;
import com.example.stin.CurencyData.CNBData;
import com.example.stin.CurencyData.CurrencyChange;
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

    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/")
    public String index() {

        return "main";
    }



    @ModelAttribute
    public void getUserDetails(Model model, Principal principal) {
        String email = principal.getName();
        UserEntity user = userRepository.findByEmail(email);
        AccountEntity accountInfo = accountRepository.findAllById(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("account", accountInfo);
    }

    @ModelAttribute
    public void getCNBData(Model model) {
        CNBData cnbData = new CNBData();
        model.addAttribute("USD", cnbData.getUSD());
        model.addAttribute("EUR", cnbData.getEUR());
        model.addAttribute("GBP", cnbData.getGBP());
        model.addAttribute("isValid", cnbData.isDataActual());

    }

    @ModelAttribute
    public void getCurrencyChanges(Model model) {
        CurrencyChange getCurrencyChanges = new CurrencyChange();
        model.addAttribute("euroChanges", getCurrencyChanges.euroChanges());
        model.addAttribute("usdChanges", getCurrencyChanges.usdChanges());
        model.addAttribute("gbpChanges", getCurrencyChanges.gbpChanges());
    }
}
