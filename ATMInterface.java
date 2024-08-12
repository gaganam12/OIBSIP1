import java.util.Scanner;

public class ATMInterface {
    private Bank bank;
    private Scanner scanner;

    public ATMInterface(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        Account currentAccount = bank.getAccount(userId, pin);
        if (currentAccount == null) {
            System.out.println("Invalid User ID or PIN.");
            return;
        }

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewTransactionHistory(currentAccount);
                    break;
                case 2:
                    withdraw(currentAccount);
                    break;
                case 3:
                    transfer(currentAccount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void viewTransactionHistory(Account account) {
        System.out.println("\nTransaction History:");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private void withdraw(Account account) {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void transfer(Account account) {
        System.out.print("Enter target account ID: ");
        String targetUserId = scanner.next();
        System.out.print("Enter amount to transfer: $");
        double amount = scanner.nextDouble();

        Account targetAccount = bank.getAccount(targetUserId, account.getPin());
        if (targetAccount == null) {
            System.out.println("Target account not found.");
        } else if (account.transfer(targetAccount, amount)) {
            System.out.println("Transfer successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

