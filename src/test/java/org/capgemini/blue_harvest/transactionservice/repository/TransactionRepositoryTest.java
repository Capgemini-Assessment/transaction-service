package org.capgemini.blue_harvest.transactionservice.repository;
import org.capgemini.blue_harvest.transactionservice.entity.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        // Initialize test data
        Transaction transaction1 = new Transaction();
        transaction1.setAccountId(1);
        transaction1.setAmount(100.0);
        transaction1.setType("CREDIT");
        transaction1.setTransactionDate(LocalDateTime.now());

        Transaction transaction2 = new Transaction();
        transaction2.setAccountId(1);
        transaction2.setAmount(50.0);
        transaction2.setType("DEBIT");
        transaction2.setTransactionDate(LocalDateTime.now());

        Transaction transaction3 = new Transaction();
        transaction3.setAccountId(2);
        transaction3.setAmount(200.0);
        transaction3.setType("CREDIT");
        transaction3.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);
        transactionRepository.save(transaction3);
    }

    @Test
    void testFindByAccountId() {
        List<Transaction> transactions = transactionRepository.findByAccountId(1);
        assertThat(transactions).hasSize(2);
        assertThat(transactions.get(0).getAccountId()).isEqualTo(1);
        assertThat(transactions.get(1).getAccountId()).isEqualTo(1);
    }

    @Test
    void testFindByAccountId_NoResults() {
        List<Transaction> transactions = transactionRepository.findByAccountId(999);
        assertThat(transactions).isEmpty();
    }
}