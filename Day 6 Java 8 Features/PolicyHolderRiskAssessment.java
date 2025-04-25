import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "RiskAssessment{holderId='" + holderId + "', name='" + name + "', riskScore=" + riskScore + "}";
    }
}

public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        List<PolicyHolder> policyHolders = Arrays.asList(
                new PolicyHolder("H1", "Alice", 65, "Life", 400.0),
                new PolicyHolder("H2", "Bob", 70, "Life", 500.0),
                new PolicyHolder("H3", "Charlie", 55, "Health", 300.0),
                new PolicyHolder("H4", "David", 75, "Life", 600.0),
                new PolicyHolder("H5", "Eve", 80, "Life", 350.0),
                new PolicyHolder("H6", "Frank", 62, "Auto", 450.0),
                new PolicyHolder("H7", "Grace", 68, "Life", 700.0)
        );

        List<PolicyHolder> filteredHolders = policyHolders.stream()
                .filter(ph -> "Life".equals(ph.getPolicyType()) && ph.getAge() > 60)
                .collect(Collectors.toList());

        List<RiskAssessment> riskAssessments = filteredHolders.stream()
                .map(ph -> new RiskAssessment(ph.getHolderId(), ph.getName(), ph.getPremiumAmount() / ph.getAge()))
                .collect(Collectors.toList());

        List<RiskAssessment> sortedAssessments = riskAssessments.stream()
                .sorted((r1, r2) -> Double.compare(r2.riskScore, r1.riskScore))
                .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorized = sortedAssessments.stream()
                .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        System.out.println("High Risk Policy Holders:");
        categorized.getOrDefault("High Risk", Collections.emptyList())
                .forEach(System.out::println);

        System.out.println("\nLow Risk Policy Holders:");
        categorized.getOrDefault("Low Risk", Collections.emptyList())
                .forEach(System.out::println);
    }
}
