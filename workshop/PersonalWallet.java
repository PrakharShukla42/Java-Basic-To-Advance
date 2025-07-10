public class PersonalWallet extends Wallet {

    public PersonalWallet(double initialAmount, boolean referral) {
        super(initialAmount, referral);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        double tax = 5; // ₹5 fixed tax
        if (amount + tax <= getBalance()) {
            deductBalance(amount + tax);
            receiver.getWallet().loadMoney(amount);

            this.transactions.add("Transferred ₹" + amount + " to " + receiver.getName());
            this.transactions.add("Tax deducted ₹" + tax);
            receiver.getWallet().transactions.add("Received ₹" + amount + " from " + receiver.getName());
        } else {
            System.out.println("Insufficient balance in PersonalWallet.");
        }
    }
}