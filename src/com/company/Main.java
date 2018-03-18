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

/**
 * Up next:
 *
 * create scanner class to get input from user
 * create while loop to make this like an atm
 * this is all from the point of view from a bank teller so customer cannot see
 * that is why the teller can see the list of branches and bank users
 * ask what action they would like to perform:
 * 1. make deposit
 * 2. make withdrawal
 * 3. show balance
 * 4. list customers within bank
 */

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Bank of Hawaii");

        bank.addBranch("Wahiawa");

        bank.addCustomer("Kekoa", "Wahiawa", 200.0);

        bank.makeCustomerDeposit("Kekoa", "Wahiawa", 250.0);

        bank.makeCustomerWithdrawal("Kekoa", "Wahiawa", 150.0);
        bank.makeCustomerWithdrawal("Kekoa", "Wahiawa", 350.0);

        bank.listCustomers("Wahiawa", true, true);
    }
}
