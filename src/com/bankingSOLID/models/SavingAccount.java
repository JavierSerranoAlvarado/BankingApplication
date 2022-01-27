package com.bankingSOLID.models;

public class SavingAccount extends Account {

    private double interestRate;

    public SavingAccount(int id, double balance) {
        super(id, balance, "Saving" );
        this.interestRate = 0.35;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


}
