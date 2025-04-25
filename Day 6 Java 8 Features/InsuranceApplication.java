import java.util.*;
import java.util.stream.*;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder Name: " + holderName + ", Premium: " + premiumAmount;
    }
}

public class InsuranceApplication {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
                new InsurancePolicy("P001", "Alice", 1500),
                new InsurancePolicy("P002", "Bob", 1000),
                new InsurancePolicy("P003", "Charlie", 2000),
                new InsurancePolicy("P004", "David", 1200)
        );
        List<InsurancePolicy> filteredPolicies = policies.stream()
                .filter(p -> p.premiumAmount > 1200)
                .collect(Collectors.toList());

        filteredPolicies.forEach(System.out::println);


        List<InsurancePolicy> sortedPolicies = policies.stream()
                .sorted(Comparator.comparing(p -> p.holderName))
                .collect(Collectors.toList());

        sortedPolicies.forEach(System.out::println);
        double totalPremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .sum();

        System.out.println("Total Premium: " + totalPremium);
        policies.forEach(p -> System.out.println(p));
        List<InsurancePolicy> filteredRangePolicies = policies.stream()
                .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                .collect(Collectors.toList());

        filteredRangePolicies.forEach(System.out::println);
        Optional<InsurancePolicy> maxPremiumPolicy = policies.stream()
                .max(Comparator.comparingDouble(p -> p.premiumAmount));

        maxPremiumPolicy.ifPresent(System.out::println);
        Map<Character, List<InsurancePolicy>> groupedPolicies = policies.stream()
                .collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));

        groupedPolicies.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        double averagePremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .average()
                .orElse(0.0);

        System.out.println("Average Premium: " + averagePremium);

        List<InsurancePolicy> sortedByPremium = policies.stream()
                .sorted(Comparator.comparingDouble(p -> p.premiumAmount))
                .collect(Collectors.toList());

        sortedByPremium.forEach(System.out::println);

        boolean anyExceeds2000 = policies.stream()
                .anyMatch(p -> p.premiumAmount > 2000);

        System.out.println("Any policy exceeds $2000? " + anyExceeds2000);

        Map<String, Long> premiumRangeCount = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.premiumAmount <= 1000) return "$0-$1,000";
                    else if (p.premiumAmount <= 2000) return "$1,001-$2,000";
                    else return ">$2,000";
                }, Collectors.counting()));

        premiumRangeCount.forEach((range, count) -> {
            System.out.println(range + ": " + count);
        });

        Set<String> uniqueHolderNames = policies.stream()
                .map(p -> p.holderName)
                .collect(Collectors.toSet());

        uniqueHolderNames.forEach(System.out::println);

        String substring = "Al";
        List<InsurancePolicy> policiesWithSubstring = policies.stream()
                .filter(p -> p.holderName.contains(substring))
                .collect(Collectors.toList());

        policiesWithSubstring.forEach(System.out::println);

        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));

        policyMap.forEach((policyNumber, premium) -> {
            System.out.println(policyNumber + ": " + premium);
        });

    }
}
