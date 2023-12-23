public class ClothingProduct extends Product{
    private String size;
    private String color;
    private String material;

    public ClothingProduct() {
    }

    public ClothingProduct(String productId, String name, String description, float price, int quantityInStock, String brand ,String size, String color, String material) {
        super(productId, name, description, price, quantityInStock,brand);
        this.size = size;
        this.color = color;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Size: " + size + "\n\t" +
                "Color: " + color + "\n\t" +
                "Material: " + material + "\n";
    }
}
