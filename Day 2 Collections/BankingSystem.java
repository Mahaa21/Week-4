import java.util.*;

public class BankingSystem {

    private Map<String, Double> customerAccounts;
    private Map<String, Double> sortedAccounts;
    private Queue<String> withdrawalRequests;

    public BankingSystem() {
        this.customerAccounts = new HashMap<>();
        this.sortedAccounts = new TreeMap<>(Comparator.comparing(customerAccounts::get).reversed());
        this.withdrawalRequests = new LinkedList<>();
    }

    public void createAccount(String accountNumber, double balance) {
        customerAccounts.put(accountNumber, balance);
        sortedAccounts.put(accountNumber, balance);
    }

    public void deposit(String accountNumber, double amount) {
        double newBalance = customerAccounts.get(accountNumber) + amount;
        customerAccounts.put(accountNumber, newBalance);
        sortedAccounts.put(accountNumber, newBalance);
    }

    public void withdraw(String accountNumber, double amount) {
        if (customerAccounts.get(accountNumber) >= amount) {
            double newBalance = customerAccounts.get(accountNumber) - amount;
            customerAccounts.put(accountNumber, newBalance);
            sortedAccounts.put(accountNumber, newBalance);
            withdrawalRequests.add(accountNumber);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalRequests.isEmpty()) {
            String accountNumber = withdrawalRequests.poll();
            System.out.println("Processed withdrawal for account: " + accountNumber);
        }
    }

    public void displayCustomerAccounts() {
        for (Map.Entry<String, Double> entry : customerAccounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + ", Balance: $" + entry.getValue());
        }
    }

    public void displaySortedAccounts() {
        for (Map.Entry<String, Double> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + ", Balance: $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount("A101", 1500.00);
        bank.createAccount("A102", 2500.00);
        bank.createAccount("A103", 1000.00);

        bank.deposit("A101", 500.00);
        bank.withdraw("A102", 800.00);

        bank.displayCustomerAccounts();
        bank.displaySortedAccounts();
        bank.processWithdrawals();
    }
}
