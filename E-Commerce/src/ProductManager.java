import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class ProductManager {
    //a hashmap that maps a category to a hashmap that contains all products of that category
    private HashMap<Class<? extends Product>, HashMap<String, Product>> categoryProductMap ;

    public ProductManager() {
        categoryProductMap = new HashMap<>();
        categoryProductMap.put(ElectronicProduct.class, new HashMap<>());
        categoryProductMap.put(ClothingProduct.class, new HashMap<>());
        categoryProductMap.put(GamingProduct.class, new HashMap<>());
        categoryProductMap.put(AnimeMerchProduct.class, new HashMap<>());
        categoryProductMap.put(SeriesMerchProduct.class, new HashMap<>());
        categoryProductMap.put(HomeDecoProduct.class, new HashMap<>());
    }

    //add a product to the hashmap
    public void addProduct(Product product) {
        if (categoryProductMap.get(product.getClass()).containsKey(product.getProductId()))
            categoryProductMap.get(product.getClass()).get(product.getProductId()).addQuantityInStock(product.getQuantityInStock());
        categoryProductMap.get(product.getClass()).put(product.getProductId(), product);
    }
    //remove a product from the hashmap if the category exists and the product exists in the category
    //else if the product doesn't exist in the category, print a message
    //else if the category doesn't exist, print a message
    public void removeProduct(String productId, Class<? extends Product> productClass) {
        HashMap <String, Product> productMap = categoryProductMap.get(productClass);
        if (productMap !=null ) {
            Product removedProduct = productMap.remove(productId);
            if (removedProduct != null) {
                System.out.println("Product " + removedProduct.getProductId()+" removed successfully from the category: "+ productClass.getSimpleName() +"\n");
            } else {
                System.out.println("Product not found in the category:"+ productClass.getSimpleName() +"\n");
            }
        }
        else{
            System.out.println(productClass.getSimpleName() + " category doesn't exist\n");
        }
    }

    public void printAllProductsOfACategory(Class<? extends Product> productClass) {
        HashMap <String, Product> productMap = categoryProductMap.get(productClass);
        if (productMap !=null ) {
            System.out.println("---------------Displaying Products of the category "+productClass.getSimpleName()+"------------------");
            System.out.println("Products in the category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct stock" );
            for (Product product : productMap.values()) {
                System.out.println(" -\t "+product.getProductId()+"\t\t:\t\t"+product.getName()+"\t\t:\t\t"+product.getQuantityInStock()+"\n\t");
            }
        }
        else{
            System.out.println("---------------Category doesn't exist------------------");
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void printProductDetails(String productId) {
        Product productToBeFound = findProduct(productId);
        if(productToBeFound!=null) {
            Class<? extends Product> productClass = productToBeFound.getClass();
            HashMap<String, Product> productMap = categoryProductMap.get(productClass);
            if (productMap != null) {
                Product product = productMap.get(productId);
                if (product != null) {
                    System.out.println(product);
                } else {
                    System.out.println("Product not found in the category:" + productClass.getSimpleName() + "\n");
                }
            } else {
                System.out.println(productClass.getSimpleName() + " category doesn't exist\n");
            }
        }
    }

    public void printAllProducts() {
        System.out.println("--------------------------All products-----------------------");
        for (HashMap<String, Product> productMap : categoryProductMap.values()) {
            Iterator<Product> it = productMap.values().iterator();
            if(it.hasNext()) {
                System.out.println("Products in the category: " + it.next().getClass().getSimpleName() + "\n\tProduct ID \t|\tProduct Name \t|\tProduct stock \t|\tProduct price");
                for (Product product : productMap.values()) {
                    System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() +"\t\t:\t\t"+product.getQuantityInStock()+ "\t\t:\t\t"+product.getPrice()+"$");
                }
            }
        }
    }
    //find a product in a category if category is added as a parameter the search will be faster
    public Product findProduct(String productId, Class<? extends Product> productClass) {
        HashMap <String, Product> productMap = categoryProductMap.get(productClass);
        if (productMap !=null ) {
            Product product = productMap.get(productId);
            if (product != null) {
                return product;
            } else {
                System.out.println("Product not found in the category:"+ productClass.getSimpleName() +"\n");
            }
        }
        else{
            System.out.println(productClass.getSimpleName() + " category doesn't exist\n");
        }
        return null;
    }
//find a product in all categories the search will be slower and there are no msgs
    public Product findProduct(String productId) {
        for (HashMap<String, Product> productMap : categoryProductMap.values()) {
            Product product = productMap.get(productId);
            if (product != null) {
                return product;
            }
        }
        System.out.println("Product not found\n");
        return null;
    }

    public void updateProduct(String productId, Class<? extends Product> productClass ) {
        HashMap <String, Product> productMap = categoryProductMap.get(productClass);
        if (productMap !=null ) {
            Product product = productMap.get(productId);
            if (product != null) {
                Scanner sc = new Scanner(System.in);
                String input;
                System.out.println("What would you like to update ? : (Name / Price / Quantity / Description) ");
                switch (sc.nextLine()) {
                    case "Name":
                        System.out.println("Enter the new name: ");
                        input = sc.nextLine();
                        product.setName(input);
                        System.out.println("Product name updated successfully");
                        break;
                    case "Price":
                        System.out.println("Enter the new price: ");
                        float newPrice = sc.nextFloat();
                        product.setPrice(newPrice);
                        System.out.println("Product price updated successfully");
                        break;
                    case "Quantity":
                        System.out.println("Enter the new quantity in stock: ");
                        input = sc.nextLine();
                        product.setQuantityInStock(Integer.parseInt(input));
                        System.out.println("Product quantity updated successfully");
                        break;
                    case "Description":
                        System.out.println("Enter the new description: ");
                        input = sc.nextLine();
                        product.setDescription(input);
                        System.out.println("Product description updated successfully");
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } else {
                System.out.println("Product not found in the category:"+ productClass.getSimpleName() +"\n");
            }
        }
        else{
            System.out.println(productClass.getSimpleName() + " category doesn't exist\n");
        }
    }

    public void handleLowStockProducts(int threshold) {
        System.out.println("---------------Displaying Products with low stock------------------");
        for (HashMap<String, Product> productMap : categoryProductMap.values()) {
            for (Product product : productMap.values()) {
                if (product.getQuantityInStock() <= threshold) {
                    System.out.println("ALERT!! Low stock on product: " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getQuantityInStock());
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void handleOutOfStockProducts() {
        System.out.println("---------------Displaying Products with no stock------------------");
        for (HashMap<String, Product> productMap : categoryProductMap.values()) {
            for (Product product : productMap.values()) {
                if (product.getQuantityInStock() == 0) {
                    System.out.println("ALERT!! No stock on product: " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getQuantityInStock());
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void putOnSaleAProduct(String productId, float discount) {
        Product product = findProduct(productId);
        if (product != null) {
            product.setPrice(product.getPrice() * (100 - discount) / 100);
            System.out.println("Product " + product.getProductId() + " is now on sale with a discount of " + discount + "%");
        }
        else {
            System.out.println("Product not found");
        }
    }

    public void putOnSaleACategory(Class<? extends Product> productClass, float discount) {
        HashMap <String, Product> productMap = categoryProductMap.get(productClass);
        if (productMap !=null ) {
            for (Product product : productMap.values()) {
                product.setPrice(product.getPrice() * (100 - discount) / 100);
            }
            System.out.println("Category " + productClass.getSimpleName() + " is now on sale with a discount of " + discount + "%");
        }
        else{
            System.out.println(productClass.getSimpleName() + " category doesn't exist\n");
        }
    }

    public void putOnSaleAllProducts(float discount) {
        for (HashMap<String, Product> productMap : categoryProductMap.values()) {
            for (Product product : productMap.values()) {
                product.setPrice(product.getPrice() * (100 - discount) / 100);
            }
        }
        System.out.println("All products are now on sale with a discount of " + discount + "%");
    }

    //search for a product by a term in its name or in its description User can filter the results by price range / quantity range / category
    public void searchByTermInNameAndDescription(String search) {
        ArrayList<Product> products = new ArrayList<>();
        for (HashMap<String, Product> productMap : categoryProductMap.values()) {
            for (Product product : productMap.values()) {
                if (product.getName().contains(search) || product.getDescription().contains(search)) {
                    products.add(product);
                }
            }
        }
        System.out.println("---------------Displaying Products------------------");
        System.out.println("Products that contain the term: " + search + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
        for (Product product : products) {
            System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock());
        }
        //choice to filter : price range / quantity range / category
        System.out.println("Do you want to filter the results ? : (Yes / No) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("YES")) {
            System.out.println("Do you want to filter by Price ? : (Yes / No) ");
            input = sc.nextLine();
            //filter by price
            if (input.equalsIgnoreCase("YES")){
                System.out.println("Enter the min price: ");
                float minPrice = sc.nextFloat();
                sc.nextLine();
                System.out.println("Enter the max price: ");
                float maxPrice = sc.nextFloat();
                sc.nextLine();
                System.out.println();
                if (minPrice>=0 && maxPrice>=0) {
                    if (minPrice > maxPrice) {
                        float aux = minPrice;
                        minPrice = maxPrice;
                        maxPrice = aux;
                    }
                    for (int i=0 ; i<products.size() ; i++) {
                        if (products.get(i).getPrice() < minPrice || products.get(i).getPrice() > maxPrice) {
                            products.remove(products.get(i));
                            i--;
                        }
                    }
                }
                else{
                    System.out.println("Invalid Prices");
                }
            }
            System.out.println("Do you want to filter by Quantity ? : (Yes / No) ");
            input = sc.nextLine();
            //filter by quantity
            if (input.equalsIgnoreCase("YES")){
                System.out.println("Enter the min quantity: ");
                int minQuantity = Integer.parseInt(sc.nextLine());
                System.out.println("Enter the max quantity: ");
                int maxQuantity = Integer.parseInt(sc.nextLine());
                if(minQuantity>=0 && maxQuantity>=0){
                    if (minQuantity>maxQuantity){
                        int aux = minQuantity;
                        minQuantity = maxQuantity;
                        maxQuantity = aux;
                    }
                    for (Product product : products) {
                        if (product.getQuantityInStock() < minQuantity || product.getQuantityInStock() > maxQuantity) {
                            products.remove(product);
                        }
                    }
                }
                else{
                    System.out.println("Invalid Quantities");
                }
            }
            System.out.println("Do you want to filter by Category ? : (Yes / No) ");
            input = sc.nextLine();
            //filter by category
            if (input.equalsIgnoreCase("YES")){
                System.out.println("Enter the category: ");
                input = sc.nextLine();
                Class<? extends Product> productClass = switch (input) {
                    case "ElectronicProduct" -> ElectronicProduct.class;
                    case "ClothingProduct" -> ClothingProduct.class;
                    case "GamingProduct" -> GamingProduct.class;
                    case "AnimeMerchProduct" -> AnimeMerchProduct.class;
                    case "SeriesMerchProduct" -> SeriesMerchProduct.class;
                    case "HomeDecoProduct" -> HomeDecoProduct.class;
                    default -> null;
                };
                products.removeIf(product -> product.getClass() != productClass);
            }
            System.out.println("---------------Displaying Products by filters you chose------------------");
            System.out.println("Products that contain the term: " + search + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
            for (Product product : products) {
                System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
            }
            System.out.println("------------------------------------------------------------------------------------");
        }
    }

    //search for products in a range of prices returns a list of products
    public ArrayList<Product> filterByPriceRange(float minPrice, float maxPrice) {
        ArrayList<Product> products = new ArrayList<>();
        if (minPrice>=0 && maxPrice>=0) {
            if (minPrice > maxPrice) {
                float aux = minPrice;
                minPrice = maxPrice;
                maxPrice = aux;
            }
            for (HashMap<String, Product> productMap : categoryProductMap.values()) {
                for (Product product : productMap.values()) {
                    if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                        products.add(product);
                    }
                }
            }
        }
        else{
            System.out.println("Invalid Prices");
        }
        return products;
    }

    //search for products in a range of quantities for admins to check the stock
    public ArrayList<Product> filterByQuantityRange(int minQuantity, int maxQuantity) {
        ArrayList<Product> products = new ArrayList<>();
        if(minQuantity>=0 && maxQuantity>=0){
            if (minQuantity>maxQuantity){
                int aux = minQuantity;
                minQuantity = maxQuantity;
                maxQuantity = aux;
            }
            for (HashMap<String, Product> productMap : categoryProductMap.values()) {
                for (Product product : productMap.values()) {
                    if (product.getQuantityInStock() >= minQuantity && product.getQuantityInStock() <= maxQuantity) {
                        products.add(product);
                    }
                }
            }
        }
        else{
            System.out.println("Invalid Quantities");
        }
        return products;
    }

    //filer products by category
    public ArrayList<Product> filterByCategory(Class<? extends Product> productClass) {
        ArrayList<Product> products = new ArrayList<>();
        HashMap <String, Product> productMap = categoryProductMap.get(productClass);
        if (productMap !=null ) {
            products.addAll(productMap.values());
        }
        return products;
    }

    //filter products with dynamic filters (my biggest challenge in this project)
    public void filterByDynamicFilters() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("What would you like to filter by ? : (Price / Quantity / Category) ");
        input = sc.nextLine();
        switch (input) {
            //filtering by price as first filter (user may add other filters)
            case "Price":
                System.out.println("Enter the min price: ");
                float minPrice = Float.parseFloat(sc.nextLine());
                System.out.println("Enter the max price: ");
                float maxPrice = Float.parseFloat(sc.nextLine());
                ArrayList<Product> products = filterByPriceRange(minPrice, maxPrice);
                //User may add other filters here
                System.out.println("Do you want to add another filter ? : (Yes / No) ");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("YES")) {
                    System.out.println("What would you like to filter by ? : (Quantity / Category) ");
                    input = sc.nextLine();
                    switch (input) {
                        case "Quantity"://filtering by quantity as second filter (user may add other filters)
                            System.out.println("Enter the min quantity: ");
                            int minQuantity = Integer.parseInt(sc.nextLine());
                            System.out.println("Enter the max quantity: ");
                            int maxQuantity = Integer.parseInt(sc.nextLine());
                            if (minQuantity >= 0 && maxQuantity >= 0) {
                                if (minQuantity > maxQuantity) {
                                    int aux = minQuantity;
                                    minQuantity = maxQuantity;
                                    maxQuantity = aux;
                                }
                                for (Product product : products) {
                                    if (product.getQuantityInStock() < minQuantity || product.getQuantityInStock() > maxQuantity) {
                                        products.remove(product);
                                    }
                                }
                                //User may add category filter too
                                System.out.println("Do you want to filter by Category ? : (Yes / No) ");
                                input = sc.nextLine();
                                if (input.equalsIgnoreCase("YES")) {
                                    System.out.println("Enter the category: ");
                                    input = sc.nextLine();
                                    Class<? extends Product> productClass = switch (input) {
                                        case "ElectronicProduct" -> ElectronicProduct.class;
                                        case "ClothingProduct" -> ClothingProduct.class;
                                        case "GamingProduct" -> GamingProduct.class;
                                        case "AnimeMerchProduct" -> AnimeMerchProduct.class;
                                        case "SeriesMerchProduct" -> SeriesMerchProduct.class;
                                        case "HomeDecoProduct" -> HomeDecoProduct.class;
                                        default -> null;
                                    };
                                    products.removeIf(product -> product.getClass() != productClass);
                                    System.out.println("---------------Displaying Products------------------");
                                    System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and quantity range: " + minQuantity + " - " + maxQuantity + " and category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                    for (Product product : products) {
                                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                    }
                                }else{//if user doesn't want to filter by category //Display by price and quantity
                                    System.out.println("---------------Displaying Products------------------");
                                    System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and quantity range: " + minQuantity + " - " + maxQuantity + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                    for (Product product : products) {
                                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                    }
                                }
                            } else {
                                System.out.println("Invalid Quantities");
                            }
                            break;
                        case "Category"://filtering by category as second filter (user may add other filters)
                            System.out.println("Enter the category: ");
                            input = sc.nextLine();
                            Class<? extends Product> productClass = switch (input) {
                                case "ElectronicProduct" -> ElectronicProduct.class;
                                case "ClothingProduct" -> ClothingProduct.class;
                                case "GamingProduct" -> GamingProduct.class;
                                case "AnimeMerchProduct" -> AnimeMerchProduct.class;
                                case "SeriesMerchProduct" -> SeriesMerchProduct.class;
                                case "HomeDecoProduct" -> HomeDecoProduct.class;
                                default -> null;
                            };
                            products.removeIf(product -> product.getClass() != productClass);
                            //User may add quantity filter too
                            System.out.println("Do you want to filter by Quantity ? : (Yes / No) ");
                            input = sc.nextLine();
                            if (input.equalsIgnoreCase("YES")) {
                                System.out.println("Enter the min quantity: ");
                                minQuantity = Integer.parseInt(sc.nextLine());
                                System.out.println("Enter the max quantity: ");
                                maxQuantity = Integer.parseInt(sc.nextLine());
                                if (minQuantity >= 0 && maxQuantity >= 0) {
                                    if (minQuantity > maxQuantity) {
                                        int aux = minQuantity;
                                        minQuantity = maxQuantity;
                                        maxQuantity = aux;
                                    }
                                    for (Product product : products) {
                                        if (product.getQuantityInStock() < minQuantity || product.getQuantityInStock() > maxQuantity) {
                                            products.remove(product);
                                        }
                                    }
                                    System.out.println("---------------Displaying Products------------------");
                                    System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and quantity range: " + minQuantity + " - " + maxQuantity + " and category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                    for (Product product : products) {
                                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                    }
                                } else {
                                    System.out.println("Invalid Quantities");
                                }
                            } else {//if user doesn't want to filter by quantity //Display by price and category
                                System.out.println("---------------Displaying Products------------------");
                                System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                for (Product product : products) {
                                    System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                }
                            }
                            break;
                    }
                }else{//if user doesn't want to add another filter //Display by price
                    System.out.println("---------------Displaying Products------------------");
                    System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                    for (Product product : products) {
                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                    }
                }
                break;
            case "Quantity"://filtering by quantity as first filter (user may add other filters)
                System.out.println("Enter the min quantity: ");
                int minQuantity = Integer.parseInt(sc.nextLine());
                System.out.println("Enter the max quantity: ");
                int maxQuantity = Integer.parseInt(sc.nextLine());
                products = filterByQuantityRange(minQuantity, maxQuantity);
                //User may add other filters here
                System.out.println("Do you want to add another filter ? : (Yes / No) ");
                input = sc.nextLine();
                //if user wants to add another filter
                if (input.equalsIgnoreCase("YES")) {
                    System.out.println("What would you like to filter by ? : (Price / Category) ");
                    input = sc.nextLine();
                    switch (input) {
                        case "Price"://filtering by price as second filter (user may add other filters)
                            System.out.println("Enter the min price: ");
                            minPrice = Float.parseFloat(sc.nextLine());
                            System.out.println("Enter the max price: ");
                            maxPrice = Float.parseFloat(sc.nextLine());
                            if (minPrice >= 0 && maxPrice >= 0) {
                                if (minPrice > maxPrice) {
                                    float aux = minPrice;
                                    minPrice = maxPrice;
                                    maxPrice = aux;
                                }
                                for (Product product : products) {
                                    if (product.getPrice() < minPrice || product.getPrice() > maxPrice) {
                                        products.remove(product);
                                    }
                                }
                                //User may add category filter too
                                System.out.println("Do you want to filter by Category ? : (Yes / No) ");
                                input = sc.nextLine();
                                if (input.equalsIgnoreCase("YES")) {
                                    System.out.println("Enter the category: ");
                                    input = sc.nextLine();
                                    Class<? extends Product> productClass = switch (input) {
                                        case "ElectronicProduct" -> ElectronicProduct.class;
                                        case "ClothingProduct" -> ClothingProduct.class;
                                        case "GamingProduct" -> GamingProduct.class;
                                        case "AnimeMerchProduct" -> AnimeMerchProduct.class;
                                        case "SeriesMerchProduct" -> SeriesMerchProduct.class;
                                        case "HomeDecoProduct" -> HomeDecoProduct.class;
                                        default -> null;
                                    };
                                    products.removeIf(product -> product.getClass() != productClass);
                                    System.out.println("---------------Displaying Products------------------");
                                    System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and quantity range: " + minQuantity + " - " + maxQuantity + " and category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                    for (Product product : products) {
                                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                    }
                                }else{//if user doesn't want to filter by category //Display by quantity and price
                                    System.out.println("---------------Displaying Products------------------");
                                    System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and quantity range: " + minQuantity + " - " + maxQuantity + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                    for (Product product : products) {
                                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                    }
                                }
                            } else {
                                System.out.println("Invalid Prices");
                            }
                        case "Category"://filtering by category as second filter (user may add other filters)
                            System.out.println("Enter the category: ");
                            input = sc.nextLine();
                            Class<? extends Product> productClass = switch (input) {
                                case "ElectronicProduct" -> ElectronicProduct.class;
                                case "ClothingProduct" -> ClothingProduct.class;
                                case "GamingProduct" -> GamingProduct.class;
                                case "AnimeMerchProduct" -> AnimeMerchProduct.class;
                                case "SeriesMerchProduct" -> SeriesMerchProduct.class;
                                case "HomeDecoProduct" -> HomeDecoProduct.class;
                                default -> null;
                            };
                            products.removeIf(product -> product.getClass() != productClass);
                            //User may add price filter too
                            System.out.println("Do you want to filter by Price ? : (Yes / No) ");
                            input = sc.nextLine();
                            if (input.equalsIgnoreCase("YES")) {
                                System.out.println("Enter the min price: ");
                                minPrice = Float.parseFloat(sc.nextLine());
                                System.out.println("Enter the max price: ");
                                maxPrice = Float.parseFloat(sc.nextLine());
                                if (minPrice >= 0 && maxPrice >= 0) {
                                    if (minPrice > maxPrice) {
                                        float aux = minPrice;
                                        minPrice = maxPrice;
                                        maxPrice = aux;
                                    }
                                    for (Product product : products) {
                                        if (product.getPrice() < minPrice || product.getPrice() > maxPrice) {
                                            products.remove(product);
                                        }
                                    }
                                    System.out.println("---------------Displaying Products------------------");
                                    System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and quantity range: " + minQuantity + " - " + maxQuantity + " and category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                    for (Product product : products) {
                                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                    }
                                } else {
                                    System.out.println("Invalid Prices");
                                }
                            } else {//if user doesn't want to filter by price //Display by quantity and category
                                System.out.println("---------------Displaying Products------------------");
                                System.out.println("Products in the quantity range: " + minQuantity + " - " + maxQuantity + " and category:" + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                for (Product product : products) {
                                    System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                }
                            }
                    }
                } else {//if user doesn't want to add another filter //Display by quantity
                    System.out.println("---------------Displaying Products------------------");
                    System.out.println("Products in the quantity range: " + minQuantity + " - " + maxQuantity + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                    for (Product product : products) {
                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                    }
                }
                break;
            case "Category"://filtering by category as first filter (user may add other filters)
                System.out.println("Enter the category: ");
                input = sc.nextLine();
                Class<? extends Product> productClass = switch (input) {
                    case "ElectronicProduct" -> ElectronicProduct.class;
                    case "ClothingProduct" -> ClothingProduct.class;
                    case "GamingProduct" -> GamingProduct.class;
                    case "AnimeMerchProduct" -> AnimeMerchProduct.class;
                    case "SeriesMerchProduct" -> SeriesMerchProduct.class;
                    case "HomeDecoProduct" -> HomeDecoProduct.class;
                    default -> null;
                };
                products = filterByCategory(productClass);
                //User may add other filters here
                System.out.println("Do you want to add another filter ? : (Yes / No) ");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("YES")) {
                    System.out.println("What would you like to filter by ? : (Price / Quantity) ");
                    input = sc.nextLine();
                    switch (input) {
                        case "Price"://filtering by price as second filter (user may add other filters)
                            System.out.println("Enter the min price: ");
                            minPrice = Float.parseFloat(sc.nextLine());
                            System.out.println("Enter the max price: ");
                            maxPrice = Float.parseFloat(sc.nextLine());
                            if (minPrice >= 0 && maxPrice >= 0) {
                                if (minPrice > maxPrice) {
                                    float aux = minPrice;
                                    minPrice = maxPrice;
                                    maxPrice = aux;
                                }
                                for (Product product : products) {
                                    if (product.getPrice() < minPrice || product.getPrice() > maxPrice) {
                                        products.remove(product);
                                    }
                                }
                                //User may add quantity filter too
                                System.out.println("Do you want to filter by Quantity ? : (Yes / No) ");
                                input = sc.nextLine();
                                if (input.equalsIgnoreCase("YES")) {
                                    System.out.println("Enter the min quantity: ");
                                    minQuantity = Integer.parseInt(sc.nextLine());
                                    System.out.println("Enter the max quantity: ");
                                    maxQuantity = Integer.parseInt(sc.nextLine());
                                    if (minQuantity >= 0 && maxQuantity >= 0) {
                                        if (minQuantity > maxQuantity) {
                                            int aux = minQuantity;
                                            minQuantity = maxQuantity;
                                            maxQuantity = aux;
                                        }
                                        for (Product product : products) {
                                            if (product.getQuantityInStock() < minQuantity || product.getQuantityInStock() > maxQuantity) {
                                                products.remove(product);
                                            }
                                        }
                                        System.out.println("---------------Displaying Products------------------");
                                        System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and quantity range: " + minQuantity + " - " + maxQuantity + " and category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                        for (Product product : products) {
                                            System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                        }
                                    } else {
                                        System.out.println("Invalid Quantities");
                                    }
                                } else {//if user doesn't want to filter by quantity //Display by price and category
                                    System.out.println("---------------Displaying Products------------------");
                                    System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                    for (Product product : products) {
                                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                    }
                                }

                            } else {
                                System.out.println("Invalid Prices");
                            }

                        case "Quantity"://filtering by quantity as second filter (user may add other filters)
                            System.out.println("Enter the min quantity: ");
                            minQuantity = Integer.parseInt(sc.nextLine());
                            System.out.println("Enter the max quantity: ");
                            maxQuantity = Integer.parseInt(sc.nextLine());
                            if (minQuantity >= 0 && maxQuantity >= 0) {
                                if (minQuantity > maxQuantity) {
                                    int aux = minQuantity;
                                    minQuantity = maxQuantity;
                                    maxQuantity = aux;
                                }
                                for (Product product : products) {
                                    if (product.getQuantityInStock() < minQuantity || product.getQuantityInStock() > maxQuantity) {
                                        products.remove(product);
                                    }
                                }
                                //User may add price filter too
                                System.out.println("Do you want to filter by Price ? : (Yes / No) ");
                                input = sc.nextLine();
                                if (input.equalsIgnoreCase("YES")) {
                                    System.out.println("Enter the min price: ");
                                    minPrice = Float.parseFloat(sc.nextLine());
                                    System.out.println("Enter the max price: ");
                                    maxPrice = Float.parseFloat(sc.nextLine());
                                    if (minPrice >= 0 && maxPrice >= 0) {
                                        if (minPrice > maxPrice) {
                                            float aux = minPrice;
                                            minPrice = maxPrice;
                                            maxPrice = aux;
                                        }
                                        for (Product product : products) {
                                            if (product.getPrice() < minPrice || product.getPrice() > maxPrice) {
                                                products.remove(product);
                                            }
                                        }
                                        System.out.println("---------------Displaying Products------------------");
                                        System.out.println("Products in the price range: " + minPrice + " - " + maxPrice + " and quantity range: " + minQuantity + " - " + maxQuantity + " and category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                        for (Product product : products) {
                                            System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                        }
                                    } else {
                                        System.out.println("Invalid Prices");
                                    }
                                } else {//if user doesn't want to filter by price //Display by quantity and category
                                    System.out.println("---------------Displaying Products------------------");
                                    System.out.println("Products in the quantity range: " + minQuantity + " - " + maxQuantity + " and category:" + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                                    for (Product product : products) {
                                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                                    }
                                }
                            } else {
                                System.out.println("Invalid Quantities");
                            }
                    }
                }else {//if user doesn't want to add another filter //Display by category
                    System.out.println("---------------Displaying Products------------------");
                    System.out.println("Products in the category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name\t|\tProduct Price\t|\tProduct Quantity");
                    for (Product product : products) {
                        System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\t\t:\t\t" + product.getPrice() + "\t\t:\t\t" + product.getQuantityInStock() + "\n\t");
                    }
                }
        }
    }

    //filer products by Brand
    public ArrayList<Product> filterByBrand(String brand) {
        ArrayList<Product> products = new ArrayList<>();
        for (HashMap<String, Product> productMap : categoryProductMap.values()) {
            for (Product product : productMap.values()) {
                if(product.getBrand().equalsIgnoreCase(brand)){
                    products.add(product);
                }
            }
        }
        return products;
    }


}