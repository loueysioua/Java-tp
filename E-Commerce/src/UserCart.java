import java.util.HashMap;

public class UserCart {
    private HashMap<String, Integer> cart;
    private ProductManager productManager;
    private double totalAmount;
    private double discountAmount;
    private double payableAmount;
    private double shippingCost;

    public UserCart(ProductManager productManager){
        cart = new HashMap<>();
        this.productManager = productManager;
        totalAmount = 0;
        discountAmount = 0;
        payableAmount = 0;
        shippingCost = 0;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void calculateShippingCost(){
        if(totalAmount > 400){
            setShippingCost(0);
        }
        else if(totalAmount > 100){
            setShippingCost(totalAmount * 0.05);
        }
        else if(totalAmount > 50){
            setShippingCost(totalAmount * 0.1);
        }
        else{
            setShippingCost(totalAmount * 0.2);
        }
    }

    public void addProductToCart(String productID , int quantity) {
        Product product = productManager.findProduct(productID);
        if(product != null) {
            if (product.getQuantityInStock() >= quantity && quantity > 0) {
                //if product is already in cart, add the quantity to the existing quantity else add the product to cart
                cart.put(productID, cart.getOrDefault(productID, 0) + quantity);
                totalAmount += product.getPrice() * quantity;
                product.setQuantityInStock(product.getQuantityInStock() - quantity);
                System.out.println("Product added to cart successfully");
                calculateShippingCost();
                payableAmount= totalAmount - discountAmount + shippingCost;
            }
            else if(quantity <= 0){
                System.out.println("Product not added to cart. Invalid quantity");
            }
            else {
                System.out.println("Product not added to cart. Insufficient stock");
            }
        }
        else{
            System.out.println("Product not found");
        }
    }

    public void removeProductFromCart(String productID , int quantity) {
        if (cart.containsKey(productID)){
            int currentQuantity = cart.get(productID);
            if(quantity >= currentQuantity){
                cart.remove(productID);
                Product product = productManager.findProduct(productID);
                product.setQuantityInStock(product.getQuantityInStock() + currentQuantity);
                totalAmount -= product.getPrice() * currentQuantity;
                System.out.println("Product removed from cart successfully");
                calculateShippingCost();
                payableAmount= totalAmount - discountAmount + shippingCost;
            }
            else if (quantity > 0){
                cart.put(productID, currentQuantity - quantity);
                Product product = productManager.findProduct(productID);
                product.setQuantityInStock(product.getQuantityInStock() + quantity);
                totalAmount -= product.getPrice() * quantity;
                System.out.println("Product removed from cart successfully");
                calculateShippingCost();
                payableAmount= totalAmount - discountAmount + shippingCost;
            }
            else {
                System.out.println("Product not removed from cart. Invalid quantity");
            }
        }
        else{
            System.out.println("Product not in cart");
        }
    }

    public void displayCart(){
        System.out.println("---------------------------------Displaying Cart----------------------------------");
        calculateShippingCost();
        System.out.printf("{\t%-15s|\t%-25s|\t%-10s|\t%-10s\n", "Product ID", "Product Name", "Quantity", "Price");
        //iterate through the cart and display the product ID , name and quantity
        for(String productID : cart.keySet()){
            Product product = productManager.findProduct(productID);
            System.out.printf("\n\t%-15s:\t%-25s:\t%-10d:\t%-10.2f", productID, product.getName(), cart.get(productID), product.getPrice());
        }
        System.out.print("}\n------------------------------------------");
        System.out.println("\nTotal Amount: "+totalAmount+"$");
        System.out.println("Discount Amount: "+discountAmount+"$");
        System.out.println("Shipping Cost: "+shippingCost+"$");
        System.out.println("Payable Amount: "+payableAmount+"$");
        System.out.println("------------------------------------------------------------------------------------");
    }
}
