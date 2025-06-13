import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private String userId;
    private String pin;
    private double balance;
    private List<Transaction> transactions;

    public UserAccount(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public void addTransaction(Transaction txn) {
        transactions.add(txn);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

