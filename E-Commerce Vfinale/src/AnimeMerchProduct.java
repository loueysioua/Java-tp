public class AnimeMerchProduct extends Product{
    private String animeName;
    private String genre;
    private String type; // Figure, Plushie, Poster, etc.
    private String dimensions;
    private String material;

    public AnimeMerchProduct() {
    }
    public AnimeMerchProduct(String productId, String name, String description, float price, int quantityInStock, String brand, String animeName, String genre, String type, String dimensions, String material) {
        super(productId, name, description, price, quantityInStock, brand);
        this.animeName = animeName;
        this.genre = genre;
        this.type = type;
        this.dimensions = dimensions;
        this.material = material;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
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
                + "Anime Name: " + animeName + "\n\t"
                + "Genre: " + genre + "\n\t"
                + "Type: " + type + "\n\t"
                + "Dimensions: " + dimensions + "\n\t"
                + "Material: " + material + "\n";
    }
}
