import java.util.Scanner;

public class Admin extends PreniumUser{
    private static int adminID=0;

    public Admin( String password, String username, String name, String adress, int phoneNum , Library L ) {
        super(password+"Admin"+Integer.toString(adminID) , username , name, adress, phoneNum , L);
        Admin.adminID++;
        L.admins.add(this);
    }

    public void setPassword(String password) {
        this.password = password +"Admin"+Integer.toString(adminID);
    }

    public static void menuAdmin(Admin A){
        Scanner scanner = new Scanner(System.in);
        String ans = "";
        do {
            System.out.println("------------------------Admin Menu------------------------");
            System.out.println("1- Change your username .");
            System.out.println("2- Change your password .");
            System.out.println("3- Change Library name .");
            System.out.println("4- Change Library work hours .");
            System.out.println("5- See Library books .");
            System.out.println("6- Add a new book .");
            System.out.println("7- See info about a book .");
            System.out.println("8- Look for a book in the library .");
            System.out.println("9- Add a user .");
            System.out.println("10- Add an Event .");
            System.out.println("11- Add a Staff .");
            System.out.println("12- Delete a book .");
            System.out.println("13- Ban a user Definitely (Delete user) .");
            System.out.println("14- Delete a staff .");
            System.out.println("15- Set an event date .");
            System.out.println("16- Set an event status .");
            System.out.println("Please choose an option :");
            ans=scanner.nextLine();
            switch (ans){
                case "1" :
                    System.out.println("Please enter your new username :\t");
                    String newUsername = scanner.nextLine();
                    A.setPassword(newUsername);

                case "2" :
                    System.out.println("Please enter your new password :\t");
                    String newPassword = scanner.nextLine();
                    A.setPassword(newPassword);

                case "3" :
                    System.out.println("Please enter the new library name :\t");
                    String newName = scanner.nextLine();
                    A.setPassword(newName);

                case "4" :
                    System.out.println("Please enter the new library work hours :\t");
                    String newWorkHours = scanner.nextLine();
                    A.setPassword(newWorkHours);

                case "5" :
                    System.out.println(A.L.showBooks());

                case "6" :
                    System.out.println("Please give the book's ISBN to add to the library :\t");
                    A.L.addBook();
            }
        }while(ans.equalsIgnoreCase("NO"));
    }
}
