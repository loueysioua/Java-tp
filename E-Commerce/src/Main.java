public class Main {
    public static void main(String[] args) {
        ElectronicProduct electronicProduct = new ElectronicProduct("123", "TV", "TV", 1000, 10, "Samsung","TV", "Black", "10kg", "100x100", "100W");
        ClothingProduct clothingProduct = new ClothingProduct("456", "Shirt", "Shirt", 100, 10, "Nike", "M", "Black", "Cotton");
        GamingProduct gamingProduct = new GamingProduct("789", "Game", "Game", 100, 10, "EA", "PC", "Action", "18+", "01/01/2020", "EA");
        AnimeMerchProduct animeMerchProduct = new AnimeMerchProduct("101", "Figure", "Figure", 100, 10, "Bandai", "Naruto", "Action", "Figure", "10x10", "Plastic");
        SeriesMerchProduct seriesMerchProduct = new SeriesMerchProduct("112", "Figure", "Figure", 100, 10, "Bandai", "GameOfThrones", "Action", "Figure", "10x10", "Plastic");
        HomeDecoProduct homeDecoProduct = new HomeDecoProduct("113", "Table", "Table", 100, 10, "IKEA", "Wood", "Table", "Brown", "10kg", "Modern", "Living Room", "100x100x100");
        ProductManager productManager = new ProductManager();
        productManager.addProduct(electronicProduct);
        productManager.addProduct(clothingProduct);
        productManager.addProduct(gamingProduct);
        productManager.addProduct(animeMerchProduct);
        productManager.addProduct(seriesMerchProduct);
        productManager.printAllProducts();
        productManager.updateProduct("123", electronicProduct.getClass());
        productManager.printProductDetails("123",electronicProduct.getClass());
    }
}