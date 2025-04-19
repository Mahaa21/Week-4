import java.time.LocalDate;
import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate + ", Type: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies(Set<Policy> set) {
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    public void displayExpiringSoon(Set<Policy> set) {
        LocalDate now = LocalDate.now();
        for (Policy p : set) {
            if (!p.getExpiryDate().isBefore(now) && p.getExpiryDate().isBefore(now.plusDays(30))) {
                System.out.println(p);
            }
        }
    }

    public void displayByCoverageType(Set<Policy> set, String type) {
        for (Policy p : set) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void displayDuplicates(Set<Policy> set) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Policy p : set) {
            countMap.put(p.getPolicyNumber(), countMap.getOrDefault(p.getPolicyNumber(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate Policy Number: " + entry.getKey());
            }
        }
    }

    public void comparePerformance() {
        List<Policy> policies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            policies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Health", 1000 + i));
        }

        long start, end;

        Set<Policy> hSet = new HashSet<>();
        start = System.nanoTime();
        for (Policy p : policies) hSet.add(p);
        end = System.nanoTime();
        System.out.println("HashSet Add: " + (end - start) + " ns");

        start = System.nanoTime();
        hSet.contains(policies.get(5000));
        end = System.nanoTime();
        System.out.println("HashSet Search: " + (end - start) + " ns");

        start = System.nanoTime();
        hSet.remove(policies.get(5000));
        end = System.nanoTime();
        System.out.println("HashSet Remove: " + (end - start) + " ns");

        Set<Policy> lSet = new LinkedHashSet<>();
        start = System.nanoTime();
        for (Policy p : policies) lSet.add(p);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add: " + (end - start) + " ns");

        start = System.nanoTime();
        lSet.contains(policies.get(5000));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search: " + (end - start) + " ns");

        start = System.nanoTime();
        lSet.remove(policies.get(5000));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Remove: " + (end - start) + " ns");

        Set<Policy> tSet = new TreeSet<>();
        start = System.nanoTime();
        for (Policy p : policies) tSet.add(p);
        end = System.nanoTime();
        System.out.println("TreeSet Add: " + (end - start) + " ns");

        start = System.nanoTime();
        tSet.contains(policies.get(5000));
        end = System.nanoTime();
        System.out.println("TreeSet Search: " + (end - start) + " ns");

        start = System.nanoTime();
        tSet.remove(policies.get(5000));
        end = System.nanoTime();
        System.out.println("TreeSet Remove: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem manager = new InsurancePolicyManagementSystem();

        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 1200));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 900));
        manager.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().plusDays(25), "Home", 1500));
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 1200));

        System.out.println("All Unique Policies (HashSet):");
        manager.displayAllPolicies(manager.hashSet);

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        manager.displayExpiringSoon(manager.hashSet);

        System.out.println("\nPolicies with Coverage Type 'Health':");
        manager.displayByCoverageType(manager.hashSet, "Health");

        System.out.println("\nDuplicate Policies:");
        manager.displayDuplicates(manager.hashSet);

        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance();
    }
}
