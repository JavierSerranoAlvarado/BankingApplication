package com.bankingSOLID.service;

import com.bankingSOLID.models.Account;
import com.bankingSOLID.models.CurrentAccount;
import com.bankingSOLID.models.Customers;
import com.bankingSOLID.models.SavingAccount;

public class AccountService {
    TransactionsService transactionsService = new TransactionsService();

    private static int nextId = 1;
    private int id;

    public boolean createAccount(double balance, Customers customer, String accountType) {
        id = nextId;

        switch (accountType) {
            case "Current":
                CurrentAccount ca = new CurrentAccount(id, balance);
                customer.getAccounts().add(ca);
                transactionsService.createTransaction(customer, 0, "Account created", "debit", "Current");
                nextId++;
                return true;
            case "Saving":
                SavingAccount sa = new SavingAccount(id, balance);
                customer.getAccounts().add(sa);
                transactionsService.createTransaction(customer, 0, "Account created", "debit", "Saving");
                nextId++;
                return true;
        }
        return false;
    }

    public boolean deposit(double amount, Customers customer, String accountType) {
        for (Account account : customer.getAccounts()) {
            if(account.getAccountName().equals(accountType)) {
                transactionsService.createTransaction(customer, amount, "Deposit", "debit", accountType);
                account.setBalance(account.getBalance() + amount);
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(double amount, Customers customer, String accountType) {
        for (Account account : customer.getAccounts()) {
            if(account.getAccountName().equals(accountType)) {
                transactionsService.createTransaction(customer, amount, "withdraw", "debit", accountType);
                account.setBalance(account.getBalance() - amount);
                return true;
            }
        }
        return false;
    }

    public boolean transfer(double amount, Customers customer, int idCustomer, String accountType2) {
        CustomerService customerService = new CustomerService();
        Customers customer2 = customerService.getCustomer(idCustomer);

        for (Account account : customer.getAccounts()) {
            if(account.getAccountName().equals("Current")) {
                for (Account account2 : customer2.getAccounts()) {
                    if(account2.getAccountName().equals("Current")) {
                        transactionsService.createTransaction(customer, amount, "Transfer", "debit", accountType);
                        transactionsService.createTransaction(customer2, amount, "Transfer", "credit", accountType2);
                        account.setBalance(account.getBalance() - amount);
                        account2.setBalance(account2.getBalance() + amount);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
