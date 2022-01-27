package com.bankingSOLID.service;

import com.bankingSOLID.models.Customers;

import java.util.ArrayList;

public class CustomerService {

    public static ArrayList<com.bankingSOLID.models.Customers> customers = new ArrayList<>();
    private static int id = 1;

    public void addCustomer( String username, String password, String name, String number) {
        AccountService accountService = new AccountService();
        System.out.println("Customer added successfully");
        Customers customer = new Customers(id, username,  password,  name,  number);
        accountService.createAccount(0, customer, "Current");
        accountService.createAccount(0, customer, "Saving");
        id++;
        customers.add(customer);
        System.out.println("Account created!");
    }


    public Customers getCustomer(String username, String password) {
        for (Customers customer : customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return customer;
            }
            }
        return null;
        }

    public void deleteCustomer(int id) {
        System.out.println("Customer deleted successfully");
        customers.remove(id);
    }

    public void updateCustomer(int id, String username, String password, String name, String number) {
        System.out.println("Customer updated successfully");
        Customers customer = new Customers(id, username,  password,  name,  number);
        customers.set(id, customer);
    }
    public void getAllCustomers() {
        System.out.println("All customers found successfully");
        for (Customers customer : customers) {
            System.out.println(customer);
        }
    }

}
