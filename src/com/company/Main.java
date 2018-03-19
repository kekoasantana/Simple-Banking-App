package com.company;
import java.util.Scanner;

/**
 * creating a simple banking app
 * should have a Bank class
 * should have an arrayList of Branches
 * each Branch should have an arrayList of Customers
 * Customer class should contain arrayList of Doubles (for transactions)
 * Customer:
 * Name, and ArrayList of doubles
 *
 * Branch:
 * Need to be able to add a new customer and initial transaction amount
 * also needs to be able to add additional transactions for that customer/branch
 *
 * Bank:
 * Add a new branch
 * Add a customer to that branch with initial transaction
 * Add a transaction for an existing customer for that branch
 * show a list of customers for a particular branch and optionally a list of their transactions
 *
 * Demonstrate autoboxing and unboxing in your code
 * Hint: transactions
 * add data validation by checking if it exists or does not exist
 */

/**
 * Up next:
 *
 * create scanner class to get input from user
 * create while loop to make this like an atm
 * this is all from the point of view from a bank teller so customer cannot see
 * that is why the teller can see the list of branches and bank users
 * ask what action they would like to perform:
 * 1. make new customer account
 * 2. make new branch
 * 3. make deposit
 * 4. make withdrawal
 * 5. list customers within bank
 * 6. exit
 */

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static int response;

    public static void main(String[] args) {
        boolean loop = true;
        Bank bank = new Bank("First Hawaiian Bank");
        Branch branch = new Branch("Wahiawa");

        while (loop) {
            System.out.printf("What function would you like to perform?\n" +
                    "1. Make new customer account\n" +
                    "2. Make new branch within Bank\n" +
                    "3. Make a deposit\n" +
                    "4. Make a withdrawal\n" +
                    "5. List customers within bank\n" +
                    "6. Exit\n");

            response = in.nextInt();
            in.nextLine();
            switch (response) {
                case 1:
                    System.out.println("Enter customer name, branch name and then initial deposit.");
                    bank.addCustomer(in.nextLine(), in.nextLine(), in.nextDouble());
                    in.nextLine();
                    break;
                case 2:
                    System.out.println("Enter branch name.");
                    bank.addBranch(in.nextLine());
                    break;
                case 3:
                    System.out.println("Enter customer name, branch name and then deposit amount.");
                    bank.makeCustomerDeposit(in.nextLine(), in.nextLine(), in.nextDouble());
                    in.nextLine();
                    break;
                case 4:
                    System.out.println("Enter customer name, branch name and then withdrawal amount.");
                    bank.makeCustomerWithdrawal(in.nextLine(), in.nextLine(), in.nextDouble());
                    in.nextLine();
                    break;
                case 5:
                    System.out.println("Enter branch name, then enter true or false " +
                            "if you want to see customer transactions and enter true or false again " +
                            "if you want to see customer balance.");
                    bank.listCustomers(in.nextLine(), in.nextBoolean(), in.nextBoolean());
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }
    }
}
