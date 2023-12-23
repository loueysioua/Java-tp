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
            System.out.println("Products in the category: " + productClass.getSimpleName() + "\n\tProduct ID \t|\tProduct Name" );
            for (Product product : productMap.values()) {
                System.out.println(" -\t "+product.getProductId()+"\t\t:\t\t"+product.getName()+"\n\t");
            }
        }
        else{
            System.out.println(productClass.getSimpleName() + " category doesn't exist\n");
        }
    }

    public void printProductDetails(String productId, Class<? extends Product> productClass) {
        HashMap <String, Product> productMap = categoryProductMap.get(productClass);
        if (productMap !=null ) {
            Product product = productMap.get(productId);
            if (product != null) {
                System.out.println(product);
            } else {
                System.out.println("Product not found in the category:"+ productClass.getSimpleName() +"\n");
            }
        }
        else{
            System.out.println(productClass.getSimpleName() + " category doesn't exist\n");
        }
    }

    public void printAllProducts() {
        System.out.println("All products:\n");
        for (HashMap<String, Product> productMap : categoryProductMap.values()) {
            Iterator<Product> it = productMap.values().iterator();
            if(it.hasNext()) {
                System.out.println("Products in the category: " + it.next().getClass().getSimpleName() + "\n\tProduct ID \t|\tProduct Name");
                for (Product product : productMap.values()) {
                    System.out.println(" -\t " + product.getProductId() + "\t\t:\t\t" + product.getName() + "\n\t");
                }
            }
        }
    }

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
                        break;
                    case "Price":
                        System.out.println("Enter the new price: ");
                        input = sc.nextLine();
                        product.setPrice(Float.parseFloat(input));
                        break;
                    case "Quantity":
                        System.out.println("Enter the new quantity in stock: ");
                        input = sc.nextLine();
                        product.setQuantityInStock(Integer.parseInt(input));
                        break;
                    case "Description":
                        System.out.println("Enter the new description: ");
                        input = sc.nextLine();
                        product.setDescription(input);
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

}
