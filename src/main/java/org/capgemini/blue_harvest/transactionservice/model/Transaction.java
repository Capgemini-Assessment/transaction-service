package org.capgemini.blue_harvest.transactionservice.model;
import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private int accountId;
    private double amount;
    private String type;
    private LocalDateTime transactionDate;
    public Transaction() {}

    public Transaction(int accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}

