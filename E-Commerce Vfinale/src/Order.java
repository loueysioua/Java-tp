import java.time.LocalDateTime;
import java.util.HashMap;
import java.time.format.DateTimeFormatter;

public class Order {
    private String orderID;
    private String userID;
    private HashMap<String, Integer> orderItems;
    private double payableAmount;
    private LocalDateTime date;

    public Order() {
    }

    public Order(String userID,UserCart cart) {
        //create a copy of the cart hashmap and store it in orderItems
        this.orderItems = new HashMap<>(cart.getCart());
        this.payableAmount = cart.getPayableAmount();
        this.userID = userID;
        this.orderID = generateOrderId();
        this.date = LocalDateTime.now();
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public HashMap<String, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(HashMap<String, Integer> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    private String generateOrderId() {
        // OrderID is a combination of date, time, and a unique identifier
        return "UID"+userID+LocalDateTime.now().toString();
    }


    @Override
    public String toString() {
        //string for the oder items to print it
        String s="";
        for (String key : orderItems.keySet()) {
            s+= ( "\n\tProduct ID: " + key + " Quantity: " + orderItems.get(key) );
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String newDate=date.format(formatter);

        return "Order "+orderID+" :"+
                "\n{userID= '" + userID + '\'' +
                "\norderItems= " + s +
                "\ndate= " + newDate +
                "\npayableAmount= " + payableAmount +"$"+
                " }\n";
    }
}
