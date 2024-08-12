import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        accounts.put("user1", new Account("user1", "1234", 1000.0));
        accounts.put("user2", new Account("user2", "5678", 2000.0));
    }

    public Account getAccount(String userId, String pin) {
        Account account = accounts.get(userId);
        if (account != null && account.getPin().equals(pin)) {
            return account;
        }
        return null;
    }
}

