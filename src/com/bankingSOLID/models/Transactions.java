package com.bankingSOLID.models;

import java.util.Date;

public class Transactions {

    private  int transactionId;
    private String accountUsername;
    private double amount;
    private String transactionDate;
    private String transactionDescription;
    private String transactionType;
    private String accountType;

    public Transactions(int id, String accountUsername, double amount, String transactionDescription, String debitOrCredit, String accountType) {
        this.transactionId = id;
        this.accountUsername = accountUsername;
        this.amount = amount;
        this.transactionDate = new Date().toString();
        this.transactionDescription = transactionDescription;
        this.transactionType = debitOrCredit;
        this.accountType = accountType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
