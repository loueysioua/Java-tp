import java.util.ArrayList;

public abstract class Product {
    //a list of reviews and feedbacks :
    public ArrayList<Review> reviews;
    private float rating;
    private String productId;
    private String name;
    private String description;
    private float price;
    private int quantityInStock;
    private String brand;

    public Product() {
    }

    public Product(String productId, String name, String description, float price, int quantityInStock, String brand) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.reviews = new ArrayList<>();
        this.brand = brand;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void addQuantityInStock(int quantityInStock) {
        this.quantityInStock += quantityInStock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //add a review to the list of reviews
    public void addReview(Review review){
        reviews.add(review);
    }

    //remove a review from the list of reviews
    public void removeReview(String username){
        for (Review review : reviews) {
            if(review.getUsername().equals(username)){
                reviews.remove(review);
                break;
            }
        }
    }

    //calculate the average rating of the product
    public float calculateRating() {
        float sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        rating = sum / reviews.size();
        return rating;
    }

    //display the list of reviews
    public void displayReviews(){
        calculateRating();
        System.out.println("Rating : "+rating);
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }
    @Override
    public String toString() {
        return "Product of ID "+productId+ " :\n\t"+
                "Name: ' "+name+" '\n\t"+
                "Description: "+description+"\n\t"+
                "Price: "+price+"$\n\t"+
                "Quantity in stock: "+quantityInStock+"\n\t"+
                "Brand: "+brand+"\n\t"+
                "Rating: "+rating+"\n\t";
    }

}
