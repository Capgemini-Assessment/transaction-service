package org.capgemini.blue_harvest.transactionservice.dao.impl;
import org.capgemini.blue_harvest.transactionservice.constant.TransactionConstants;
import org.capgemini.blue_harvest.transactionservice.entity.Transaction;
import org.capgemini.blue_harvest.transactionservice.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionDaoImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionDaoImpl transactionDao;

    private Transaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transaction = new Transaction();
        transaction.setId(1);
        transaction.setAccountId(1);
        transaction.setAmount(100.0);
        transaction.setType("CREDIT");
        transaction.setTransactionDate(LocalDateTime.now());
    }

    @Test
    void testCreateTransaction_Success() {
        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);

        Transaction createdTransaction = transactionDao.createTransaction(transaction);

        assertThat(createdTransaction).isNotNull();
        assertThat(createdTransaction.getId()).isEqualTo(1);
        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void testCreateTransaction_Exception() {
        when(transactionRepository.save(any(Transaction.class))).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> {
            transactionDao.createTransaction(transaction);
        });

        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void testGetTransactionsByAccountId_Success() {
        List<Transaction> transactions = Arrays.asList(transaction);
        when(transactionRepository.findByAccountId(anyInt())).thenReturn(transactions);

        List<Transaction> fetchedTransactions = transactionDao.getTransactionsByAccountId(1);

        assertThat(fetchedTransactions).isNotEmpty();
        assertThat(fetchedTransactions.size()).isEqualTo(1);
        verify(transactionRepository, times(1)).findByAccountId(1);
    }

    @Test
    void testGetTransactionsByAccountId_Exception() {
        when(transactionRepository.findByAccountId(anyInt())).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> {
            transactionDao.getTransactionsByAccountId(1);
        });

        verify(transactionRepository, times(1)).findByAccountId(1);
    }
}