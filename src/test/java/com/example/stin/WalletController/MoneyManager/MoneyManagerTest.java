package com.example.stin.WalletController.MoneyManager;

import com.example.stin.Bank.Account.AccountEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
    void testPayMoney2() {
        MoneyManager moneyManager = new MoneyManager();
        AccountEntity account = new AccountEntity();
        assertSame(account, moneyManager.payMoney(account, 10.0d, "GBP"));
    }

    @Test
    void testPayMoney3() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "CZK"));
    }

    @Test
    void testPayMoney4() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "USD"));
    }

    @Test
    void testPayMoney5() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "EUR"));
    }

    @Test
    void testPayMoney6() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(10.0d);
        AccountEntity actualPayMoneyResult = moneyManager.payMoney(account, 10.0d, (String) "EUR");
        assertSame(account, actualPayMoneyResult);
        assertEquals(0.0d, actualPayMoneyResult.getBalanceEUR().doubleValue());
    }

    @Test
    void testPayMoney7() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(10.0d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        AccountEntity actualPayMoneyResult = moneyManager.payMoney(account, 10.0d, (String) "USD");
        assertSame(account, actualPayMoneyResult);
        assertEquals(0.0d, actualPayMoneyResult.getBalanceUSD().doubleValue());
    }

    @Test
    void testPayMoney8() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(10.0d);
        account.setBalanceEUR(null);
        AccountEntity actualPayMoneyResult = moneyManager.payMoney(account, 10.0d, (String) "CZK");
        assertSame(account, actualPayMoneyResult);
        assertEquals(0.0d, actualPayMoneyResult.getBalanceCZK().doubleValue());
    }

    @Test
    void testPayMoney9() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(0.5d);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "CZK"));
    }

    @Test
    void testPayMoney11() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(0.5d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "USD"));
    }

    @Test
    void testPayMoney12() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(0.5d);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "EUR"));
    }

    @Test
    void testPayMoney16() {
        MoneyManager moneyManager = new MoneyManager();
        AccountEntity account = new AccountEntity();
        assertSame(account, moneyManager.payMoney(account, 10.0d, "GBP", "GBP"));
    }

    @Test
    void testPayMoney17() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "CZK", (String) "USD"));
    }

    @Test
    void testPayMoney18() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "CZK", (String) "EUR"));
    }

    @Test
    void testPayMoney19() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "CZK", (String) "CZK"));
    }


    @Test
    void testPayMoney22() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(10.0d);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "EUR", (String) "EUR"));
    }

    @Test
    void testPayMoney24() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(10.0d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "USD", (String) "USD"));
    }

    @Test
    void testPayMoney26() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(10.0d);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "CZK", (String) "CZK"));
    }

    @Test
    void testPayMoney29() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(-0.5d);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "CZK", (String) "CZK"));
    }


    @Test
    void testPayMoney31() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(-0.5d);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "EUR", (String) "EUR"));
    }

    @Test
    void testPayMoney32() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(10.0d);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "foo", (String) "EUR"));
    }

    @Test
    void testPayMoney33() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(-0.5d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertSame(account, moneyManager.payMoney(account, 10.0d, (String) "USD", (String) "USD"));
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
    void testIsEnoughMoney2() {
        MoneyManager moneyManager = new MoneyManager();
        assertFalse(moneyManager.isEnoughMoney(new AccountEntity(), 10.0d, "GBP"));
    }

    @Test
    void testIsEnoughMoney3() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, (String) "CZK"));
    }

    @Test
    void testIsEnoughMoney4() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, (String) "USD"));
    }

    @Test
    void testIsEnoughMoney5() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, (String) "EUR"));
    }

    @Test
    void testIsEnoughMoney6() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(10.0d);
        assertTrue(moneyManager.isEnoughMoney(account, 10.0d, (String) "EUR"));
    }

    @Test
    void testIsEnoughMoney7() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(10.0d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertTrue(moneyManager.isEnoughMoney(account, 10.0d, (String) "USD"));
    }

    @Test
    void testIsEnoughMoney8() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(10.0d);
        account.setBalanceEUR(null);
        assertTrue(moneyManager.isEnoughMoney(account, 10.0d, (String) "CZK"));
    }

    @Test
    void testIsEnoughMoney9() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(0.5d);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, (String) "CZK"));
    }

    @Test
    void testIsEnoughMoney11() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(0.5d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, (String) "USD"));
    }

    @Test
    void testIsEnoughMoney12() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(0.5d);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, (String) "EUR"));
    }

    @Test
    void testIsEnoughMoney16() {
        MoneyManager moneyManager = new MoneyManager();
        assertFalse(moneyManager.isEnoughMoney(new AccountEntity(), 10.0d, "GBP", "GBP"));
    }

    @Test
    void testIsEnoughMoney17() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "CZK"));
    }

    @Test
    void testIsEnoughMoney18() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "USD"));
    }

    @Test
    void testIsEnoughMoney19() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "EUR"));
    }

    @Test
    void testIsEnoughMoney20() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(10.0d);
        assertTrue(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "EUR"));
    }

    @Test
    void testIsEnoughMoney21() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(10.0d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertTrue(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "USD"));
    }

    @Test
    void testIsEnoughMoney22() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(10.0d);
        account.setBalanceEUR(null);
        assertTrue(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "CZK"));
    }

    @Test
    void testIsEnoughMoney23() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(-0.5d);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "CZK"));
    }
    @Test
    void testIsEnoughMoney26() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(-0.5d);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "CZK", (String) "CZK"));
    }

    @Test
    void testIsEnoughMoney29() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(-0.5d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "USD"));
    }

    @Test
    void testIsEnoughMoney30() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(-0.5d);
        account.setBalanceCZK(null);
        account.setBalanceEUR(null);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "USD", (String) "USD"));
    }

    @Test
    void testIsEnoughMoney33() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(-0.5d);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "foo", (String) "EUR"));
    }

    @Test
    void testIsEnoughMoney35() {
        MoneyManager moneyManager = new MoneyManager();

        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(null);
        account.setBalanceCZK(null);
        account.setBalanceEUR(-0.5d);
        assertFalse(moneyManager.isEnoughMoney(account, 10.0d, "EUR", (String) "EUR"));
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

    @Test
    void testPayMoneyWithTransferUsdToOther() {
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(1000.0);
        account.setBalanceUSD(200.0);
        account.setBalanceEUR(300.0);

        MoneyManager moneyManager = new MoneyManager();

        moneyManager.payMoney(account, 500.0, "USD", "CZK");
        assertEquals(1000, account.getBalanceCZK());

        moneyManager.payMoney(account, 300.0, "USD", "EUR");
        assertNotNull(account.getBalanceEUR());


    }

    @Test
    void testPayMoneyWithTransferEurToOther() {
        AccountEntity account = new AccountEntity();
        account.setBalanceCZK(1000.0);
        account.setBalanceUSD(200.0);
        account.setBalanceEUR(300.0);

        MoneyManager moneyManager = new MoneyManager();

        moneyManager.payMoney(account, 500.0, "EUR", "CZK");
        assertEquals(1000, account.getBalanceCZK());

        moneyManager.payMoney(account, 300.0, "EUR", "USD");
        assertNotNull(account.getBalanceUSD());



    }


}
