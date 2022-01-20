package com.banking;

public class CurrentAccount {

    private static int nextAccountNumber = 1;
    private int accountNumber;
    private double balance;

    public CurrentAccount(double balance) {
        this.accountNumber = nextAccountNumber++;
        this.balance = balance;

    }

    public void deposit(double amount, Customers customer, int debitOrCredit) {
        this.balance += amount;
        customer.setTransactions(new Transactions(customer.getName(), amount, "Deposit", debitOrCredit,1));
    }

    public void withdraw(double amount, Customers customer, int debitOrCredit) {
        if(this.balance < amount) {
            System.out.println("Insufficient funds");
        } else{
            this.balance -= amount;
            customer.setTransactions(new Transactions(customer.getName(), amount, "Withdraw", debitOrCredit,1));
        }

    }

    public double getBalance() {
        return balance;
    }


}
