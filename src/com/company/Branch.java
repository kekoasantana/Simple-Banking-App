package com.company;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    // Used to add a new customer, checks if customer is in system and if not then adds a new customer
    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    // Makes sure customer exists in the branch and then makes a deposit for that customer
    public boolean makeCustomerDeposit(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.makeDeposit(amount);
            return true;
        }
        return false;
    }

    // Makes sure customer exists in the branch and then makes a withdrawal for that customer
    public boolean makeCustomerWithdrawal(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.makeWithdrawal(amount);
            return true;
        }
        return false;
    }

    // finds a customer and returns the customer location
    private Customer findCustomer(String customerName) {
        for (Customer checkedCustomer : this.customers) {
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
}
