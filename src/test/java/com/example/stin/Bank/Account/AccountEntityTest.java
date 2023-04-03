package com.example.stin.Bank.Account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountEntityTest {

    @Test
    void getId() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        assertEquals(1L, accountEntity.getId());
    }

    @Test
    void setId() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        assertEquals(1L, accountEntity.getId());
    }

    @Test
    void testEquals() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        AccountEntity accountEntity1 = new AccountEntity();
        accountEntity1.setId(1L);
        assertEquals(accountEntity, accountEntity1);
    }

    @Test
    void canEqual() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        AccountEntity accountEntity1 = new AccountEntity();
        accountEntity1.setId(1L);
        assertTrue(accountEntity.canEqual(accountEntity1));
    }

    @Test
    void testHashCode() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        AccountEntity accountEntity1 = new AccountEntity();
        accountEntity1.setId(1L);
        assertEquals(accountEntity.hashCode(), accountEntity1.hashCode());
    }

    @Test
    void testToString() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        accountEntity.setAccountNumber(1L);
        accountEntity.setBalanceUSD(1.0);
        accountEntity.setBalanceEUR(1.0);
        accountEntity.setBalanceCZK(1.0);
        assertEquals("AccountEntity(id=1, accountNumber=1, balanceUSD=1.0, balanceEUR=1.0, balanceCZK=1.0)", accountEntity.toString());
    }

    @Test
    void AccountEntity() {
        AccountEntity accountEntity = new AccountEntity(1L, 1.0, 1.0, 1.0);
        assertNotNull(accountEntity);
    }
}