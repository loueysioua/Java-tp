import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Admin extends PreniumUser{
    private static int adminID=0;

    public Admin( String password, String username, String name, String adress, int phoneNum , Library L ) {
        super(password+"Admin"+Long.toString(adminID) , username+"Admin" , name, adress, phoneNum , L);
        Admin.adminID++;
        L.admins.add(this);
    }

    public void setPassword(String password) {
        this.password = password +"Admin"+Integer.toString(adminID);
    }

    public void addBookFromProvider(Provider p,int isbn){
        boolean v=true;
        for(Book b : p.booksToProvide){
            if(b.getIsbn()==isbn){
                v=false;
                L.addBook(b);
                p.booksToProvide.remove(b);
            }
        }
        if (v)
            System.out.println("Our Provider has no Books to provide us with !");
    }
    public static void menuAdmin(Admin A) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String ans;
        do {
            System.out.println("------------------------Admin Menu------------------------");
            System.out.println("1- Change your username .");
            System.out.println("2- Change your password .");
            System.out.println("3- Change Library name .");
            System.out.println("4- Change Library work hours .");
            System.out.println("5- See Library books .");
            System.out.println("6- Add a new book .");
            System.out.println("7- See info about a book from the library .");
            System.out.println("8- Add an Event .");
            System.out.println("9- Delete a book .");
            System.out.println("10- Ban a user Definitely (Delete user) .");
            System.out.println("11- Delete a staff .");
            System.out.println("12- Set an event status .");
            System.out.println("Please choose an option :\t");
            ans=scanner.nextLine();
            switch (ans){
                case "1" :
                    System.out.println("Please enter your new username :\t");
                    String newUsername = scanner.nextLine();
                    A.setPassword(newUsername);
                    break;

                case "2" :
                    System.out.println("Please enter your new password :\t");
                    String newPassword = scanner.nextLine();
                    A.setPassword(newPassword);
                    break;

                case "3" :
                    System.out.println("Please enter the new library name :\t");
                    String newName = scanner.nextLine();
                    A.setPassword(newName);
                    break;

                case "4" :
                    System.out.println("Please enter the new library work hours :\t");
                    String newWorkHours = scanner.nextLine();
                    A.setPassword(newWorkHours);
                    break;

                case "5" :
                    System.out.println(A.L.showBooks());
                    break;

                case "6" :
                    System.out.println("Please give the book's ISBN to add to the library :\t");
                    int isbn1 = scanner.nextInt();
                    A.addBookFromProvider(A.L.p , isbn1);
                    break;

                case "7" :
                    System.out.println("Please enter the book's ISBN :\t");
                    int isbn2 = scanner.nextInt();
                    int index = A.L.searchBook(isbn2);
                    if(index!=-1){
                        System.out.println( A.L.books.get(index).toString() );
                    }
                    else
                        System.out.println("Sorry the book doesn't exist in the library .");
                    break;

                case "8" :
                    System.out.println("Please the necessary information about the event :\n");
                    System.out.println("\t- Event name :\t");
                    String eventName = scanner.nextLine();
                    System.out.println("\t- Event topic :\t");
                    String eventTopic = scanner.nextLine();
                    System.out.println("\t- Event features :\t");
                    String eventFeatures = scanner.nextLine();
                    System.out.println("\t- Event status :\t");
                    String eventStatus = scanner.nextLine();
                    System.out.println("\t- Event date (yyyy-MM-dd) :\t");
                    String eventDate = scanner.nextLine();
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    Date date = dateFormat.parse(eventDate);
                    System.out.println("\t- Event description :\t");
                    String eventDescription = scanner.nextLine();
                    Event e= new Event(eventName , eventTopic , eventFeatures , eventStatus , date , eventDescription);
                    A.L.addEvent(e);
                    break;

                case "9" :
                    System.out.println("Please enter the book's ISBN ( ATTENTION: this will delete all the copies of the book too) :\t");
                    int isbn3 = scanner.nextInt();
                    int indexOfBookToDelete = A.L.searchBook(isbn3);
                    if(indexOfBookToDelete!=-1){
                        System.out.println("Are you sure you want to delete this book from the library ? (Y/N): \t");
                        String confirmation = scanner.nextLine();
                        if(confirmation.equalsIgnoreCase("Y")) {
                            A.L.books.remove(A.L.books.get(indexOfBookToDelete));
                            System.out.println("Book deleted successfully .");
                        }
                    }
                    else
                        System.out.println("Book doesn't exist in the library .");
                    break;

                case "10":
                    System.out.println("Please enter the User's ID :\t");
                    long userID = scanner.nextLong();
                    int indexOfUserToDelete = A.L.searchUser(userID);
                    if(indexOfUserToDelete!=-1){
                        System.out.println("Are you sure you want to ban this user definitely from the library ? (Y/N): \t");
                        String confirmationDelUser = scanner.nextLine();
                        if(confirmationDelUser.equalsIgnoreCase("Y")) {
                            A.L.users.remove(A.L.users.get(indexOfUserToDelete));
                            System.out.println("User banned successfully .");
                        }
                    }
                    else
                        System.out.println("User doesn't exist in the library .");
                    break;

                case "11" :
                    System.out.println("Please enter the Staff's ID :\t");
                    long staffID = scanner.nextLong();
                    int indexOfStaffToDelete = A.L.searchStaff(staffID);
                    if(indexOfStaffToDelete!=-1){
                        System.out.println("Are you sure you want to delete this staff definitely from the library ? (Y/N): \t");
                        String confirmationDelStaff = scanner.nextLine();
                        if(confirmationDelStaff.equalsIgnoreCase("Y")) {
                            A.L.staffs.remove(A.L.staffs.get(indexOfStaffToDelete));
                            System.out.println("Staff deleted successfully .");
                        }
                    }
                    else
                        System.out.println("Staff doesn't exist in the library .");
                    break;

                case "12":
                    System.out.println("Please enter the event ID :\t");
                    long eventID = scanner.nextLong();
                    int indexEvent = A.L.searchEvent(eventID);
                    if(indexEvent != -1) {
                        System.out.println("Please enter the new event status :\t");
                        String newStatus = scanner.nextLine();
                        A.L.events.get(indexEvent).setStatus( newStatus );
                    }
                    break;
            }
        }while(ans.equalsIgnoreCase("NO"));
    }
}
