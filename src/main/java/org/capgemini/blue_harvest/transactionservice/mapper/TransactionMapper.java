package org.capgemini.blue_harvest.transactionservice.mapper;

import org.capgemini.blue_harvest.transactionservice.entity.Transaction;
import org.capgemini.blue_harvest.transactionservice.model.TransactionRequest;

public class TransactionMapper {
	
	public Transaction mapToTransaction(TransactionRequest request) {
		Transaction transaction = new Transaction();
		transaction.setAccountId(request.getAccountId());
		transaction.setAmount(request.getAmount());
		transaction.setTransactionDate(request.getTransactionDate());
		transaction.setType(request.getType());
		return transaction;
	}
	
	public org.capgemini.blue_harvest.transactionservice.model.Transaction mapToModel(Transaction entity){
		org.capgemini.blue_harvest.transactionservice.model.Transaction model = new org.capgemini.blue_harvest.transactionservice.model.Transaction();
		model.setAccountId(entity.getAccountId());
		model.setAmount(entity.getAmount());
		model.setTransactionDate(entity.getTransactionDate());
		model.setId(entity.getId());
		model.setType(entity.getType());		
		return model;
	}
}
