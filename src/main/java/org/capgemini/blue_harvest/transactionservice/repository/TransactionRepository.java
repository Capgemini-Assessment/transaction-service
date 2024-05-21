package org.capgemini.blue_harvest.transactionservice.repository;

import java.util.List;

import org.capgemini.blue_harvest.transactionservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByAccountId(int accountId);
}
