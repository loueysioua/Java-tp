public class Review {
    private String productId;
    private String username;
    private String review;
    private int rating;

    public Review(String productId, String username, String review, int rating) {
        this.productId = productId;
        this.username = username;
        this.review = review;
        this.rating = rating;
    }

    public Review() {
    }

    public String getProductId() {
        return productId;
    }

    public String getUsername() {
        return username;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Review addReview(String productId, String username, String review, int rating){
        return new Review(productId, username, review, rating);
        //add review to product
        //add review to user
    }

    @Override
    public String toString() {
        return "Review of product of ID "+productId+" by "+username+" :\n\t"+
                "-Review : "+review+"\n\t"+
                "-Rating : "+rating+"\n";
    }
}
