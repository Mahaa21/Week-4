import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    Date transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}

class FraudSummary {
    String policyNumber;
    long fraudCount;
    double totalFraudAmount;

    public FraudSummary(String policyNumber, long fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "ALERT: Policy " + policyNumber +
                " | Fraud Count: " + fraudCount +
                " | Total Fraud Amount: $" + totalFraudAmount;
    }
}

public class FraudDetection {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P1001", 15000, new Date(), true),
                new Transaction("T2", "P1002", 8000, new Date(), true),
                new Transaction("T3", "P1001", 20000, new Date(), true),
                new Transaction("T4", "P1003", 50000, new Date(), true),
                new Transaction("T5", "P1001", 3000, new Date(), false),
                new Transaction("T6", "P1001", 12000, new Date(), true),
                new Transaction("T7", "P1002", 25000, new Date(), true),
                new Transaction("T8", "P1001", 14000, new Date(), true),
                new Transaction("T9", "P1001", 18000, new Date(), true),
                new Transaction("T10", "P1001", 16000, new Date(), true),
                new Transaction("T11", "P1004", 7000, new Date(), true)
        );

        List<Transaction> filtered = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10_000)
                .collect(Collectors.toList());

        Map<String, List<Transaction>> groupedByPolicy = filtered.stream()
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        List<FraudSummary> summaries = groupedByPolicy.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Transaction> txns = entry.getValue();
                    long count = txns.size();
                    double totalAmount = txns.stream().mapToDouble(Transaction::getAmount).sum();
                    return new FraudSummary(policy, count, totalAmount);
                })
                .collect(Collectors.toList());

        List<FraudSummary> alerts = summaries.stream()
                .filter(s -> s.fraudCount > 5 || s.totalFraudAmount > 50_000)
                .collect(Collectors.toList());

        if (alerts.isEmpty()) {
            System.out.println("No alerts generated.");
        } else {
            System.out.println("Fraud Alerts:");
            alerts.forEach(System.out::println);
        }
    }
}
