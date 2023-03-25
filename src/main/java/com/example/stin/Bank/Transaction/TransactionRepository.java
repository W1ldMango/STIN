package com.example.stin.Bank.Transaction;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
    * This class connects to the database and allows us to use the methods
 */
@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {


    /**
        * This method is used to find all transactions by account number.
     */
    @Query(value = "SELECT * FROM transactions WHERE account_number = ?1", nativeQuery = true)
    List<TransactionEntity> findAllByUserId(Long id);

}
