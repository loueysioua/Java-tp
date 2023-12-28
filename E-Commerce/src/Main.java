import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElectronicProduct electronicProduct = new ElectronicProduct("123", "TV", "TV", 1000, 10, "Samsung","TV", "Black", "10kg", "100x100", "100W");
        ClothingProduct clothingProduct = new ClothingProduct("456", "Shirt", "Shirt", 100, 10, "Nike", "M", "Black", "Cotton");
        GamingProduct gamingProduct = new GamingProduct("789", "Game", "Game", 100, 10, "EA", "PC", "Action", "18+", "01/01/2020", "EA");
        AnimeMerchProduct animeMerchProduct = new AnimeMerchProduct("101", "Figure", "Figure", 100, 10, "Bandai", "Naruto", "Action", "Figure", "10x10", "Plastic");
        SeriesMerchProduct seriesMerchProduct = new SeriesMerchProduct("112", "Figure", "Figure", 100, 10, "Bandai", "GameOfThrones", "Action", "Figure", "10x10", "Plastic");
        HomeDecoProduct homeDecoProduct = new HomeDecoProduct("113", "Table", "Table", 100, 10, "IKEA", "Wood", "Table", "Brown", "10kg", "Modern", "Living Room", "100x100x100");
        CouponsAndDicountCodes.codes.put("123", new CouponsAndDicountCodes("123", 10, "percentage", 0));
        ProductManager productManager = new ProductManager();
        AuthentificationSystem authentificationSystem = new AuthentificationSystem(productManager);
        Admin admin = new Admin(productManager,"Alex" , "Nero xD" , "ojqhdo@gmail.com" , "123456789" , "26565656565", authentificationSystem,"qdqsdg");
        User user = new User(authentificationSystem,productManager, "Alex", "Nero xD", "qsdlj@gmail.com", "123456789", "26565656565","6856556295");
        admin.addProduct(gamingProduct);
        admin.addProduct(clothingProduct);
        admin.addProduct(electronicProduct);
        admin.addProduct(animeMerchProduct);
        admin.addProduct(seriesMerchProduct);
        admin.addProduct(homeDecoProduct);
        //register or login :
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email : ");
        String email = scanner.nextLine();
        System.out.println("Enter your password : ");
        String password = scanner.nextLine();
        if( authentificationSystem.login(email, password) ){
            if (authentificationSystem.findAdmin(email) != null) {
                Admin admin1 = authentificationSystem.findAdmin(email);
                Admin.AdminMenu(admin1);
            }
            else if (authentificationSystem.findUser(email) != null){
                User.userMenu(authentificationSystem.findUser(email));
            }
        }


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