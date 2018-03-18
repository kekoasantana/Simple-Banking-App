package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private double balance;
    private ArrayList<Double> deposits;
    private ArrayList<Double> withdrawals;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.deposits = new ArrayList<Double>();
        makeDeposit(initialAmount);
        this.withdrawals = new ArrayList<Double>();
    }

    public void makeDeposit(double amount) {
        this.deposits.add(amount);
        this.balance += amount;
    }

    public void makeWithdrawal(double amount) {
        if (amount - this.balance < 0) {            // makes sure that balance does not go below zero
            this.withdrawals.add(amount);
            this.balance -= amount;
        } else {
            System.out.println("Insufficient funds. Cannot make withdrawal.");
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getDeposits() {
        return deposits;
    }

    public ArrayList<Double> getWithdrawals() {
        return withdrawals;
    }

    public double getBalance() {
        return balance;
    }
}
