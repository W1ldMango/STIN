package com.example.stin.Bank.Account;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
    * This class connects to the database and allows us to use the methods
 */
@Repository
@Transactional
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    /**
        * This method is used to find all accounts by their id.
     */
    @Query(value = "select * from accounts where id=?", nativeQuery = true)
    AccountEntity findAllById(Long id);

    /**
        * This method update the balance of the account in USD.
     */
    @Modifying
    @Query(value = "update accounts set balanceUSD=? where id=?", nativeQuery = true)
    AccountEntity UpdateBalanceUSD(Double balanceUSD, Long id);


    /**
        * This method update the balance of the account in EUR.
     */
    @Modifying
    @Query(value = "update accounts set balanceEUR=? where id=?", nativeQuery = true)
    AccountEntity UpdateBalanceEUR(Double balanceEUR, Long id);


    /**
        * This method update the balance of the account in CZK.
     */
    @Modifying
    @Query(value = "update accounts set balanceCZK=? where id=?", nativeQuery = true)
    AccountEntity UpdateBalanceCZK(Double balanceCZK, Long id);

}
