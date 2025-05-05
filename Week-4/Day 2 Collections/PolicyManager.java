import java.time.LocalDate;
import java.util.*;

class InsurancePolicy {
    private String policyID;
    private String holderName;
    private LocalDate expiry;
    private String coverage;
    private double premium;

    public InsurancePolicy(String policyID, String holderName, LocalDate expiry, String coverage, double premium) {
        this.policyID = policyID;
        this.holderName = holderName;
        this.expiry = expiry;
        this.coverage = coverage;
        this.premium = premium;
    }

    public String getPolicyID() {
        return policyID;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public String getCoverage() {
        return coverage;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return "ID: " + policyID + ", Holder: " + holderName + ", Expiry: " + expiry + ", Coverage: " + coverage + ", Premium: " + premium;
    }
}

public class PolicyManager {
    private Map<String, InsurancePolicy> policyMap;
    private Map<String, InsurancePolicy> orderedPolicyMap;
    private Map<LocalDate, InsurancePolicy> expirySortedPolicyMap;

    public PolicyManager() {
        policyMap = new HashMap<>();
        orderedPolicyMap = new LinkedHashMap<>();
        expirySortedPolicyMap = new TreeMap<>();
    }

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyID(), policy);
        orderedPolicyMap.put(policy.getPolicyID(), policy);
        expirySortedPolicyMap.put(policy.getExpiry(), policy);
    }

    public InsurancePolicy getPolicyByID(String policyID) {
        return policyMap.get(policyID);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringSoon = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate thresholdDate = currentDate.plusDays(30);
        for (InsurancePolicy policy : expirySortedPolicyMap.values()) {
            if (!policy.getExpiry().isBefore(currentDate) && policy.getExpiry().isBefore(thresholdDate)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policiesForHolder = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getHolderName().equalsIgnoreCase(holderName)) {
                policiesForHolder.add(policy);
            }
        }
        return policiesForHolder;
    }

    public void removeExpiredPolicies() {
        LocalDate currentDate = LocalDate.now();
        expirySortedPolicyMap.entrySet().removeIf(entry -> entry.getKey().isBefore(currentDate));
    }

    public void displayPolicies(Map<?, InsurancePolicy> map) {
        for (InsurancePolicy policy : map.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new InsurancePolicy("A123", "John Doe", LocalDate.now().plusDays(10), "Health", 300.00));
        manager.addPolicy(new InsurancePolicy("A124", "Jane Smith", LocalDate.now().plusDays(50), "Auto", 500.00));
        manager.addPolicy(new InsurancePolicy("A125", "Mark Brown", LocalDate.now().plusDays(20), "Home", 450.00));
        manager.addPolicy(new InsurancePolicy("A126", "John Doe", LocalDate.now().plusDays(15), "Health", 350.00));

        System.out.println("Policies stored in HashMap:");
        manager.displayPolicies(manager.policyMap);

        System.out.println("\nPolicies expiring within the next 30 days:");
        List<InsurancePolicy> expiringPolicies = manager.getPoliciesExpiringSoon();
        for (InsurancePolicy policy : expiringPolicies) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies for John Doe:");
        List<InsurancePolicy> johnPolicies = manager.getPoliciesByHolder("John Doe");
        for (InsurancePolicy policy : johnPolicies) {
            System.out.println(policy);
        }

        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();

        System.out.println("\nRemaining Policies in TreeMap:");
        manager.displayPolicies(manager.expirySortedPolicyMap);
    }
}
