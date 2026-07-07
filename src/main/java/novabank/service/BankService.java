package novabank.service;

import novabank.model.Account;

public class BankService {

    public void deposit(Account account, double amount) {

        account.setBalance(account.getBalance() + amount);

        System.out.println("\n₹" + amount + " deposited successfully.");
        System.out.println("Current Balance : ₹" + account.getBalance());

    }

    public void withdraw(Account account, double amount) {

        if (amount > account.getBalance()) {

            System.out.println("Insufficient Balance!");
            return;

        }

        account.setBalance(account.getBalance() - amount);

        System.out.println("\n₹" + amount + " withdrawn successfully.");
        System.out.println("Current Balance : ₹" + account.getBalance());

    }

    public void checkBalance(Account account) {

        System.out.println("\n==============================");
        System.out.println("ACCOUNT DETAILS");
        System.out.println("==============================");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Holder Name    : " + account.getHolderName());
        System.out.printf("Balance        : ₹%.2f%n", account.getBalance());
        System.out.println("==============================");

    }

}