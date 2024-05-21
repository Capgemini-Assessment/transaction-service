package org.capgemini.blue_harvest.transactionservice.dao;

import java.util.List;

import org.capgemini.blue_harvest.transactionservice.entity.Transaction;

public interface TransactionDAO {
	public Transaction createTransaction(Transaction transaction);
	public List<Transaction> getTransactionsByAccountId(int acountId);
}
