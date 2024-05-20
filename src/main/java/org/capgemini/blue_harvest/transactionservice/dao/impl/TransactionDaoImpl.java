package org.capgemini.blue_harvest.transactionservice.dao.impl;

import java.util.List;

import org.capgemini.blue_harvest.transactionservice.dao.TransactionDAO;
import org.capgemini.blue_harvest.transactionservice.entity.Transaction;
import org.capgemini.blue_harvest.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionDaoImpl implements TransactionDAO {
	
	@Autowired
	private TransactionRepository repository; 

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return repository.save(transaction);
	}

	@Override
	public List<Transaction> getTransactionsByAccountId(int accountId) {
		return repository.findByAccountId(accountId);
	}

}
