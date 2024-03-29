package com.example.stin.PageController;

import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.Bank.Account.AccountRepository;
import com.example.stin.Bank.Transaction.TransactionEntity;
import com.example.stin.Bank.Transaction.TransactionRepository;
import com.example.stin.CurencyData.CNBData;
import com.example.stin.CurencyData.CurrencyChange;
import com.example.stin.WalletController.BalanceManager.BalanceChecker;
import com.example.stin.WalletController.MoneyManager.MoneyManager;
import com.example.stin.Bank.Transaction.TransactionService;
import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


/**
    * This class is used to handle the main page
 */
@Controller
public class MainPageController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    /**
        * This method is used to display the main page
        * @return String - the main page
     */
    @GetMapping("/")
    public String index() {
        return "main";
    }

    /**
        * This method is used to process Addmoney button and Pay button
        * @RequestParam amount - the amount of money
        * @RequestParam payment_type - the type of button (Addmoney or Pay)
        * @RequestParam currency_list - the currency
        * @RequestParam transfer - the currency to transfer
     */
    @PostMapping(value = "/button")
    public String indexPost(@RequestParam String amount,
                            @RequestParam(required = false) String payment_type,
                            @RequestParam(required = false) String currency_list,
                            @RequestParam(required = false) String transfer,
                            Model model) {
        UserEntity user = (UserEntity) model.getAttribute("user");
        AccountEntity acc = accountRepository.findAllById(user.getId());
        process(amount, payment_type, currency_list, transfer, acc);
        return "redirect:/";
    }
    public void process(String amount,
                        String payment_type,
                        String currency_list,
                        String transfer,
                        AccountEntity account) {
        MoneyManager moneyManager = new MoneyManager();
        TransactionService transactionService = new TransactionService();
        if ((amount != null) && (transfer.equals(currency_list))) {
            if (payment_type.equals("Payment") && moneyManager.isEnoughMoney(account, Double.parseDouble(amount), currency_list)) {
                moneyManager.payMoney(account, Double.parseDouble(amount), currency_list);
                accountRepository.save(account);
                transactionRepository.save(transactionService.CreateTransaction(account, currency_list, Double.parseDouble(amount), payment_type));
            } else if (((BalanceChecker.isBalanceExist(account,currency_list)) > 0) && (payment_type.equals("Adding"))) {
                moneyManager.addMoney(account, Double.parseDouble(amount), currency_list);
                accountRepository.save(account);
                transactionRepository.save(transactionService.CreateTransaction(account, currency_list, Double.parseDouble(amount), payment_type));
            }
        } else if ((amount != null) && (BalanceChecker.isBalanceExist(account, transfer) > 0)) {
            if (payment_type.equals("Payment")) {
                moneyManager.payMoney(account, Double.parseDouble(amount), currency_list, transfer);
                accountRepository.save(account);
                transactionRepository.save(transactionService.CreateTransaction(account, currency_list, Double.parseDouble(amount), payment_type));
            } else if (payment_type.equals("Adding")) {
                moneyManager.addMoney(account, Double.parseDouble(amount), currency_list, transfer);
                accountRepository.save(account);
                transactionRepository.save(transactionService.CreateTransaction(account, currency_list, Double.parseDouble(amount), payment_type));
            }
        }

    }

    /**
        * This method is used to add USER attributes to the model and display the main page
     */
    @ModelAttribute
    public void getUserDetails(Model model, Principal principal) {
        String email = principal.getName();
        UserEntity user = userRepository.findByEmail(email);
        AccountEntity accountInfo = accountRepository.findAllById(user.getId());
        List<TransactionEntity> transactionEntityList = transactionRepository.findAllByUserId(accountInfo.getAccountNumber());
        model.addAttribute("user", user);
        model.addAttribute("account", accountInfo);
        model.addAttribute("usdBalance", BalanceChecker.isBalanceExist(accountInfo, "USD"));
        model.addAttribute("eurBalance", BalanceChecker.isBalanceExist(accountInfo, "EUR"));
        model.addAttribute("czkBalance", BalanceChecker.isBalanceExist(accountInfo, "CZK"));
        model.addAttribute("transaction", transactionEntityList);
    }

    /**
        * This method is used to add CNB attributes to the model and display the main page
     */
    @ModelAttribute
    public void getCNBData(Model model) {
        CNBData cnbData = new CNBData();
        model.addAttribute("USD", cnbData.getUSD());
        model.addAttribute("EUR", cnbData.getEUR());
        model.addAttribute("GBP", cnbData.getGBP());
        model.addAttribute("isValid", cnbData.isDataActual());

    }

    /**
        * This method is used to add CurrencyChange attributes to the model and display the main page
     */
    @ModelAttribute
    public void getCurrencyChanges(Model model) {
        CurrencyChange getCurrencyChanges = new CurrencyChange();
        model.addAttribute("euroChanges", getCurrencyChanges.euroChanges());
        model.addAttribute("usdChanges", getCurrencyChanges.usdChanges());
        model.addAttribute("gbpChanges", getCurrencyChanges.gbpChanges());
    }
}
