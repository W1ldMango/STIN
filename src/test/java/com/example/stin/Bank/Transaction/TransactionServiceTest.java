package com.example.stin.Bank.Transaction;

import com.example.stin.Bank.Account.AccountEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionServiceTest {



    @Test
    void testCreateTransaction() {
        AccountEntity account = new AccountEntity();
        account.setAccountNumber(Long.valueOf("123456789"));

        // Call the CreateTransaction method with some sample inputs
        TransactionEntity transaction = new TransactionEntity(account.getAccountNumber(), "USD", 50.0, "Withdrawal", null);

        // Assert that the returned TransactionEntity object has the correct values
        assertEquals(Long.valueOf("123456789"), transaction.getAccountNumber());
        assertEquals("USD", transaction.getCurrency());
        assertEquals(50.0, transaction.getAmount(), 0.0);
        assertEquals("Withdrawal", transaction.getType());
    }

}