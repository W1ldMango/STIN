package com.example.stin.WalletController.MoneyManager;

import com.example.stin.Bank.Account.AccountEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MoneyManagerTest {


    @Test
    void testAddMoneyUSD() {
        // Arrange
        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(200.0);
        double moneyToAdd = 50.0;
        String currency = "USD";

        MoneyManager moneyManager = new MoneyManager();
        AccountEntity updatedAccount = moneyManager.addMoney(account, moneyToAdd, currency);

        assertEquals(account.getBalanceUSD(), updatedAccount.getBalanceUSD());
    }

    @Test
    void testAddMoneyEUR() {
        // Arrange
        AccountEntity account = new AccountEntity();
        account.setBalanceEUR(300.0);
        double moneyToAdd = 50.0;
        String currency = "EUR";

        MoneyManager moneyManager = new MoneyManager();
        AccountEntity updatedAccount = moneyManager.addMoney(account, moneyToAdd, currency);

        assertEquals(account.getBalanceEUR(), updatedAccount.getBalanceEUR());
    }

    @Test
    void testAddMoneyCZK() {
        // Arrange
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(100.0);
        double moneyToAdd = 50.0;
        String currency = "CZK";

        MoneyManager moneyManager = new MoneyManager();
        AccountEntity updatedAccount = moneyManager.addMoney(account, moneyToAdd, currency);

        assertEquals(account.getBalanceCZK(), updatedAccount.getBalanceCZK());
    }

    @Test
    void testAddMoneyWithTransferUSD() {
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(100.0);
        double moneyToAdd = 50.0;
        String currencyFrom = "USD";
        String currencyTo = "CZK";

        MoneyManager moneyManager = new MoneyManager();
        AccountEntity updatedAccount = moneyManager.addMoney(account, moneyToAdd, currencyFrom, currencyTo);

        assertEquals(account.getBalanceCZK(), updatedAccount.getBalanceCZK());
    }

    @Test
    void testAddMoneyWithTransferEUR() {
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(100.0);
        double moneyToAdd = 50.0;
        String currencyFrom = "EUR";
        String currencyTo = "CZK";

        MoneyManager moneyManager = new MoneyManager();
        AccountEntity updatedAccount = moneyManager.addMoney(account, moneyToAdd, currencyFrom, currencyTo);

        assertEquals(account.getBalanceCZK(), updatedAccount.getBalanceCZK());
    }

    @Test
    void testAddMoneyWithTransferCZK() {
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(100.0);
        double moneyToAdd = 50.0;
        String currencyFrom = "CZK";
        String currencyTo = "CZK";

        MoneyManager moneyManager = new MoneyManager();
        AccountEntity updatedAccount = moneyManager.addMoney(account, moneyToAdd, currencyFrom, currencyTo);

        assertEquals(account.getBalanceCZK(), updatedAccount.getBalanceCZK());
    }

    @Test
    void testPayMoney() {
        // create a new account with some initial balances
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(1000.0);
        account.setBalanceUSD(500.0);
        account.setBalanceEUR(200.0);

        // check that the account balances are correct
        assertEquals(1000, account.getBalanceCZK(), 0.01);
        assertEquals(500, account.getBalanceUSD(), 0.01);
        assertEquals(200, account.getBalanceEUR(), 0.01);

        MoneyManager moneyManager = new MoneyManager();

        // pay some money in CZK
        account = moneyManager.payMoney(account, 500, "CZK");

        // check that the balance in CZK has been reduced by the correct amount
        assertEquals(500, account.getBalanceCZK(), 0.01);

        // pay some money in USD
        account = moneyManager.payMoney(account, 200, "USD");

        // check that the balance in USD has been reduced by the correct amount
        assertEquals(300, account.getBalanceUSD(), 0.01);

        // try to pay too much money in EUR
        account = moneyManager.payMoney(account, 300, "EUR");

        // check that the balance in EUR has not been reduced
        assertEquals(200, account.getBalanceEUR(), 0.01);

        // check that the account balances are still correct
        assertEquals(500, account.getBalanceCZK(), 0.01);
        assertEquals(300, account.getBalanceUSD(), 0.01);
        assertEquals(200, account.getBalanceEUR(), 0.01);
    }

    @Test
    void testPayMoneyWithTransfer() {
        // Create an account with balances in all currencies
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(250.0);
        account.setBalanceUSD(1000.0);
        account.setBalanceEUR(500.0);

        MoneyManager moneyManager = new MoneyManager();

        // Test paying in CZK and transferring to USD
        AccountEntity result = moneyManager.payMoney(account, 500.0, "CZK", "USD");
        assertEquals(result.getBalanceUSD(), account.getBalanceUSD(), 0.0);

        // Test paying in CZK and transferring to EUR
        account = moneyManager.payMoney(account, 500, "CZK", "EUR");
        assertEquals(result.getBalanceEUR(), account.getBalanceEUR(), 0.01);

        // Test paying in USD and transferring to CZK
        account = moneyManager.payMoney(account, 500, "USD", "CZK");
        assertEquals(result.getBalanceCZK(), account.getBalanceCZK(), 0.01);


    }

    @Test
    public void testIsEnoughMoney() {
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(1000.0);
        MoneyManager service = new MoneyManager();

        assertTrue(service.isEnoughMoney(account, 500.0, "CZK"));
        assertFalse(service.isEnoughMoney(account, 1500.0, "CZK"));
        assertFalse(service.isEnoughMoney(account, 500.0, "USD"));
    }

    @Test
    void testIsEnoughMoneyWithTransfer() {
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(1000.0);
        account.setBalanceUSD(200.0);
        account.setBalanceEUR(300.0);

        MoneyManager moneyManager = new MoneyManager();

        assertTrue(moneyManager.isEnoughMoney(account, 500.0, "CZK", "USD"));
        assertTrue(moneyManager.isEnoughMoney(account, 300.0, "USD", "EUR"));
        assertFalse(moneyManager.isEnoughMoney(account, 100.0, "EUR", "CZK"));
        assertFalse(moneyManager.isEnoughMoney(account, 10000.0, "CZK", "USD"));
    }


}
