package com.bankingSOLID.UIMenu;

import com.banking.Transactions;
import com.bankingSOLID.models.Customers;
import com.bankingSOLID.service.CustomerService;

import java.util.Scanner;

public class UIMenu {

    private CustomerService customerService;

    public UIMenu(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        UIMenu uiMenu = new UIMenu(new CustomerService());
        uiMenu.UImenu();
    }

    public void UImenu(){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Hello to the best Bank");
            System.out.println("What do you want to do?");
            System.out.println("1- Create an account 2- Log in an account 3- Exit");

            choice = Integer.valueOf(sc.nextLine());
            switch (choice){
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while (choice != 3);
    }

    public void createAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Set your username");
        String username = sc.nextLine();
        System.out.println("set your password");
        String password = sc.nextLine();
        System.out.println("What is your name?");
        String name = sc.nextLine();
        System.out.println("What is your phone number?");
        String phone = sc.nextLine();
        CustomerService customerService = new CustomerService();
        customerService.addCustomer(name, password, username, phone);
        login();
    }

    public void login(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your username");
        String username = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        Customers customer = customerService.getCustomer(username, password);
        if (customer != null){
                CustomerMenu.customerLoggedIn = customer;
                CustomerMenu.customerMenu();
        } else {
            System.out.println("Invalid username or password");
        }
    }
}
