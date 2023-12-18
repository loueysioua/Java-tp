import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Provider prov = new Provider("Yamama");
        Library L = new Library("Les jardins" , "Nabeul" , "24/24" , prov );
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username:\t");
        String username = scanner.nextLine();
        System.out.print("Enter your password:\t");
        String password=scanner.nextLine();
        int userIndex= User.login(username , password , L);
        if(userIndex!=-1){
            if (password.contains("Admin") && username.contains("Admin")){
                Admin.menuAdmin((Admin) L.users.get(userIndex));
            }
            else {
                User.menuUser(L.users.get(userIndex));
            }
        }

        /*
        Library L = new Library("Les jardins" , "Nabeul" , "24/24");
        FreeUser U = new FreeUser("adslo123098" , "nero xD" , "Sioua" , "12 Rue Korba Nabeul" , 29813522 , L);
        PreniumUser Up = new PreniumUser("adslo123098" , "BlueRoseNero" , "Sioua" , "12 Rue Korba Nabeul" , 29813522 , L);
        Book b = new Book("Narnia" , "Max Williams" ,245464435 , "Thriller" , 1950 , "Yamama" , 2 , "Eng" , 500);
        Book b1 = new Book("Narnia2" , "Max Williams" ,2464435 , "Thriller" , 1950 , "Yamama" , 3 , "Eng" , 500);
        Book b2 = new Book ("Harry Potter1" , "Beems" , 5454214 , "Magic" , 2000 , "3ami yessine" , 5 , "Eng" , 400);
        Book b3 = new Book ("Harry Potter2" , "Beems" , 5454215 , "Magic" , 2000 , "3ami yessine" , 1 , "Eng" , 450);
        Book b4 = new Book ("Harry Potter3" , "Beems" , 5454216 , "Magic" , 2000 , "3ami yessine" , 3 , "Eng" , 400);
        L.addBook(b);
        L.addBook(b1);
        L.addBook(b1);
        L.addBook(b2);L.addBook(b2);L.addBook(b2);
        L.addBook(b3);
        L.addBook(b4);
        L.addBook(b4);
        L.addBook(b4);
        System.out.println(L.showBooks());
        U.borrowBook(b1);
        U.borrowBook(b2);
        U.borrowBook(b3);
        U.borrowBook(b4);
        U.borrowBook(b4);
        System.out.println(U.showBorrowedBooksList());
        System.out.println(L.showBooks());
        System.out.println(U.showBorrowedBooksList());
        U.printHistory();
        System.out.println(U.toString());
        */
    }
}