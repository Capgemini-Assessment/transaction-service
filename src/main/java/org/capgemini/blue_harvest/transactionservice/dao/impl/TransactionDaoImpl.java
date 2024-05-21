package org.capgemini.blue_harvest.transactionservice.dao.impl;

import java.util.List;

import org.capgemini.blue_harvest.transactionservice.constant.TransactionConstants;
import org.capgemini.blue_harvest.transactionservice.dao.TransactionDAO;
import org.capgemini.blue_harvest.transactionservice.entity.Transaction;
import org.capgemini.blue_harvest.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class TransactionDaoImpl implements TransactionDAO {

    private static final Logger logger = LoggerFactory.getLogger(TransactionDaoImpl.class);

    @Autowired
    private TransactionRepository repository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        try {
            logger.info(TransactionConstants.TRANSACTION_CREATION_STARTED, transaction);
            Transaction createdTransaction = repository.save(transaction);
            logger.info(TransactionConstants.TRANSACTION_CREATION_SUCCESSFUL, createdTransaction);
            return createdTransaction;
        } catch (Exception e) {
            logger.error(TransactionConstants.TRANSACTION_CREATION_FAILED, transaction, e);
            throw e;
        }
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        try {
            logger.info(TransactionConstants.TRANSACTION_FETCH_STARTED, accountId);
            List<Transaction> transactions = repository.findByAccountId(accountId);
            logger.info(TransactionConstants.TRANSACTION_FETCH_SUCCESSFUL, transactions.size(), accountId);
            return transactions;
        } catch (Exception e) {
            logger.error(TransactionConstants.TRANSACTION_FETCH_FAILED, accountId, e);
            throw e;
        }
    }
}
