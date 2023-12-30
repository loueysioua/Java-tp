public class GiftCard implements PaymentStrat{
    private String code;
    private double amount;
    public GiftCard(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    @Override
    public void pay(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            System.out.println("You Paid "+amount+" with Gift Card");
        } else {
            System.out.println("Not enough money!");
        }
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "code='" + code + '\'' +
                ", amount=" + amount +
                '}';
    }
}
