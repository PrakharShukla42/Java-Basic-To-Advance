public class BusinessWallet extends Wallet {

    public BusinessWallet(double initialAmount, boolean referral) {
        super(initialAmount, referral);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        double taxRate = 0.02; // 2% tax
        double tax = amount * taxRate;

        if (amount + tax <= getBalance()) {
            deductBalance(amount + tax);
            receiver.getWallet().loadMoney(amount);

            this.transactions.add("Transferred ₹" + amount + " to " + receiver.getName());
            this.transactions.add("Tax deducted ₹" + tax);
            receiver.getWallet().transactions.add("Received ₹" + amount + " from " + receiver.getName());
        } else {
            System.out.println("Insufficient balance in BusinessWallet.");
        }
    }
}