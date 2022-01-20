package com.banking;

import java.time.LocalDate;

public class SavingAccount {

    private static int nextAccountNumber = 1;
    private int accountNumber;
    private double balance;
    private double interestRate;
    private LocalDate dateCreated;

    public SavingAccount() {
        this.accountNumber = nextAccountNumber++;
        this.balance = 0;
        this.interestRate = .35;
    }

    public void depositFunds(double amount, Customers customer) {
        balance += amount;
        this.dateCreated = LocalDate.now();
        customer.setTransactions(new Transactions(customer.getName(), amount, "Deposit", 3,2));
        seeFutureBalance();
    }

    public void withdrawFunds(double amount, Customers customer) {
        if(LocalDate.now().isBefore(dateCreated.plusYears(1)) ) {
            System.out.println("Need to spend at least one year to withdraw, until " + dateCreated.plusYears(1));

        }else{
            balance -= amount;
            customer.setTransactions(new Transactions(customer.getName(), amount, "Withdraw", 3,2));
        }

    }

    public void seeFutureBalance(){
        System.out.println("At one year your balance will be $" + balance * (1 + interestRate) + " MXN");
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

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}
