public class Main {
    public static void main(String[] args) {
        Wallet w1 = new PersonalWallet(500, true); // ₹100 referral bonus
        Wallet w2 = new BusinessWallet(1000, false);

        User user1 = new User("Prakhar", w1);
        User user2 = new User("Sakshi", w2);

        user1.getWallet().loadMoney(200);
        user1.getWallet().transferTo(user2, 300);

        System.out.println("\n--- Transaction History for " + user1.getName() + " ---");
        user1.viewTransactionHistory();

        System.out.println("\n--- Transaction History for " + user2.getName() + " ---");
        user2.viewTransactionHistory();

        System.out.println("\nRemaining Balance of " + user1.getName() + ": ₹" + user1.getWallet().getBalance());
        System.out.println("Remaining Balance of " + user2.getName() + ": ₹" + user2.getWallet().getBalance());
    }
}