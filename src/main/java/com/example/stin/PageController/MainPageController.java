package com.example.stin.PageController;

import com.example.stin.Bank.AccountEntity;
import com.example.stin.Bank.AccountRepository;
import com.example.stin.CurencyData.CNBData;
import com.example.stin.CurencyData.CurrencyChange;
import com.example.stin.MoneyController.MoneyManager;
import com.example.stin.Users.UserEntity;
import com.example.stin.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MainPageController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("money", "0");
        model.addAttribute("count", "0");
        model.addAttribute("pay", "0");
        model.addAttribute("add", "0");
        model.addAttribute("select", "0");
        model.addAttribute("usd", "0");
        model.addAttribute("czk", "0");
        model.addAttribute("eur", "0");

        return "main";
    }

    @PostMapping(value = "/button")
    public String indexPost(@RequestParam String count,
                            @RequestParam(required = false) String money,
//                            @RequestParam(required = false) String money1,
                            @RequestParam(required = false) String currency_list,
                            Model model, Principal principal) {
        UserEntity user = (UserEntity) model.getAttribute("user");
        MoneyManager moneyManager = new MoneyManager();
        AccountEntity acc = accountRepository.findAllById(user.getId());
        if (count != null) {
            if (money.equals("pay")) {
                moneyManager.payMoney(acc, Double.parseDouble(count), currency_list);
                accountRepository.save(acc);
            } else if (money.equals("add")) {
                moneyManager.addMoney(acc, Double.parseDouble(count), currency_list);
                accountRepository.save(acc);
            }
        }

        return "redirect:/";
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
