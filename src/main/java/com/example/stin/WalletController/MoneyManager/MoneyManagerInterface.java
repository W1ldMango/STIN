package com.example.stin.WalletController.MoneyManager;

import com.example.stin.Bank.Account.AccountEntity;


/**
    * Interface for money management
 */
public interface MoneyManagerInterface {

    public AccountEntity addMoney(AccountEntity account, double money, String currency);
    public AccountEntity addMoney(AccountEntity account, double money, String currency, String transferCurrency);
    public AccountEntity payMoney(AccountEntity account, double money, String currency);
    public AccountEntity payMoney(AccountEntity account, double money, String currency, String transferCurrency);
    public boolean isEnoughMoney(AccountEntity account, double money, String currency);
    public boolean isEnoughMoney(AccountEntity account, double money, String currency, String transferCurrency);
}
