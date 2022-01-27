package com.bankingSOLID.UIMenu;

import com.banking.Transactions;
import com.bankingSOLID.models.Account;
import com.bankingSOLID.models.CurrentAccount;
import com.bankingSOLID.models.Customers;
import com.bankingSOLID.service.AccountService;
import com.bankingSOLID.service.TransactionsService;

import java.util.Scanner;

public class CustomerMenu {

    public static Customers customerLoggedIn;

    public static void customerMenu(){
        System.out.println("hello customer " + customerLoggedIn.getName());
        System.out.println("Welcome " + customerLoggedIn.getName());

        int choice;
        Scanner sc = new Scanner(System.in);

        do{
            for(Account c : customerLoggedIn.getAccounts()){
                System.out.println("Your balance in " + c.getAccountName() + " account is " + " $" + c.getBalance());
            }
            System.out.println("1- Deposit 2- Withdraw 3- Transfer 4- See all transactions 5- Log out");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    UIDesposit();
                    break;
                case 2:
                    UIWithdraw();
                    break;
                case 3:
                    UITransfer();
                    break;
                case 4:
                    TransactionsService transactionsService = new TransactionsService();
                    transactionsService.getAllTransactions(customerLoggedIn);
                    break;
                case 5:
                    customerLoggedIn = null;
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (choice != 4);
    }

    public static void UIDesposit(){
        AccountService accountService = new AccountService();

        Scanner sc = new Scanner(System.in);
        System.out.println("To which account? \n1-Current 2-Saving ");
        int account = Integer.valueOf(sc.nextLine());
        System.out.println("How much do you want to deposit?");
        double deposit = Double.valueOf(sc.nextLine());

        switch (account){
            case 1:
                if(accountService.deposit(deposit, customerLoggedIn, "Current")){
                    System.out.println("Deposit successful");
                }else{
                    System.out.println("Deposit failed");
                }
                break;
            case 2:
                if(accountService.deposit(deposit, customerLoggedIn, "Saving")){
                    System.out.println("Deposit successful");
                }else{
                    System.out.println("Deposit failed");
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    public static void UIWithdraw(){
        AccountService accountService = new AccountService();

        Scanner sc = new Scanner(System.in);
        System.out.println("To which account? \n1-Current 2-Saving ");
        int account = Integer.valueOf(sc.nextLine());
        System.out.println("How much do you want to withdraw?");
        double deposit = Double.valueOf(sc.nextLine());

        switch (account){
            case 1:
                if(accountService.withdraw(deposit, customerLoggedIn, "Current")){
                    System.out.println("withdraw successful");
                }else{
                    System.out.println("withdraw failed");
                }
                break;
            case 2:
                if(accountService.withdraw(deposit, customerLoggedIn, "Saving")){
                    System.out.println("withdraw successful");
                }else{
                    System.out.println("withdraw failed");
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    public static void UITransfer(){
        AccountService accountService = new AccountService();

        Scanner sc = new Scanner(System.in);
        System.out.println("You can only transfer money from your current account");
        int account = Integer.valueOf(sc.nextLine());
        System.out.println("How much do you want to withdraw?");
        double deposit = Double.valueOf(sc.nextLine());
        System.out.println("To which Id Account?");
        double idAccount = Double.valueOf(sc.nextLine());
        accountService.transfer(deposit, customerLoggedIn, idAccount, "Current", "Saving");

        switch (account){
            case 1:
                if(accountService.withdraw(deposit, customerLoggedIn, "Current")){
                    System.out.println("withdraw successful");
                }else{
                    System.out.println("withdraw failed");
                }
                break;
            case 2:
                if(accountService.withdraw(deposit, customerLoggedIn, "Saving")){
                    System.out.println("withdraw successful");
                }else{
                    System.out.println("withdraw failed");
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }
}
