package com.bankingSOLID.service;

import com.bankingSOLID.models.Customers;
import com.bankingSOLID.models.Transactions;


public class TransactionsService {

    private static int nextId = 1;
    private int id;


    public void createTransaction(Customers customers, double amount, String transactionDescription, String debitOrCredit, String accountType) {
        id = nextId;
        nextId++;
        Transactions transaction = new Transactions(id, customers.getName(), amount, transactionDescription, debitOrCredit, accountType);
        customers.getTransactions().add(transaction);

    }

    public void getAllTransactions(Customers customers) {
        for(Transactions transaction : customers.getTransactions()) {
            System.out.println("------------------------------------");
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Account Username: " + transaction.getAccountUsername());
            System.out.println("Account: " + transaction.getAccountType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Transaction date: " + transaction.getTransactionDate());
            System.out.println("Transaction description: " + transaction.getTransactionDescription());
            System.out.println("Type: " + transaction.getTransactionType());
            System.out.println("------------------------------------");
        }
    }
}
