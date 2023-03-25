package com.example.stin.Bank.Transaction;

import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.Bank.Transaction.TransactionEntity;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.Date;

/**
    * This class is used to create a transaction
 */
@Controller
public class TransactionService {

    /**
        * This method is used to create a transaction
        * @param account - the account
        * @param currency - the currency
        * @param amount - the amount
        * @param type - the type
        * @return TransactionEntity - the transaction
     */
    public TransactionEntity CreateTransaction(AccountEntity account, String currency, Double amount, String type) {
        Date date = new Date();
        Timestamp formattedDate = new Timestamp(date.getTime());
        return new TransactionEntity(account.getAccountNumber(), currency, amount, type, formattedDate);
    }


}
