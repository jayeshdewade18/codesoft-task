import java.util.Scanner;

public class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0.0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
            System.out.println("Initial balance cannot be negative. Balance set to 0.");
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0.0) {
            this.balance += amount;
            System.out.println("Deposit successful! New balance: " + this.balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0.0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + this.balance);
        } else if (amount <= 0.0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    // Method to check current balance
    public void checkBalance() {
        System.out.println("Your current balance is: " + this.balance);
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBalance = 0.0;
        
        System.out.print("Enter initial balance: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear invalid input
        }
        initialBalance = scanner.nextDouble();
        
        BankAccount account = new BankAccount(initialBalance);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                    }
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                    }
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
