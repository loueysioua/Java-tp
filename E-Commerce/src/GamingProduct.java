public class GamingProduct extends Product {
    private String platform;
    private String genre;
    private String rating;
    private String releaseDate;
    private String developer;

    public GamingProduct() {
    }

    public GamingProduct(String productId, String name, String description, float price, int quantityInStock, String brand, String platform, String genre, String rating, String releaseDate, String developer) {
        super(productId, name, description, price, quantityInStock, brand);
        this.platform = platform;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.developer = developer;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Platform: " + platform + "\n\t"
                + "Genre: " + genre + "\n\t"
                + "Rating: " + rating + "\n\t"
                + "Release Date: " + releaseDate + "\n\t"
                + "Developer: " + developer + "\n";
    }

}
