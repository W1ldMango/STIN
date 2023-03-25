package com.example.stin.WalletController.MoneyManager;

import org.junit.jupiter.api.Test;

public class MoneyExchangeTest {

    private static MoneyExchange moneyExchange = new MoneyExchange();
    @Test
    void isMoneyExchangeWorking() {
        assert moneyExchange.exchangeMoney(13, "USD", "EUR") >= 10.5;
    }

    @Test
    void isMoneyExchangeWorking2() {
        assert moneyExchange.exchangeMoney(1, "USD", "EUR") <= 1.1;
    }

    @Test
    void isMoneyExchangeWorking3() {
        assert moneyExchange.exchangeMoney(1, "EUR", "USD") >= 0.9;
    }

    @Test
    void isMoneyExchangeWorking4() {
        assert moneyExchange.exchangeMoney(1, "EUR", "CZK") >= 22;
    }

    @Test
    void isMoneyExchangeWorking5() {
        assert moneyExchange.exchangeMoney(1, "CZK", "EUR") <= 0.045;
    }
}
