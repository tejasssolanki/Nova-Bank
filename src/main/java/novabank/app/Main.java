package novabank.app;

import novabank.model.Account;
import novabank.repository.BankRepository;
import novabank.service.BankService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankRepository repository = new BankRepository();
        BankService bankService = new BankService();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("          NOVA BANK SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Save Accounts to CSV");
            System.out.println("7. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    String accountNumber = sc.nextLine();

                    System.out.print("Enter Holder Name: ");
                    String holderName = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    Account account = new Account(accountNumber, holderName, balance);

                    repository.addAccount(account);

                    System.out.println("\nAccount Created Successfully!");
                    break;

                case 2:

                    repository.displayAccounts();
                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    String searchNumber = sc.nextLine();

                    Account found = repository.searchAccount(searchNumber);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Account Not Found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    String depositNumber = sc.nextLine();

                    Account depositAccount = repository.searchAccount(depositNumber);

                    if (depositAccount != null) {

                        System.out.print("Enter Amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        bankService.deposit(depositAccount, amount);

                    } else {

                        System.out.println("Account Not Found.");

                    }

                    break;

                case 5:

                    System.out.print("Enter Account Number: ");
                    String withdrawNumber = sc.nextLine();

                    Account withdrawAccount = repository.searchAccount(withdrawNumber);

                    if (withdrawAccount != null) {

                        System.out.print("Enter Amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        bankService.withdraw(withdrawAccount, amount);

                    } else {

                        System.out.println("Account Not Found.");

                    }

                    break;

                case 6:

                    repository.saveAccountsToCSV();
                    break;

                case 7:

                    System.out.println("Thank you for using Nova Bank.");
                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 7);

        sc.close();

    }
}