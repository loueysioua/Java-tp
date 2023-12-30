public class HomeDecoProduct extends Product {
    private String material;
    private String type ;//furniture, decoration, etc
    private String color;
    private String weight;
    private String style;
    private String room;
    private String dimensions;

    public HomeDecoProduct() {
    }

    public HomeDecoProduct(String productId, String name, String description, float price, int quantityInStock, String brand, String material, String type, String color, String weight, String style, String room, String dimensions) {
        super(productId, name, description, price, quantityInStock, brand);
        this.material = material;
        this.type = type;
        this.color = color;
        this.weight = weight;
        this.style = style;
        this.room = room;
        this.dimensions = dimensions;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return super.toString()
                +"Material: "+material+"\n\t"+
                "Type: "+type+"\n\t"+
                "Color: "+color+"\n\t"+
                "Weight: "+weight+"\n\t"+
                "Style: "+style+"\n\t"+
                "Room: "+room+"\n\t"+
                "Dimensions: "+dimensions+"\n\t";
    }
}
