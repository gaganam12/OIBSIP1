import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATMInterface atmInterface = new ATMInterface(bank);
        atmInterface.start();
    }
}
