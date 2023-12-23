public class SeriesMerchProduct extends Product{
    private String seriesName;
    private String genre;
    private String type; // Figure, Plushie, Poster, etc.
    private String dimensions;
    private String material;

    public SeriesMerchProduct() {
    }

    public SeriesMerchProduct(String productId, String name, String description, float price, int quantityInStock, String brand, String seriesName, String genre, String type, String dimensions, String material) {
        super(productId, name, description, price, quantityInStock, brand);
        this.seriesName = seriesName;
        this.genre = genre;
        this.type = type;
        this.dimensions = dimensions;
        this.material = material;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Series Name: " + seriesName + "\n\t"
                + "Genre: " + genre + "\n\t"
                + "Type: " + type + "\n\t"
                + "Dimensions: " + dimensions + "\n\t"
                + "Material: " + material + "\n";
    }
}
