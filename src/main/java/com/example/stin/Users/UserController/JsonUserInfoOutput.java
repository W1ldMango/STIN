package com.example.stin.Users.UserController;


import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.Bank.Account.AccountRepository;
import com.example.stin.Bank.Transaction.TransactionEntity;
import com.example.stin.Bank.Transaction.TransactionRepository;
import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


/**
    * This class is used to output the user's information in JSON format
 */

@RestController
public class JsonUserInfoOutput {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    /**
        * This method is used to output the user's information in JSON format
        * @param principal - the user's email
        * @param model - the model
        * @return String - the JSON page
     */
    @RequestMapping(value = "/json", produces = "application/json")
    public String json(Principal principal) {
        String email = principal.getName();
        UserEntity user = userRepository.findByEmail(email);
        AccountEntity account = accountRepository.findAllById(user.getId());
        List<TransactionEntity> transactions = transactionRepository.findAllByUserId(account.getAccountNumber());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", user.getName());
        jsonObject.put("surname", user.getSurname());
        jsonObject.put("email", user.getEmail());
        jsonObject.put("accountNumber", account.getAccountNumber());
        jsonObject.put("balanceUSD", account.getBalanceUSD());
        jsonObject.put("balanceEUR", account.getBalanceEUR());
        jsonObject.put("balanceCZK", account.getBalanceCZK());
        jsonObject.put("transactions", transactions);
        return jsonObject.toString();
    }


}
