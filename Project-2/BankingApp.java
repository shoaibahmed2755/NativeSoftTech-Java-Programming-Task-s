import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Constructor to create an account
    public BankAccount(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Initial balance is 0
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class BankingApp {

    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to create an account
    public static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        BankAccount newAccount = new BankAccount(name, accountNumber);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    // Method to get an account by account number
    public static BankAccount getAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    // Method to handle user interactions with the menu
    public static void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Simple Banking App ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccount = scanner.nextInt();
                    BankAccount depositAcc = getAccount(depositAccount);
                    if (depositAcc != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        depositAcc.deposit(depositAmount);
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccount = scanner.nextInt();
                    BankAccount withdrawAcc = getAccount(withdrawAccount);
                    if (withdrawAcc != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAcc.withdraw(withdrawAmount);
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    int checkAccount = scanner.nextInt();
                    BankAccount checkAcc = getAccount(checkAccount);
                    if (checkAcc != null) {
                        checkAcc.checkBalance();
                    }
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the Simple Banking App!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        showMenu();
    }
}
