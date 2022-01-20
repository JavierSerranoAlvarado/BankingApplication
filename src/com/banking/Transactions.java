package com.banking;

import java.util.Date;

public class Transactions {

    enum typesPaid{
        DEBIT, CREDIT, NOTAPLICABLE
    }

    enum typeAccounts{
        SAVINGS, CURRENT, MORTGAGE
    }

    private static int nextTransactionId = 1;
    private  int transactionId;
    private String accountUsername;
    private double amount;
    private String transactionDate;
    private String transactionDescription;
    private typesPaid typePaid;
    private typeAccounts typeAccount;

    public Transactions(String accountUsername, double amount, String transactionDescription, int debitOrCredit, int accountType) {
        this.transactionId = nextTransactionId++;
        this.accountUsername = accountUsername;
        this.amount = amount;
        this.transactionDate = new Date().toString();
        this.transactionDescription = transactionDescription;
            if(debitOrCredit == 1) this.typePaid = typesPaid.DEBIT;
            else if(debitOrCredit == 2) this.typePaid = typesPaid.CREDIT;
            else if(debitOrCredit == 3) this.typePaid = typesPaid.NOTAPLICABLE;
            else System.out.println("Invalid type");
            if(accountType == 1) this.typeAccount = typeAccounts.CURRENT;
            else if(accountType == 2) this.typeAccount = typeAccounts.SAVINGS;
            else if(accountType == 3) this.typeAccount = typeAccounts.MORTGAGE;
    }

    public void getTransactions(){
        System.out.println("------------------------------------");
        System.out.println("Transaction ID: " + this.transactionId);
        System.out.println("Account Username: " + accountUsername);
        System.out.println("Account: " + typeAccount);
        System.out.println("Amount: $" + amount + " MXN");
        System.out.println("TransactionDate: " + transactionDate);
        System.out.println("Transaction Description: " + transactionDescription);
        System.out.println("Type: " + typePaid);
        System.out.println("------------------------------------");
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        transactionId = transactionId;
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

    public typesPaid getType() {
        return typePaid;
    }

    public void setType(typesPaid type) {
        this.typePaid = type;
    }
}
