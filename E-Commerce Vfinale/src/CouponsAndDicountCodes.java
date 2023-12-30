import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CouponsAndDicountCodes {
    public static HashMap<String , CouponsAndDicountCodes> codes = new HashMap<>();
    private String code;
    private double discountPercentage;
    private double discountAmount;
    private String type;

    public CouponsAndDicountCodes(String code, double discountPercentage , String type ,double discountAmount) {
        this.code = code;
        switch (type) {
            case "percentage":
                this.discountPercentage = discountPercentage;
                this.discountAmount = 0;
                break;
            case "amount":
                this.discountAmount = discountAmount;
                this.discountPercentage = 0;
                break;
            default:
                break;
        }
    }



    public CouponsAndDicountCodes() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    //admins may add codes to the list
    public static void addCode(String code){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of the code :");
        System.out.println("1- Percentage");
        System.out.println("2- Amount");
        int type = scanner.nextInt();
        scanner.nextLine();
        if(type == 1){
            System.out.println("Enter the percentage :");
            double percentage = scanner.nextDouble();
            codes.put(code, new CouponsAndDicountCodes(code, percentage , "percentage" , 0));
        }
        else if(type == 2){
            System.out.println("Enter the amount :");
            double amount = scanner.nextDouble();
            codes.put(code, new CouponsAndDicountCodes(code, 0 , "amount" , amount));
        }
        else{
            System.out.println("Invalid choice");
        }
    }

}
