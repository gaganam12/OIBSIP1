import java.util.ArrayList;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: $" + initialBalance);
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        }
    }

    public boolean transfer(Account targetAccount, double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            targetAccount.deposit(amount);
            transactionHistory.add("Transferred: $" + amount + " to account: " + targetAccount.getUserId());
            return true;
        }
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }
}

