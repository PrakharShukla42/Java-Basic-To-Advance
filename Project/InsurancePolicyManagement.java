import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;

    Policy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return "[Policy No: " + policyNumber + ", Holder: " + policyHolder + ", Expiry: " + expiryDate + "]";
    }
}

public class InsurancePolicyManagement {
    // Different types of Maps
    Map<String, Policy> policyMap = new HashMap<>(); // For fast retrieval
    Map<String, Policy> insertionOrderMap = new LinkedHashMap<>(); // Maintain order
    TreeMap<LocalDate, List<Policy>> expiryDateMap = new TreeMap<>(); // Sort by expiry

    // Add policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy);
        expiryDateMap.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve policy by number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring in next 30 days
    public List<Policy> getExpiringPolicies() {
        List<Policy> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : expiryDateMap.subMap(today, true, limit, true).entrySet()) {
            result.addAll(entry.getValue());
        }

        return result;
    }

    // List all policies of a policyholder
    public List<Policy> getPoliciesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holder)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        NavigableMap<LocalDate, List<Policy>> expiredMap = expiryDateMap.headMap(today, false);

        for (List<Policy> policies : new ArrayList<>(expiredMap.values())) {
            for (Policy policy : policies) {
                policyMap.remove(policy.policyNumber);
                insertionOrderMap.remove(policy.policyNumber);
            }
        }

        expiryDateMap.headMap(today, false).clear(); // Clean up TreeMap
    }

    // Display all policies (for demo)
    public void displayAllPolicies() {
        for (Policy p : insertionOrderMap.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        // Sample data
        system.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P1003", "Alice", LocalDate.now().minusDays(5)));
        system.addPolicy(new Policy("P1004", "Charlie", LocalDate.now().plusDays(25)));

        System.out.println("\n🔎 Retrieve P1002:");
        System.out.println(system.getPolicyByNumber("P1002"));

        System.out.println("\n📅 Policies expiring in next 30 days:");
        for (Policy p : system.getExpiringPolicies()) {
            System.out.println(p);
        }

        System.out.println("\n👤 Policies for Alice:");
        for (Policy p : system.getPoliciesByHolder("Alice")) {
            System.out.println(p);
        }

        System.out.println("\n🧹 Removing expired policies...");
        system.removeExpiredPolicies();

        System.out.println("\n📋 All Active Policies:");
        system.displayAllPolicies();
    }
}
