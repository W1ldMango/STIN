package com.example.stin.WalletController.MoneyManager;

import com.example.stin.CurencyData.CNBData;

/*
    * This class is used to exchange money
 */
public class MoneyExchange {

    public static double exchangeMoney(double money, String currency, String transferCurrency) {
        CNBData cnbData = new CNBData();
        double exchangeRate = cnbData.getExchangeRate(currency, transferCurrency);
        return money * exchangeRate;
    }
}
