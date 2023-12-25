public class OurCardPayment implements PaymentStrat{
    private String username;
    private String password;
    private String cardNumber;

    public OurCardPayment(String username, String password, String cardNumber) {
        this.username = username;
        this.password = password;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("You Paid "+amount+" with Our Card");
    }
}
