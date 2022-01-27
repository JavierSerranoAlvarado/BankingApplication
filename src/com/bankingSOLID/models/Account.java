package com.bankingSOLID.models;

import java.time.LocalDate;

public abstract class Account {
    private int id;
    private int accountNumber;
    private double balance;
    private String accountName;

    public Account(int id, double balance, String accountName) {
        this.id = id;
        this.accountNumber = id;
        this.balance = balance;
        this.accountName = accountName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
