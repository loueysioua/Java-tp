import java.util.Scanner;

public class User {
    //TODO: add order list
    private UserCart cart ;
    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;

    public User( ProductManager productManager,String name, String username, String email, String password, String address , String phoneNumber) {
        this.cart = new UserCart(productManager);
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addToCart(String productId, int quantity){
        cart.addProductToCart(productId, quantity);
    }

    public void removeFromCart(String productId, int quantity){
        cart.removeProductFromCart(productId, quantity);
    }

    public void viewCart(){
        cart.displayCart();
    }

    public void checkout(){
        System.out.println("------------------Your cart:------------------");
        cart.calculateShippingCost();
        cart.calculateTotalAmount();
        cart.calculatePayableAmount();
        double totalAmount = cart.getTotalAmount();
        double discountAmount = cart.getDiscountAmount();
        double discountPercentage = cart.getDiscountPercentage();
        double payableAmount = cart.getPayableAmount();
        double shippingCost = cart.getShippingCost();
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Discount Percentage: " + discountPercentage);
        System.out.println("Shipping Cost: " + shippingCost);
        System.out.println("---------------------------------");
        System.out.println("Total Payable Amount: " + payableAmount);
        System.out.println("Choose a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. E-dinar");
        System.out.println("3. Our Card");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter your card number:");
                String cardNumber = scanner.next();
                System.out.println("Enter the card holder name:");
                String cardHolderName = scanner.next();
                System.out.println("Enter the expiry date:");
                String expiryDate = scanner.next();
                System.out.println("Enter the cvv:");
                String cvv = scanner.next();
                PaymentStrat creditCardPayment = new CreditCardPayment(cardNumber, cardHolderName, expiryDate, cvv);
                creditCardPayment.pay(payableAmount);
                break;
            case 2:
                System.out.println("Enter your username:");
                String username = scanner.next();
                System.out.println("Enter your 4 digit password:");
                int _4DigitPassword = scanner.nextInt();
                System.out.println("Enter your 8 digit password:");
                int _8DigitPassword = scanner.nextInt();
                PaymentStrat e_dinarPayment = new E_dinarPayment(username, _4DigitPassword, _8DigitPassword);
                e_dinarPayment.pay(payableAmount);
                break;
            case 3:
                System.out.println("Enter your username:");
                username = scanner.next();
                System.out.println("Enter your password:");
                String password = scanner.next();
                System.out.println("Enter your card number:");
                cardNumber = scanner.next();
                PaymentStrat ourCardPayment = new OurCardPayment(username, password , cardNumber);
                ourCardPayment.pay(payableAmount);
                break;
            default:
                System.out.println("Invalid choice");
        }
        cart.clearCart();
        System.out.println("Thank you for shopping with us "+ name+" ! "+ "Your order will be delivered to "+ address+" in 3 days");
        //after payment need to create a new Order and add it to the order list of the user
    }

    //need to add orders before doing the menu
    public void userMenu(){};
}
