package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    // Used to add a branch within the Bank
    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    // Calls on Branch class to add customer to the branch within the bank
    public boolean addCustomer(String customerName, String branchName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    // Adds a customer deposit, calls on the Branch class, which calls on the Customer class
    public boolean makeCustomerDeposit(String customerName, String branchName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.makeCustomerDeposit(customerName, amount);
        }
        return false;
    }

    // Adds a customer withdrawal, calls on the Branch class, which calls on the Customer class
    public boolean makeCustomerWithdrawal(String customerName, String branchName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.makeCustomerWithdrawal(customerName, amount);
        }
        return false;
    }

    // Finds branch within the Bank class and then returns the location
    private Branch findBranch (String branchName) {
        for (Branch checkedBranch : this.branches) {
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    // Lists out all customers and transactions within a branch if it exists
    public boolean listCustomers(String branchName, boolean showTransactions, boolean showBalance) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customers for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions) {
                    System.out.println("Deposits");
                    ArrayList<Double> deposits = branchCustomer.getDeposits();
                    for (int j = 0; j < deposits.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + deposits.get(j));
                    }
                    System.out.println("Withdrawals");
                    ArrayList<Double> withdrawals = branchCustomer.getWithdrawals();
                    for (int z = 0; z < withdrawals.size(); z++) {
                        System.out.println("[" + (z+1) + "] Amount " + withdrawals.get(z));
                    }
                }
                if (showBalance) {
                    System.out.println("Balance: " + branchCustomer.getBalance());
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
