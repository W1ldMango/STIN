package com.example.stin.Bank.Transaction;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TransactionEntityTest {

    @Test
    void getId() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(1L);
        assertEquals(1L, transactionEntity.getId());
    }

    @Test
    void setId() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(1L);
        assertEquals(1L, transactionEntity.getId());
    }

    @Test
    void setAccountNumber() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountNumber(1L);
        assertEquals(1L, transactionEntity.getAccountNumber());
    }

    @Test
    void setCurrency() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCurrency("USD");
        assertEquals("USD", transactionEntity.getCurrency());
    }

    @Test
    void setAmount() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(1.0);
        assertEquals(1.0, transactionEntity.getAmount());
    }

    @Test
    void setType() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setType("Deposit");
        assertEquals("Deposit", transactionEntity.getType());
    }

    @Test
    void getDate() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setDate(Timestamp.valueOf("2020-01-01 00:00:00.0"));
        assertEquals("2020-01-01 00:00:00.0", transactionEntity.getDate());
    }

    @Test
    void setDate() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setDate(Timestamp.valueOf("2020-01-01 00:00:00.0"));
        assertEquals("2020-01-01 00:00:00.0", transactionEntity.getDate());
    }

    @Test
    void testEquals() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(1L);
        TransactionEntity transactionEntity1 = new TransactionEntity();
        transactionEntity1.setId(1L);
        assertEquals(transactionEntity, transactionEntity1);
    }

    @Test
    void canEqual() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(1L);
        TransactionEntity transactionEntity1 = new TransactionEntity();
        transactionEntity1.setId(1L);
        assertTrue(transactionEntity.canEqual(transactionEntity1));
    }

    @Test
    void testHashCode() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(1L);
        TransactionEntity transactionEntity1 = new TransactionEntity();
        transactionEntity1.setId(1L);
        assertEquals(transactionEntity.hashCode(), transactionEntity1.hashCode());
    }

    @Test
    void testToString() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(1L);
        transactionEntity.setAccountNumber(1L);
        transactionEntity.setCurrency("USD");
        transactionEntity.setAmount(1.0);
        transactionEntity.setType("Deposit");
        transactionEntity.setDate(Timestamp.valueOf("2020-01-01 00:00:00"));
        assertEquals("TransactionEntity(id=1, accountNumber=1, currency=USD, amount=1.0, type=Deposit, date=2020-01-01 00:00:00.0)", transactionEntity.toString());
    }
}