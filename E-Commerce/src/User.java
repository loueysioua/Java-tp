import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    private AuthentificationSystem authentificationSystem;
    private ArrayList<Review> reviews;
    private HashMap<String , CouponsAndDicountCodes> couponsAndDicountCodesUsed;
    private HashMap<String, Order> orders;
    private UserCart cart ;
    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;

    private ProductManager productManager;

    public User( AuthentificationSystem authentificationSystem,ProductManager productManager,String name, String username, String email, String password, String address , String phoneNumber) {
        this.authentificationSystem = authentificationSystem;
        this.productManager = productManager;
        this.couponsAndDicountCodesUsed = new HashMap<>();
        this.cart = new UserCart(productManager);
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.orders = new HashMap<>();
        this.reviews = new ArrayList<>();
        this.authentificationSystem.registerUser(this);
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

    @Override
    public String toString() {
        return "User :\n\t"+
                "-Name : "+name+"\n\t"+
                "-Username : "+username+"\n\t"+
                "-Email : "+email+"\n\t"+
                "-Password : "+password+"\n\t"+
                "-Address : "+address+"\n\t"+
                "-Phone Number : "+phoneNumber+"\n";
    }

    public void checkout(){
        System.out.println("------------------Your cart:------------------");
        //User may enter discount codes if he has
        System.out.println("Do you have a discount code? (Y/N)");
        Scanner scanner1 = new Scanner(System.in);
        String choice1 = scanner1.nextLine();
        if(choice1.equalsIgnoreCase("Y")){
            System.out.println("Enter your discount code:");
            Scanner scanner2 = new Scanner(System.in);
            String code = scanner2.nextLine();
            if(CouponsAndDicountCodes.codes.containsKey(code) && !couponsAndDicountCodesUsed.containsKey(code)){
                cart.setDiscountPercentage(CouponsAndDicountCodes.codes.get(code).getDiscountPercentage());
                cart.setDiscountAmount(CouponsAndDicountCodes.codes.get(code).getDiscountAmount());
                cart.calculatePayableAmount();
                couponsAndDicountCodesUsed.put(code, CouponsAndDicountCodes.codes.get(code));
                System.out.println("Discount code applied successfully");
            }
            else if (couponsAndDicountCodesUsed.containsKey(code)){
                System.out.println("Discount code already used");
            }
            else{
                System.out.println("Invalid discount code");
            }
        }
        //calculate the total amount, shipping cost, discount amount, discount percentage, and payable amount and proceed with payment
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
        scanner.nextLine();
        switch (choice){
            case 1:
                System.out.println("Enter your card number:");
                String cardNumber = scanner.nextLine();
                System.out.println("Enter the card holder name:");
                String cardHolderName = scanner.nextLine();
                System.out.println("Enter the expiry date:");
                String expiryDate = scanner.nextLine();
                System.out.println("Enter the cvv:");
                String cvv = scanner.nextLine();
                PaymentStrat creditCardPayment = new CreditCardPayment(cardNumber, cardHolderName, expiryDate, cvv);
                creditCardPayment.pay(payableAmount);
                //create a new Order and add it to the order list of the user
                Order orderCase1 = new Order(username, cart);
                orders.put(orderCase1.getOrderID(), orderCase1);
                cart.clearCart();
                System.out.println("Thank you for shopping with us "+ name+" ! "+ "Your order will be delivered to "+ address+" in 3 days");
                break;
            case 2:
                System.out.println("Enter your username:");
                String username = scanner.nextLine();
                System.out.println("Enter your 4 digit password:");
                int _4DigitPassword = scanner.nextInt();
                System.out.println("Enter your 8 digit password:");
                int _8DigitPassword = scanner.nextInt();
                PaymentStrat e_dinarPayment = new E_dinarPayment(username, _4DigitPassword, _8DigitPassword);
                e_dinarPayment.pay(payableAmount);
                //create a new Order and add it to the order list of the user
                Order orderCase2 = new Order(username, cart);
                orders.put(orderCase2.getOrderID(), orderCase2);
                cart.clearCart();
                System.out.println("Thank you for shopping with us "+ name+" ! "+ "Your order will be delivered to "+ address+" in 3 days");
                break;
            case 3:
                System.out.println("Enter your username:");
                String username1 = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();
                System.out.println("Enter your card number:");
                String cardNumber1 = scanner.nextLine();
                PaymentStrat ourCardPayment = new OurCardPayment(username1, password , cardNumber1);
                ourCardPayment.pay(payableAmount);
                //create a new Order and add it to the order list of the user
                Order orderCase3 = new Order(username1, cart);
                orders.put(orderCase3.getOrderID(), orderCase3);
                cart.clearCart();
                System.out.println("Thank you for shopping with us "+ name+" ! "+ "Your order will be delivered to "+ address+" in 3 days");
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

    //view order History
    public void viewOrderHistory(){
        System.out.println("------------------Your order History:------------------");
        for(String orderID : orders.keySet()){
            System.out.println("- "+orders.get(orderID));
        }
        System.out.println("--------------------------------------------------------");
    }

//add a review to the list of reviews of the user and the product
    public void addReview(String productId, String review, int rating){
        reviews.add(new Review(productId, username, review, rating));
        Product p = productManager.findProduct(productId);
        if(p != null)
            p.addReview( new Review(productId, username, review, rating) );
    }

//remove a review from the list of reviews of the user and the product
    public void removeReview(String productId){
        for(Review review : reviews){
            if(review.getProductId().equals(productId)){
                reviews.remove(review);
                break;
            }
        }
        productManager.findProduct(productId).removeReview(this.username);
    }

//view the list of reviews
    public void viewReviews(){
        System.out.println("------------------Reviews:------------------");
        for(Review review : reviews){
            System.out.println("- "+review);
        }
        System.out.println("---------------------------------------------");
    }

    //view the list of used coupons and discount codes
    public void viewCouponsAndDiscountCodesUsed(){
        System.out.println("------------------Coupons and Discount Codes Used:------------------");
        for(String code : couponsAndDicountCodesUsed.keySet()){
            System.out.println("- "+couponsAndDicountCodesUsed.get(code));
        }
        System.out.println("--------------------------------------------------------------------");
    }

    public void searchForProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product id: ");
        String productId = scanner.nextLine();
        Product product = productManager.findProduct(productId);
        if (product != null) {
            System.out.println(product);
        }
        else {
            System.out.println("Product not found!");
        }
    }
    public void searchByTermInNameAndDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the term: ");
        String term = scanner.nextLine();
        productManager.searchByTermInNameAndDescription(term);
    }

    public void filterByCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the category: ");
        System.out.println("1. ElectronicProduct");
        System.out.println("2. ClothingProduct");
        System.out.println("3. GamingProduct");
        System.out.println("4. AnimeMerchProduct");
        System.out.println("5. SeriesMerchProduct");
        System.out.println("6. HomeDecoProduct");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                productManager.printAllProductsOfACategory(ElectronicProduct.class);
                break;
            case 2:
                productManager.printAllProductsOfACategory(ClothingProduct.class);
                break;
            case 3:
                productManager.printAllProductsOfACategory(GamingProduct.class);
                break;
            case 4:
                productManager.printAllProductsOfACategory(AnimeMerchProduct.class);
                break;
            case 5:
                productManager.printAllProductsOfACategory(SeriesMerchProduct.class);
                break;
            case 6:
                productManager.printAllProductsOfACategory(HomeDecoProduct.class);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void filterByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the min price: ");
        float minPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the max price: ");
        float maxPrice = scanner.nextFloat();
        scanner.nextLine();
        for (Product p : productManager.filterByPriceRange(minPrice, maxPrice)){
            System.out.println("Product: " + p.getName() + " Price: " + p.getPrice());
        }
    }

    public void filterByBrand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the brand: ");
        String brand = scanner.nextLine();
        for (Product p : productManager.filterByBrand(brand)){
            System.out.println("Product: " + p.getName() + " Brand: " + p.getBrand());
        }
    }

    //filter by quantity range
    public void filterByQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the min quantity: ");
        int minQuantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the max quantity: ");
        int maxQuantity = scanner.nextInt();
        scanner.nextLine();
        for (Product p : productManager.filterByQuantityRange(minQuantity, maxQuantity)){
            System.out.println("ProductID: " +p.getProductId()+"\tProduct Name: "+ p.getName() + "\tQuantity: " + p.getQuantityInStock());
        }
    }

    public static void userMenu(User user) {
        if (user != null) {
            //User must log in first :
            if (user.authentificationSystem.getLoggedInUsers().containsKey(user.email)) {
                int choice = 0;
                while (choice >= 0 && choice <= 18) {
                    if (user.authentificationSystem.getLoggedInUsers().containsKey(user.email)) {
                        System.out.println("Welcome " + user.name + " !");
                        System.out.println("1. View products");
                        System.out.println("2. View cart");
                        System.out.println("3. View order history");
                        System.out.println("4. View reviews");
                        System.out.println("5. View coupons and discount codes used");
                        System.out.println("6. View profile");
                        System.out.println("7. View all reviews of a product");
                        System.out.println("8. Search for a product");
                        System.out.println("9. Search by term in name and description");
                        System.out.println("10. Filter by category");
                        System.out.println("11. Filter by price");
                        System.out.println("12. Filter by quantity");
                        System.out.println("13. Filter dynamically");
                        System.out.println("14. Add to the shopping cart");
                        System.out.println("15. Remove from the shopping cart");
                        System.out.println("16. Add a review on a product");
                        System.out.println("17. Remove a review on a product");
                        System.out.println("18. Checkout");
                        System.out.println("19. Logout");
                        Scanner scanner = new Scanner(System.in);
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                user.productManager.printAllProducts();
                                break;
                            case 2:
                                user.viewCart();
                                break;
                            case 3:
                                user.viewOrderHistory();
                                break;
                            case 4:
                                user.viewReviews();
                                break;
                            case 5:
                                user.viewCouponsAndDiscountCodesUsed();
                                break;
                            case 6:
                                System.out.println(user);
                                break;
                            case 7:
                                System.out.println("Enter the product id: ");
                                String productId = scanner.nextLine();
                                user.productManager.findProduct(productId).displayReviews();
                                break;
                            case 8:
                                user.searchForProduct();
                                break;
                            case 9:
                                user.searchByTermInNameAndDescription();
                                break;
                            case 10:
                                user.filterByCategory();
                                break;
                            case 11:
                                user.filterByPrice();
                                break;
                            case 12:
                                user.filterByQuantity();
                                break;
                            case 13:
                                user.productManager.filterByDynamicFilters();
                                break;
                            case 14:
                                System.out.println("Enter the product id: ");
                                String productId2 = scanner.nextLine();
                                System.out.println("Enter the quantity: ");
                                int quantity = scanner.nextInt();
                                user.addToCart(productId2, quantity);
                                break;
                            case 15:
                                System.out.println("Enter the product id: ");
                                String productId3 = scanner.nextLine();
                                System.out.println("Enter the quantity: ");
                                int quantity2 = scanner.nextInt();
                                user.removeFromCart(productId3, quantity2);
                                break;
                            case 16:
                                System.out.println("Enter the product id: ");
                                String productId1 = scanner.nextLine();
                                System.out.println("Enter the review: ");
                                String review = scanner.nextLine();
                                System.out.println("Enter the rating: ");
                                int rating = scanner.nextInt();
                                user.addReview(productId1, review, rating);
                                scanner.nextLine();
                                break;
                            case 17:
                                System.out.println("Enter the product id: ");
                                String productId4 = scanner.nextLine();
                                user.removeReview(productId4);
                                break;
                            case 18:
                                user.checkout();
                                break;
                            case 19:
                                user.authentificationSystem.logout(user.email);
                                break;
                            default:
                                System.out.println("Invalid choice!");
                                break;

                        }
                        if(choice==19)
                            break;
                        else {
                            System.out.println("Would you like to continue? (Y/N)");
                            String answer = scanner.nextLine();
                            if (answer.equalsIgnoreCase("N")) {
                                user.authentificationSystem.logout(user.email);
                                break;
                            }
                        }
                    }

                }
            } else
                System.out.println("You must log in first!");
        }
    }
}
