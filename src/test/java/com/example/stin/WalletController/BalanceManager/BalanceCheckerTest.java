package com.example.stin.WalletController.BalanceManager;

import com.example.stin.Bank.Account.AccountEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceCheckerTest {

    @Test
    void testIsBalanceExist() {
        // Create an account entity with a balance of 100 CZK
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(100.0);

        // Test with valid currency
        assertEquals(100.0, BalanceChecker.isBalanceExist(account, "CZK"), 0.001);

        // Test with null balance
        account.setBalanceUSD(null);
        assertEquals(0.0, BalanceChecker.isBalanceExist(account, "USD"), 0.001);

        // Test with invalid currency
        assertNull(BalanceChecker.isBalanceExist(account, "ABC"));
    }

}