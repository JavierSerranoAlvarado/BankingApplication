package com.banking;

import java.util.ArrayList;

public class Customers {
    private static int nextId = 1;
    private int idCustomer;
    private String username;
    private String password;
    private String name;
    private String number;
    private int HouseValor;


    CurrentAccount currentAccount;
    MortgageAccount mortgageAccount;
    SavingAccount savingAccount;

    ArrayList<Transactions> transactions = new ArrayList<Transactions>();

    public Customers(String username, String password, String name, String number, double deposit, int debitOrCredit) {
        this.idCustomer = nextId++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.number = number;
        this.currentAccount = new CurrentAccount(deposit);
        this.transactions.add(new Transactions(name, deposit, "Deposit Initial", debitOrCredit,1));
        this.savingAccount = new SavingAccount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getHouseValor() {
        return HouseValor;
    }

    public void setHouseValor(int houseValor) {
        HouseValor = houseValor;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public MortgageAccount getMortgageAccount() {
        return mortgageAccount;
    }

    public void setMortgageAccount(MortgageAccount mortgageAccount) {
        this.mortgageAccount = mortgageAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        idCustomer = idCustomer;
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions.add(transactions);
    }
}
