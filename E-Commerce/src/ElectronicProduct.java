public class ElectronicProduct extends Product {
    private String model;
    private String color;
    private String weight;
    private String dimensions;
    private String electricPower;

    public ElectronicProduct() {
    }

    public ElectronicProduct(String productId, String name, String description, float price, int quantityInStock, String brand ,String model, String color, String weight, String dimensions, String electricPower) {
        super(productId, name, description, price, quantityInStock, brand);
        this.model = model;
        this.color = color;
        this.weight = weight;
        this.dimensions = dimensions;
        this.electricPower = electricPower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getElectricPower() {
        return electricPower;
    }

    public void setElectricPower(String electricPower) {
        this.electricPower = electricPower;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Model: " + model + "\n\t" +
                "Color: " + color + "\n\t" +
                "Weight: " + weight + "\n\t" +
                "Dimensions: " + dimensions + "\n\t" +
                "Electric Power: " + electricPower + "\n";
    }
}
