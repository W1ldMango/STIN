package com.example.stin.Bank.Transaction;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

/**
    * This class is used to create a new transaction for a user.
    * It is used in the TransactionController class.
 */
@Data
@Entity
@Table(name = "transactions")
public class TransactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private String currency;
    private Double amount;
    private String type;
    private Timestamp date;

    public TransactionEntity() {
    }

    public TransactionEntity(Long accountNumber, String currency, Double amount, String type, Timestamp date) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
        this.type = type;
        this.date = date;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return String.valueOf(date);
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


}
