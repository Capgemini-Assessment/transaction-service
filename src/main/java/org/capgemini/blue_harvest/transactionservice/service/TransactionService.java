package org.capgemini.blue_harvest.transactionservice.service;

import java.util.List;

import org.capgemini.blue_harvest.transactionservice.model.Transaction;
import org.capgemini.blue_harvest.transactionservice.model.TransactionRequest;

public interface TransactionService {
	
	Transaction createTransaction(TransactionRequest transactionRequest);

	List<Transaction> getTransactionByAccountId(int accountId);

}
