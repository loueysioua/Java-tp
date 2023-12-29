import java.util.Scanner;

public class Admin {
    private ProductManager productManager;
    private String name;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private AuthentificationSystem authentificationSystem;
    private String adress;
    public Admin(ProductManager productManager, String name, String username, String email, String password, String phoneNumber, AuthentificationSystem authentificationSystem , String adress) {
        this.productManager = productManager;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.authentificationSystem = authentificationSystem;
        this.authentificationSystem.registerAdmin(this);
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addProduct(Product product) {
        productManager.addProduct(product);
    }

    public void removeProduct(String productId) {
        Product product = productManager.findProduct(productId);
        if (product != null) {
            productManager.removeProduct(product.getProductId(), product.getClass());
        }
        else {
            System.out.println("Product not found!");
        }
    }

    public void updateProduct(Product product) {
        Product updatedProduct = productManager.findProduct(product.getProductId());
        if (updatedProduct != null) {
            productManager.updateProduct(updatedProduct.getProductId(), product.getClass());
        }
        else {
            System.out.println("Product not found!");
        }
    }

    public void seeStock() {
        productManager.printAllProducts();
    }

    public void seeLowStockProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the stock value: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        productManager.handleLowStockProducts(stock);
    }

    //put product on sale
    public void putProductOnSale() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product id: ");
        String productId = scanner.nextLine();
        System.out.println("Enter the discount: ");
        float discount = scanner.nextFloat();
        scanner.nextLine();
        productManager.putOnSaleAProduct(productId, discount);
    }

    //put a category of products on sale
    public void putCategoryOnSale() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the category: ");
        System.out.println("1. ElectronicProduct");
        System.out.println("2. ClothingProduct");
        System.out.println("3. GamingProduct");
        System.out.println("4. AnimeMerchProduct");
        System.out.println("5. SeriesMerchProduct");
        System.out.println("6. HomeDecoProduct");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the discount: ");
        float discount = scanner.nextFloat();
        scanner.nextLine();
        switch (choice) {
            case 1:
                productManager.putOnSaleACategory(ElectronicProduct.class, discount);
                break;
            case 2:
                productManager.putOnSaleACategory(ClothingProduct.class, discount);
                break;
            case 3:
                productManager.putOnSaleACategory(GamingProduct.class, discount);
                break;
            case 4:
                productManager.putOnSaleACategory(AnimeMerchProduct.class, discount);
                break;
            case 5:
                productManager.putOnSaleACategory(SeriesMerchProduct.class, discount);
                break;
            case 6:
                productManager.putOnSaleACategory(HomeDecoProduct.class, discount);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    //put all products on sale
    public void putAllProductsOnSale() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the discount: ");
        float discount = scanner.nextFloat();
        scanner.nextLine();
        productManager.putOnSaleAllProducts(discount);
    }

    public void searchForProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product id: ");
        String productId = scanner.nextLine();
        Product product = productManager.findProduct(productId);
        if (product != null) {
            System.out.println(product);
        }
    }
    public void searchByTermInNameAndDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the term: ");
        String term = scanner.nextLine();
        productManager.searchByTermInNameAndDescription(term);
    }

    public void filterByCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the category: ");
        System.out.println("1. ElectronicProduct");
        System.out.println("2. ClothingProduct");
        System.out.println("3. GamingProduct");
        System.out.println("4. AnimeMerchProduct");
        System.out.println("5. SeriesMerchProduct");
        System.out.println("6. HomeDecoProduct");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                productManager.printAllProductsOfACategory(ElectronicProduct.class);
                break;
            case 2:
                productManager.printAllProductsOfACategory(ClothingProduct.class);
                break;
            case 3:
                productManager.printAllProductsOfACategory(GamingProduct.class);
                break;
            case 4:
                productManager.printAllProductsOfACategory(AnimeMerchProduct.class);
                break;
            case 5:
                productManager.printAllProductsOfACategory(SeriesMerchProduct.class);
                break;
            case 6:
                productManager.printAllProductsOfACategory(HomeDecoProduct.class);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void filterByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the min price: ");
        float minPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the max price: ");
        float maxPrice = scanner.nextFloat();
        scanner.nextLine();
        for (Product p : productManager.filterByPriceRange(minPrice, maxPrice)){
            System.out.println("Product: " + p.getName() + " Price: " + p.getPrice());
        }
    }

    public void filterByBrand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the brand: ");
        String brand = scanner.nextLine();
        for (Product p : productManager.filterByBrand(brand)){
            System.out.println("Product: " + p.getName() + " Brand: " + p.getBrand());
        }
    }

    //filter by quantity range
    public void filterByQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the min quantity: ");
        int minQuantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the max quantity: ");
        int maxQuantity = scanner.nextInt();
        scanner.nextLine();
        for (Product p : productManager.filterByQuantityRange(minQuantity, maxQuantity)){
            System.out.println("ProductID: " +p.getProductId()+"\tProduct Name: "+ p.getName() + "\tQuantity: " + p.getQuantityInStock());
        }
    }

    //create Admin Menu (Admin.java)
    public static void AdminMenu(Admin admin) {
        //Admin must log in first
        Scanner scanner = new Scanner(System.in);
        if (admin.authentificationSystem.getLoggedInAdmins().containsKey(admin.getEmail())) {
            System.out.println("Welcome " + admin.getName() + "!");
            int choice = 0;
            while (choice != 24) {
                System.out.println("0. Add a coupon or a discount code");
                System.out.println("1. Add product");
                System.out.println("2. Remove product");
                System.out.println("3. Update product");
                System.out.println("4. See stock");
                System.out.println("5. See low stock products");
                System.out.println("6. Put product on sale");
                System.out.println("7. Put a category of products on sale");
                System.out.println("8. Put all products on sale");
                System.out.println("9. Search for product");
                System.out.println("10. Search by term in name and description");
                System.out.println("11. Filter by category");
                System.out.println("12. Filter by price");
                System.out.println("13. Filter by quantity");
                System.out.println("14. Filter dynamically");
                //Admins can modify the authentification system
                System.out.println("15. Register as a user");
                System.out.println("16. Remove user");
                System.out.println("17. Remove admin");
                System.out.println("18. View all users");
                System.out.println("19. View all admins");
                System.out.println("20. View all logged in users");
                System.out.println("21. View all logged in admins");
                System.out.println("22. Log in as a user");
                System.out.println("23. Logout");
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        System.out.println("Enter the code: ");
                        String code = scanner.nextLine();
                        CouponsAndDicountCodes.addCode(code);
                        break;
                    case 1: {
                        System.out.println("Enter the product id: ");
                        String productId = scanner.nextLine();
                        System.out.println("Enter the product name: ");
                        String productName = scanner.nextLine();
                        System.out.println("Enter the product description: ");
                        String productDescription = scanner.nextLine();
                        System.out.println("Enter the product price: ");
                        float productPrice = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("Enter the product quantity: ");
                        int productQuantity = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the product brand: ");
                        String productBrand = scanner.nextLine();
                        System.out.println("Enter the product category: ");
                        System.out.println("1. ElectronicProduct");
                        System.out.println("2. ClothingProduct");
                        System.out.println("3. GamingProduct");
                        System.out.println("4. AnimeMerchProduct");
                        System.out.println("5. SeriesMerchProduct");
                        System.out.println("6. HomeDecoProduct");
                        int productCategory = scanner.nextInt();
                        scanner.nextLine();
                        //fill the rest with the fields
                        switch (productCategory) {
                            case 1:
                                System.out.println("Enter the product type: ");
                                String productType = scanner.nextLine();
                                System.out.println("Enter the product color: ");
                                String productColor = scanner.nextLine();
                                System.out.println("Enter the product weight: ");
                                String productWeight = scanner.nextLine();
                                scanner.nextLine();
                                System.out.println("Enter the product dimensions: ");
                                String productDimensions = scanner.nextLine();
                                System.out.println("Enter the product electric power: ");
                                String productElectricPower = scanner.nextLine();
                                ElectronicProduct electronicProduct = new ElectronicProduct(productId, productName, productDescription, productPrice, productQuantity, productBrand, productType, productColor, productWeight, productDimensions, productElectricPower);
                                admin.addProduct(electronicProduct);
                                break;

                            case 2:
                                System.out.println("Enter the product size: ");
                                String productSize = scanner.nextLine();
                                System.out.println("Enter the product color: ");
                                String productColor2 = scanner.nextLine();
                                System.out.println("Enter the product material: ");
                                String productMaterial = scanner.nextLine();
                                ClothingProduct clothingProduct = new ClothingProduct(productId, productName, productDescription, productPrice, productQuantity, productBrand, productSize, productColor2, productMaterial);
                                admin.addProduct(clothingProduct);
                                break;

                            case 3:
                                System.out.println("Enter the product platform: ");
                                String productPlatform = scanner.nextLine();
                                System.out.println("Enter the product genre: ");
                                String productGenre = scanner.nextLine();
                                System.out.println("Enter the product age restriction: ");
                                String productAgeRestriction = scanner.nextLine();
                                System.out.println("Enter the product release date: ");
                                String productReleaseDate = scanner.nextLine();
                                System.out.println("Enter the product publisher: ");
                                String productPublisher = scanner.nextLine();
                                GamingProduct gamingProduct = new GamingProduct(productId, productName, productDescription, productPrice, productQuantity, productBrand, productPlatform, productGenre, productAgeRestriction, productReleaseDate, productPublisher);
                                admin.addProduct(gamingProduct);
                                break;

                            case 4:
                                System.out.println("Enter the product anime name: ");
                                String productAnimeName = scanner.nextLine();
                                System.out.println("Enter the product anime genre: ");
                                String productAnimeGenre = scanner.nextLine();
                                System.out.println("Enter the product anime type: ");
                                String productAnimeType = scanner.nextLine();
                                System.out.println("Enter the product anime size: ");
                                String productAnimeSize = scanner.nextLine();
                                System.out.println("Enter the product anime material: ");
                                String productAnimeMaterial = scanner.nextLine();
                                AnimeMerchProduct animeMerchProduct = new AnimeMerchProduct(productId, productName, productDescription, productPrice, productQuantity, productBrand, productAnimeName, productAnimeGenre, productAnimeType, productAnimeSize, productAnimeMaterial);
                                admin.addProduct(animeMerchProduct);
                                break;

                            case 5:
                                System.out.println("Enter the product series name: ");
                                String productSeriesName = scanner.nextLine();
                                System.out.println("Enter the product series genre: ");
                                String productSeriesGenre = scanner.nextLine();
                                System.out.println("Enter the product series type: ");
                                String productSeriesType = scanner.nextLine();
                                System.out.println("Enter the product series size: ");
                                String productSeriesSize = scanner.nextLine();
                                System.out.println("Enter the product series material: ");
                                String productSeriesMaterial = scanner.nextLine();
                                SeriesMerchProduct seriesMerchProduct = new SeriesMerchProduct(productId, productName, productDescription, productPrice, productQuantity, productBrand, productSeriesName, productSeriesGenre, productSeriesType, productSeriesSize, productSeriesMaterial);
                                admin.addProduct(seriesMerchProduct);
                                break;

                            case 6:
                                System.out.println("Enter the product material: ");
                                String productMaterial2 = scanner.nextLine();
                                System.out.println("Enter the product type: ");
                                String productType2 = scanner.nextLine();
                                System.out.println("Enter the product color: ");
                                String productColor3 = scanner.nextLine();
                                System.out.println("Enter the product weight: ");
                                String productWeight2 = scanner.nextLine();
                                scanner.nextLine();
                                System.out.println("Enter the product style: ");
                                String productStyle = scanner.nextLine();
                                System.out.println("Enter the product room: ");
                                String productRoom = scanner.nextLine();
                                System.out.println("Enter the product dimensions: ");
                                String productDimensions2 = scanner.nextLine();
                                HomeDecoProduct homeDecoProduct = new HomeDecoProduct(productId, productName, productDescription, productPrice, productQuantity, productBrand, productMaterial2, productType2, productColor3, productWeight2, productStyle, productRoom, productDimensions2);
                                admin.addProduct(homeDecoProduct);
                                break;

                        }
                        break;
                    }

                    case 2:
                        System.out.println("Enter the product id: ");
                        String productId2 = scanner.nextLine();
                        admin.removeProduct(productId2);
                        break;

                    case 3:
                        System.out.println("Enter the product id: ");
                        String productId3 = scanner.nextLine();
                        admin.updateProduct(admin.productManager.findProduct(productId3));
                        break;

                    case 4:
                        admin.seeStock();
                        break;

                    case 5:
                        admin.seeLowStockProducts();
                        break;

                    case 6:
                        admin.putProductOnSale();
                        break;

                    case 7:
                        admin.putCategoryOnSale();
                        break;

                    case 8:
                        admin.putAllProductsOnSale();
                        break;

                    case 9:
                        admin.searchForProduct();
                        break;

                    case 10:
                        admin.searchByTermInNameAndDescription();
                        break;

                    case 11:
                        admin.filterByCategory();
                        break;

                    case 12:
                        admin.filterByPrice();
                        break;

                    case 13:
                        admin.filterByQuantity();
                        break;

                    case 14:
                        System.out.println("Enter the term: ");
                        String term = scanner.nextLine();
                        admin.productManager.filterByDynamicFilters();
                        break;

                    case 15:
                        System.out.println("Enter your adress: ");
                        String adress = scanner.nextLine();
                        User user = new User(admin.authentificationSystem,admin.productManager, admin.name,admin.username, admin.email, admin.password, admin.phoneNumber, adress);
                        break;

                    case 16:
                        System.out.println("Enter the user email: ");
                        String userEmail = scanner.nextLine();
                        admin.authentificationSystem.kickUser(userEmail);
                        break;

                    case 17:
                        System.out.println("Enter the admin email: ");
                        String adminEmail = scanner.nextLine();
                        admin.authentificationSystem.kickAdmin(adminEmail);
                        break;

                    case 18:
                        admin.authentificationSystem.viewUsers();
                        break;

                    case 19:
                        admin.authentificationSystem.viewAdmins();
                        break;

                    case 20:
                        admin.authentificationSystem.viewLoggedInUsers();
                        break;

                    case 21:
                        admin.authentificationSystem.viewLoggedInAdmins();
                        break;

                    case 22:
                        if(admin.authentificationSystem.findUser(admin.email) != null) {
                            admin.authentificationSystem.login(admin.email, admin.password);
                            //display the user menu:
                            User.userMenu(admin.authentificationSystem.findUser(admin.email));
                        }
                        else {
                            System.out.println("Register yourself as a User first!");
                        }
                        break;

                    case 23:
                        admin.authentificationSystem.logout(admin.email);
                        break;

                }
                if( ! admin.authentificationSystem.getLoggedInAdmins().containsKey(admin.getEmail()))
                    break;
                System.out.println("Would you like to continue? (1. y/2. n)");
                choice = scanner.nextInt();
                if(choice ==2)
                    break;

            }
        } else {
            System.out.println("You must log in first!");
        }
    }


}
