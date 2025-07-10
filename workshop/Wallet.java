import java.util.ArrayList;
import java.util.List;

public abstract class Wallet implements Tranferable {
    private double balance;
    protected List<String> transactions;

    public Wallet(double initialAmount, boolean referral) {
        this.balance = initialAmount;
        if (referral) {
            this.balance += 100; // Referral bonus
        }
        transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    protected void addBalance(double amount) {
        this.balance += amount;
    }

    protected boolean deductBalance(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void loadMoney(double amount) {
        addBalance(amount);
        transactions.add("Loaded ₹" + amount);
    }

    public void printTransactions() {
        for (String t : transactions) {
            System.out.println(t);
        }
    }

    // Abstract method for polymorphism
    public abstract void transferTo(User receiver, double amount);
}