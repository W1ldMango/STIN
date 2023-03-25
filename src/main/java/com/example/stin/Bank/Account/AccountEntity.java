package com.example.stin.Bank.Account;

import jakarta.persistence.*;
import lombok.Data;


/**
    * This class is used to create a new account for a user.
    * It is used in the AccountController class.
 */
@Data
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    private Double balanceUSD;
    private Double balanceEUR;
    private Double balanceCZK;

    public AccountEntity() {
    }

    public AccountEntity(Long accountNumber, Double balanceUSD, Double balanceEUR, Double balanceCZK) {
        this.accountNumber = accountNumber;
        this.balanceUSD = balanceUSD;
        this.balanceEUR = balanceEUR;
        this.balanceCZK = balanceCZK;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalanceUSD() {
        return balanceUSD;
    }

    public void setBalanceUSD(Double balanceUSD) {
        this.balanceUSD = balanceUSD;
    }

    public Double getBalanceEUR() {
        return balanceEUR;
    }

    public void setBalanceEUR(Double balanceEUR) {
        this.balanceEUR = balanceEUR;
    }

    public Double getBalanceCZK() {
        return balanceCZK;
    }

    public void setBalanceCZK(Double balanceCZK) {
        this.balanceCZK = balanceCZK;
    }
}
