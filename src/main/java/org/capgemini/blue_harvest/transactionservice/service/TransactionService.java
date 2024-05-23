package org.capgemini.blue_harvest.transactionservice.service;

import java.util.List;

import org.capgemini.blue_harvest.transactionservice.model.Transaction;
import org.capgemini.blue_harvest.transactionservice.model.TransactionRequest;

public interface TransactionService {

	public Transaction createTransaction(TransactionRequest transactionRequest);

	public List<Transaction> getTransactionByAccountId(int accountId);

}
