package com.banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Customers> customersList = new ArrayList<>();
    public static Customers customerLoggedIn;

    public static void main(String[] args) {

        Customers customer = new Customers( "asd", "123", "Javier", "5537751318", 30000,2);
        customersList.add(customer);

        UImenu();
    }

    public static void UImenu(){

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Hello to the best Bank");
            System.out.println("What do you want to do?");
            System.out.println("1- Create an account 2- Log in an account 3- Exit");

            choice = Integer.valueOf(sc.nextLine());
            switch (choice){
                case 1:
                    UIcreateAccount();
                    break;
                case 2:
                    UIlogin();
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

    public static void UIcreateAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.nextLine();
        System.out.println("What is your phone number?");
        String phone = sc.nextLine();
        System.out.println("What is your initial deposit?");
        double deposit = Double.valueOf(sc.nextLine());
        System.out.println("What will be your method of payment.? \n1-Debit 2-Credit");
        int method = Integer.valueOf(sc.nextLine());
        System.out.println("Set your username");
        String username = sc.nextLine();
        System.out.println("set your password");
        String password = sc.nextLine();
        Customers customer = new Customers( username, password, name, phone, deposit, method);
        customersList.add(customer);
        System.out.println("Account created!");
        UIlogin();
    }

    public static void UIlogin(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter your username");
        String username = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        for (Customers c : customersList){
            if (c.getUsername().equals(username) && c.getPassword().equals(password)){
                customerLoggedIn = c;
                System.out.println("Welcome " + customerLoggedIn.getName());
                System.out.println("Your balance in current account is $" + customerLoggedIn.currentAccount.getBalance()+ " MXN");
                System.out.println("Your balance in saving account is $" + customerLoggedIn.savingAccount.getBalance()+ " MXN");

                int choice;

                do{
                System.out.println("1- Deposit 2- Withdraw 3- See all transactions 4- Log out");
                choice = sc.nextInt();
                switch (choice){
                    case 1:
                        UIdeposit();
                        break;
                    case 2:
                        UIwithdraw();
                        break;
                    case 3:
                        for(Transactions t : customerLoggedIn.getTransactions()){
                            t.getTransactions();
                        }
                        break;
                    case 4:
                        customerLoggedIn = null;
                        System.out.println("Bye bye");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                } while (choice != 4);

            }
            }
        }

        public static void UIdeposit(){
            Scanner sc = new Scanner(System.in);
            System.out.println("How much do you want to deposit?");
            double deposit = Double.valueOf(sc.nextLine());
            System.out.println("To which account? \n1-Current 2-Saving ");
            int account = Integer.valueOf(sc.nextLine());
            switch (account){
                case 1:
                    customerLoggedIn.currentAccount.deposit(deposit, customerLoggedIn, 1);
                    System.out.println("Your Current Account balance is $" + customerLoggedIn.currentAccount.getBalance()+ " MXN");
                    break;
                case 2:
                    customerLoggedIn.savingAccount.depositFunds(deposit,customerLoggedIn);
                    System.out.println("Your Saving Account balance is $" + customerLoggedIn.savingAccount.getBalance()+ " MXN");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }

        public static void UIwithdraw(){
            Scanner sc = new Scanner(System.in);
            System.out.println("How much do you want to withdraw?");
            double withdraw = Double.valueOf(sc.nextLine());
            System.out.println("To which account? \n1-Current 2-Saving ");
            int account = Integer.valueOf(sc.nextLine());
            switch (account){
                case 1:
                    customerLoggedIn.currentAccount.withdraw(withdraw, customerLoggedIn, 1);
                    System.out.println("Your Current Account balance is $" + customerLoggedIn.currentAccount.getBalance()+ " MXN");
                    break;
                case 2:
                    customerLoggedIn.savingAccount.withdrawFunds(withdraw, customerLoggedIn);
                    System.out.println("Your Saving Account balance is $" + customerLoggedIn.savingAccount.getBalance()+ " MXN");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }


