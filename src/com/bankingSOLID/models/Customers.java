package com.bankingSOLID.models;

import java.util.ArrayList;
import java.util.Comparator;

public class Customers {
    private int idCustomer;
    private String username;
    private String password;
    private String name;
    private String number;
    private ArrayList<Transactions> transactions = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();

    public Customers(int idCustomer, String username, String password, String name, String number) {
        this.idCustomer = idCustomer;
        this.username = username;
        this.password = password;
        this.name = name;
        this.number = number;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transactions> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        this.accounts.add(account);
    }
}
