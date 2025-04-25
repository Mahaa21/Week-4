import java.util.*;
import java.util.stream.*;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    Date claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }
}

class PolicyAggregate {
    String policyNumber;
    double totalAmount;
    double averageAmount;

    public PolicyAggregate(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "PolicyAggregate{policyNumber='" + policyNumber + "', totalAmount=" + totalAmount + ", averageAmount=" + averageAmount + "}";
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P101", 7000, new Date(), "Approved"),
                new Claim("C2", "P102", 3000, new Date(), "Rejected"),
                new Claim("C3", "P101", 8000, new Date(), "Approved"),
                new Claim("C4", "P103", 6000, new Date(), "Approved"),
                new Claim("C5", "P104", 9000, new Date(), "Approved"),
                new Claim("C6", "P103", 2000, new Date(), "Approved"),
                new Claim("C7", "P104", 12000, new Date(), "Approved"),
                new Claim("C8", "P105", 4000, new Date(), "Pending")
        );
        List<Claim> filteredClaims = claims.stream()
                .filter(c -> "Approved".equals(c.getStatus()) && c.getClaimAmount() > 5000)
                .collect(Collectors.toList());

        Map<String, List<Claim>> groupedByPolicy = filteredClaims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<PolicyAggregate> aggregates = groupedByPolicy.entrySet().stream()
                .map(entry -> {
                    String policyNumber = entry.getKey();
                    List<Claim> claimList = entry.getValue();
                    double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double avg = claimList.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0);
                    return new PolicyAggregate(policyNumber, total, avg);
                })
                .collect(Collectors.toList());

        List<PolicyAggregate> top3Policies = aggregates.stream()
                .sorted((p1, p2) -> Double.compare(p2.totalAmount, p1.totalAmount))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3 Policies by Total Claim Amount:");
        top3Policies.forEach(System.out::println);
    }
}
