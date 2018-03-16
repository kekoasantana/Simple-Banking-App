package com.company;

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

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Bank of Hawaii");

        bank.addBranch("Wahiawa");

        bank.addCustomer("Kekoa", "Wahiawa", 50.50);
        bank.addCustomer("Jim", "Wahiawa", 34.75);
        bank.addCustomer("Kekoa", "Wahiawa", 42.50);
        bank.addCustomer("Bob", "Honolulu", 52.50);


        bank.addBranch("Pearl City");
        bank.addCustomer("Henry", "Pearl City", 56.83);

        bank.addCustomerTransaction("Kekoa", "Wahiawa", 43.54);
        bank.addCustomerTransaction("Jim", "Wahiawa", 33.56);

        bank.listCustomers("Wahiawa", true);
        bank.listCustomers("Honolulu", false);
        bank.listCustomers("Pearl City", false);
    }
}
