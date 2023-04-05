package com.example.stin.Bank.Transaction;

import com.example.stin.Bank.Account.AccountEntity;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;


class TransactionServiceTest {


    @Test
    void createTransaction() {
        TransactionService transactionService = new TransactionService();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(1L);
        String currency = "USD";
        Double amount = 1.0;
        String type = "Deposit";
        Assertions.assertNotNull(transactionService.CreateTransaction(accountEntity, currency, amount, type));

    }
}
