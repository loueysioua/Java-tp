import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElectronicProduct electronicProduct = new ElectronicProduct("123", "TV", "TV", 1000, 10, "Samsung","TV", "Black", "10kg", "100x100", "100W");
        ClothingProduct clothingProduct = new ClothingProduct("456", "Shirt", "Shirt", 50, 10, "Nike", "M", "Black", "Cotton");
        GamingProduct gamingProduct = new GamingProduct("789", "Game", "Game", 5, 10, "EA", "PC", "Action", "18+", "01/01/2020", "EA");
        AnimeMerchProduct animeMerchProduct = new AnimeMerchProduct("101", "Figure", "Figure", 10, 10, "Bandai", "Naruto", "Action", "Figure", "10x10", "Plastic");
        SeriesMerchProduct seriesMerchProduct = new SeriesMerchProduct("112", "Figure", "Figure", 15, 10, "Bandai", "GameOfThrones", "Action", "Figure", "10x10", "Plastic");
        HomeDecoProduct homeDecoProduct = new HomeDecoProduct("113", "Table", "Table", 20, 7, "IKEA", "Wood", "Table", "Brown", "10kg", "Modern", "Living Room", "100x100x100");
        CouponsAndDicountCodes.codes.put("123", new CouponsAndDicountCodes("123", 10, "percentage", 0));
        ProductManager productManager = new ProductManager();
        AuthentificationSystem authentificationSystem = new AuthentificationSystem(productManager);
        Admin admin = new Admin(productManager,"Alex" , "Nero xD" , "ojqhdo@gmail.com" , "123456789" , "26565656565", authentificationSystem,"qdqsdg");
        User user = new User(authentificationSystem,productManager, "Lex", "Blue Rose", "qsdlj@gmail.com", "123456789", "26565656565","6856556295");
        admin.addProduct(gamingProduct);
        admin.addProduct(clothingProduct);
        admin.addProduct(electronicProduct);
        admin.addProduct(animeMerchProduct);
        admin.addProduct(seriesMerchProduct);
        admin.addProduct(homeDecoProduct);
        //register or login :
        authentificationSystem.openMenu();


//        user.addToCart("123", 1);
//        user.addToCart("456", 9);
//        user.addToCart("789", 1);
//        user.addToCart("101", 15);
//        user.addToCart("112", 1);
//        user.addToCart("113", 1);
//        user.viewCart();
//        user.removeFromCart("123", 1);
//        user.viewCart();
//        user.checkout();
//        user.viewOrderHistory();


    }
}