package com.example.stin.WalletController.MoneyManager;

import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.WalletController.BalanceManager.BalanceChecker;

/**
    * This class is used to provide transactions with money.
 */

public class MoneyManager implements MoneyManagerInterface{

    /**
        * This method is used to add money to the account
        * @param account - account to which the money will be added
        * @param money - amount of money to be added
        * @param currency - currency of the money to be added
        * @return account - account with added money
     */
    public AccountEntity addMoney(AccountEntity account, double money, String currency) {
        if (BalanceChecker.isBalanceExist(account, currency) > 0){
            switch (currency) {
                case "CZK" -> account.setBalanceCZK(account.getBalanceCZK() + money);
                case "USD" -> account.setBalanceUSD(account.getBalanceUSD() + money);
                case "EUR" -> account.setBalanceEUR(account.getBalanceEUR() + money);
            }
        }
        return account;
    }

    /**
        * This method is used to add money from the one balance to another
        * @param account - account to which the money will be added
        * @param money - amount of money to be added
        * @param currency - currency of the money that used
        * @param transferCurrency - currency of the money that will be added
        * @return account - account with added money
     */
    @Override
    public AccountEntity addMoney(AccountEntity account, double money, String currency, String transferCurrency) {
        System.out.println(BalanceChecker.isBalanceExist(account, transferCurrency));
        System.out.println(BalanceChecker.isBalanceExist(account, currency));
        if (BalanceChecker.isBalanceExist(account, currency) > 0) {
            switch (currency) {
                case "CZK" -> {
                    if (transferCurrency.equals("USD")) {
                        account.setBalanceCZK(account.getBalanceCZK() - money);
                        account.setBalanceUSD(account.getBalanceUSD() + MoneyExchange.exchangeMoney(money, "CZK", "USD"));
                    } else if (transferCurrency.equals("EUR")) {
                        account.setBalanceCZK(account.getBalanceCZK() - money);
                        account.setBalanceEUR(account.getBalanceEUR() - MoneyExchange.exchangeMoney(money, "CZK", "EUR"));
                    }
                }
                case "USD" -> {
                    if (transferCurrency.equals("CZK")) {
                        account.setBalanceUSD(account.getBalanceUSD() - money);
                        account.setBalanceCZK(account.getBalanceCZK() + MoneyExchange.exchangeMoney(money, "USD", "CZK"));
                    } else if (transferCurrency.equals("EUR")) {
                        account.setBalanceUSD(account.getBalanceUSD() - money);
                        account.setBalanceEUR(account.getBalanceEUR() + MoneyExchange.exchangeMoney(money, "USD", "EUR"));
                    }
                }
                case "EUR" -> {
                    if (transferCurrency.equals("CZK")) {
                        account.setBalanceEUR(account.getBalanceEUR() - money);
                        account.setBalanceCZK(account.getBalanceCZK() + MoneyExchange.exchangeMoney(money, "EUR", "CZK"));
                    } else if (transferCurrency.equals("USD")) {
                        account.setBalanceEUR(account.getBalanceEUR() - money);
                        account.setBalanceUSD(account.getBalanceUSD() + MoneyExchange.exchangeMoney(money, "EUR", "USD"));
                    }
                }
            }
        } else {
            switch (currency) {
                case "CZK" -> {
                    if (transferCurrency.equals("USD")) {
                        account.setBalanceUSD(account.getBalanceUSD() + MoneyExchange.exchangeMoney(money, "CZK", "USD"));
                    } else if (transferCurrency.equals("EUR")) {
                        account.setBalanceEUR(account.getBalanceEUR() + MoneyExchange.exchangeMoney(money, "CZK", "EUR"));
                    }
                }
                case "USD" -> {
                    if (transferCurrency.equals("CZK")) {
                        account.setBalanceCZK(account.getBalanceCZK() + MoneyExchange.exchangeMoney(money, "USD", "CZK"));
                    } else if (transferCurrency.equals("EUR")) {
                        account.setBalanceEUR(account.getBalanceEUR() + MoneyExchange.exchangeMoney(money, "USD", "EUR"));
                    }
                }
                case "EUR" -> {
                    if (transferCurrency.equals("CZK")) {
                        account.setBalanceCZK(account.getBalanceCZK() + MoneyExchange.exchangeMoney(money, "EUR", "CZK"));
                    } else if (transferCurrency.equals("USD")) {
                        account.setBalanceUSD(account.getBalanceUSD() + MoneyExchange.exchangeMoney(money, "EUR", "USD"));
                    }
                }
            }
        }
        return account;
    }

    /**
        * This method is used to pay money from the account
        * @param account - account from which the money will be paid
        * @param money - amount of money to be paid
        * @param currency - currency of the money to be paid
        * @return account - account with paid money
     */
    @Override
    public AccountEntity payMoney(AccountEntity account, double money, String currency) {
        if (isEnoughMoney(account, money, currency)) {
            switch (currency) {
                case "CZK" -> account.setBalanceCZK(account.getBalanceCZK() - money);
                case "USD" -> account.setBalanceUSD(account.getBalanceUSD() - money);
                case "EUR" -> account.setBalanceEUR(account.getBalanceEUR() - money);
            }
        }
        return account;
    }

    /**
        * This method is used to pay money from the account
        * @param account - account from which the money will be paid
        * @param money - amount of money to be paid
        * @param currency - currency of the money that used
        * @param transferCurrency - currency of the money that will be paid
        * @return account - account with paid money
     */

    @Override
    public AccountEntity payMoney(AccountEntity account, double money, String currency, String transferCurrency) {
        if (isEnoughMoney(account, money, currency, transferCurrency)) {
            switch (currency) {
                case "CZK" -> {
                    if (transferCurrency.equals("USD")) {
                        account.setBalanceUSD(account.getBalanceUSD() - MoneyExchange.exchangeMoney(money, "CZK", "USD"));
                    } else if (transferCurrency.equals("EUR")) {
                        account.setBalanceEUR(account.getBalanceEUR() - MoneyExchange.exchangeMoney(money, "CZK", "EUR"));
                    }
                }
                case "USD" -> {
                    if (transferCurrency.equals("CZK")) {
                        account.setBalanceCZK(account.getBalanceCZK() - MoneyExchange.exchangeMoney(money, "USD", "CZK"));
                    } else if (transferCurrency.equals("EUR")) {
                        account.setBalanceEUR(account.getBalanceEUR() - MoneyExchange.exchangeMoney(money, "USD", "EUR"));
                    }
                }
                case "EUR" -> {
                    if (transferCurrency.equals("CZK")) {
                        account.setBalanceCZK(account.getBalanceCZK() - MoneyExchange.exchangeMoney(money, "EUR", "CZK"));
                    } else if (transferCurrency.equals("USD")) {
                        account.setBalanceUSD(account.getBalanceUSD() - MoneyExchange.exchangeMoney(money, "EUR", "USD"));
                    }
                }
            }
        }
        return account;
    }

    /**
        * This method is used to check if the account has enough money
        * @param account - account to be checked
        * @param money - amount of money to be checked
        * @param currency - currency of the money to be checked
        * @return boolean - true if the account has enough money, false if not
     */
    @Override
    public boolean isEnoughMoney(AccountEntity account, double money, String currency) {
        switch (currency) {
            case "CZK" -> {
                if ((account.getBalanceCZK() != null) && (account.getBalanceCZK() >= money)) {
                    return true;
                }
            }
            case "USD" -> {
                if ((account.getBalanceUSD() != null) && (account.getBalanceUSD() >= money)) {
                    return true;
                }
            }
            case "EUR" -> {
                if ((account.getBalanceEUR() != null) && (account.getBalanceEUR() >= money)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
        * This method is used to check if the account has enough money
        * @param account - account to be checked
        * @param money - amount of money to be checked
        * @param currency - currency of the money that used
        * @param transferCurrency - currency of the money that will be paid
        * @return boolean - true if the account has enough money, false if not
     */
    @Override
    public boolean isEnoughMoney(AccountEntity account, double money, String currency, String transferCurrency) {
        switch (transferCurrency) {
            case "CZK" -> {
                if ((account.getBalanceCZK() != null) && (account.getBalanceCZK() >= MoneyExchange.exchangeMoney(money, currency, "CZK"))) {
                    return true;
                }
            }
            case "USD" -> {
                if ((account.getBalanceUSD() != null) && (account.getBalanceUSD() >= MoneyExchange.exchangeMoney(money, currency, "USD"))) {
                    return true;
                }
            }
            case "EUR" -> {
                if ((account.getBalanceEUR() != null) && (account.getBalanceEUR() >= MoneyExchange.exchangeMoney(money, currency, "EUR"))) {
                    return true;
                }
            }
        }
        return false;
    }
}
