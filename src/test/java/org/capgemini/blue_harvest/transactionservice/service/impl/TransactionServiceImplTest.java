package org.capgemini.blue_harvest.transactionservice.service.impl;
import org.capgemini.blue_harvest.transactionservice.dao.TransactionDAO;
import org.capgemini.blue_harvest.transactionservice.entity.Transaction;
import org.capgemini.blue_harvest.transactionservice.model.TransactionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TransactionServiceImplTest {

    @Mock
    private TransactionDAO dao;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private TransactionRequest transactionRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionRequest = new TransactionRequest();
        transactionRequest.setAccountId(1);
        transactionRequest.setAmount(100.0);
        transactionRequest.setType("CREDIT");
        transactionRequest.setTransactionDate(LocalDateTime.now());
    }

    @Test
    void testCreateTransaction_Success() {
        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setAccountId(1);
        transaction.setAmount(100.0);
        transaction.setType("CREDIT");
        transaction.setTransactionDate(LocalDateTime.now());

        when(dao.createTransaction(any())).thenReturn(transaction);

        
        org.capgemini.blue_harvest.transactionservice.model.Transaction createdTransaction = transactionService.createTransaction(transactionRequest);

        assertThat(createdTransaction).isNotNull();
        assertThat(createdTransaction.getId()).isEqualTo(1);
        verify(dao, times(1)).createTransaction(any());
    }

    @Test
    void testGetTransactionByAccountId_Success() {
        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setAccountId(1);
        transaction.setAmount(100.0);
        transaction.setType("CREDIT");
        transaction.setTransactionDate(LocalDateTime.now());

        List<Transaction> transactions = Arrays.asList(transaction);

        when(dao.getTransactionsByAccountId(1)).thenReturn(transactions);

        List<org.capgemini.blue_harvest.transactionservice.model.Transaction> fetchedTransactions = transactionService.getTransactionByAccountId(1);

        assertThat(fetchedTransactions).isNotEmpty();
        assertThat(fetchedTransactions.size()).isEqualTo(1);
        verify(dao, times(1)).getTransactionsByAccountId(1);
    }
}