package org.capgemini.blue_harvest.transactionservice.service.impl;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.capgemini.blue_harvest.transactionservice.constant.TransactionConstants;
import org.capgemini.blue_harvest.transactionservice.dao.TransactionDAO;
import org.capgemini.blue_harvest.transactionservice.mapper.TransactionMapper;
import org.capgemini.blue_harvest.transactionservice.model.Transaction;
import org.capgemini.blue_harvest.transactionservice.model.TransactionRequest;
import org.capgemini.blue_harvest.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	TransactionDAO dao;

	@Override
	public Transaction createTransaction(TransactionRequest transactionRequest) {
		logger.info(TransactionConstants.TRANSACTION_FETCH_REQUEST_MESSAGE, transactionRequest.getAccountId());
		TransactionMapper mapper = new TransactionMapper();
		return mapper.mapToModel(dao.createTransaction(mapper.mapToTransaction(transactionRequest)));
	}

	@Override
	public List<Transaction> getTransactionByAccountId(int accountId) {
		logger.info(TransactionConstants.TRANSACTION_FETCH_REQUEST_MESSAGE , accountId);
		TransactionMapper mapper = new TransactionMapper();
		List<Transaction> transactionList = new ArrayList<>();
		dao.getTransactionsByAccountId(accountId).forEach(transaction -> {
			transactionList.add(mapper.mapToModel(transaction));
		});
		return transactionList;
	}
}