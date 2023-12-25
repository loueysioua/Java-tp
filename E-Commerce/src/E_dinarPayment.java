public class E_dinarPayment implements PaymentStrat{
    private String username;
    private int _4DigitPassword;
    private int _8DigitPassword;
    private String password;

    public E_dinarPayment(String username, int _4DigitPassword, int _8DigitPassword) {
        this.username = username;
        this._4DigitPassword = _4DigitPassword;
        this._8DigitPassword = _8DigitPassword;
        this.password = _4DigitPassword + "" + _8DigitPassword;
    }

    @Override
    public void pay(double amount) {
        System.out.println("You Paid "+amount+" with E-dinar");
    }
}
