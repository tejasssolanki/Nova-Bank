package novabank.repository;

import novabank.model.Account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BankRepository {

    private ArrayList<Account> accountList = new ArrayList<>();

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public ArrayList<Account> getAllAccounts() {
        return accountList;
    }

    public Account searchAccount(String accountNumber) {

        for (Account account : accountList) {

            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return account;
            }

        }

        return null;
    }

    public void displayAccounts() {

        if (accountList.isEmpty()) {
            System.out.println("\nNo Accounts Found.");
            return;
        }

        System.out.println("\n==============================================================");
        System.out.printf("%-15s %-20s %-15s%n",
                "ACCOUNT NO", "HOLDER NAME", "BALANCE");
        System.out.println("==============================================================");

        for (Account account : accountList) {

            System.out.printf("%-15s %-20s ₹%-15.2f%n",
                    account.getAccountNumber(),
                    account.getHolderName(),
                    account.getBalance());

        }

        System.out.println("==============================================================");
    }

    public void saveAccountsToCSV() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.csv"));

            for (Account account : accountList) {

                writer.write(
                        account.getAccountNumber() + "," +
                                account.getHolderName() + "," +
                                account.getBalance()
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Accounts saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving accounts.");

        }

    }

}