import java.util.Scanner;

public class ATMService {
    private UserAccount currentUser;
    private Scanner scanner = new Scanner(System.in);

    public ATMService(UserAccount user) {
        this.currentUser = user;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n====== ATM MENU ======");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            handleChoice(choice);
        } while (choice != 5);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1 -> showTransactions();
            case 2 -> withdraw();
            case 3 -> deposit();
            case 4 -> transfer();
            case 5 -> System.out.println("Thank you for using the ATM.");
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

    private void showTransactions() {
        System.out.println("\n--- Transaction History ---");
        if (currentUser.getTransactions().isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction txn : currentUser.getTransactions()) {
                System.out.println(txn);
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= currentUser.getBalance()) {
            currentUser.updateBalance(-amount);
            currentUser.addTransaction(new Transaction("Withdraw", amount));
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            currentUser.updateBalance(amount);
            currentUser.addTransaction(new Transaction("Deposit", amount));
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void transfer() {
        System.out.print("Enter recipient user ID: ");
        String recipientId = scanner.next();
        System.out.print("Enter amount to transfer: ₹");
        double amount = scanner.nextDouble();

        UserAccount recipient = BankSystem.findUser(recipientId);
        if (recipient != null && amount > 0 && amount <= currentUser.getBalance()) {
            currentUser.updateBalance(-amount);
            recipient.updateBalance(amount);

            currentUser.addTransaction(new Transaction("Transfer to " + recipientId, amount));
            recipient.addTransaction(new Transaction("Transfer from " + currentUser.getUserId(), amount));
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Check recipient ID or balance.");
        }
    }
}
