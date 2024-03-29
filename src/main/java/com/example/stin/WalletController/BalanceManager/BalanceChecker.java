package com.example.stin.WalletController.BalanceManager;

import com.example.stin.Bank.Account.AccountEntity;

/**
    * This class is used to check if the balance is not null
 */
public class BalanceChecker {

    /**
     * This method is used to check if the balance is not null and return the balance in the currency
     * @param acc - the account
     * @param currency - the currency
     * @return Double - the balance in the currency
     */
    public static Double isBalanceExist(AccountEntity acc, String currency) {
        try {
            if (currency.equals("USD")) {
                if (acc.getBalanceUSD() != null) {
                    return acc.getBalanceUSD();
                } else {
                    return (double) 0;
                }
            } else if (currency.equals("EUR")) {
                if (acc.getBalanceEUR() != null) {
                    return acc.getBalanceEUR();
                } else {
                    return (double) 0;
                }
            } else if (currency.equals("CZK")) {
                if (acc.getBalanceCZK() != null) {
                    return acc.getBalanceCZK();
                } else {
                    return (double) 0;
                }
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }

}
