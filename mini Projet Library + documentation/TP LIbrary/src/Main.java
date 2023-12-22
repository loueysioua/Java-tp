import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //************* providers must be added as static attributes in the main class

    public static Provider prov1 = new Provider("Yamama");

    //------------------------------------------list of books for easier access and stock managing-----------------------------------

    public static ArrayList<Book> externalBooks() {
        Book b = new Book("Narnia" , "Max Williams" ,245464435 , "Thriller" , 1950 , "Yamama" , 2 , "Eng" , 500);
        Book b1 = new Book("Narnia2" , "Max Williams" ,2464435 , "Thriller" , 1950 , "Yamama" , 3 , "Eng" , 500);
        Book b2 = new Book ("Harry Potter1" , "Beems" , 5454214 , "Magic" , 2000 , "3ami yessine" , 5 , "Eng" , 400);
        Book b3 = new Book ("Harry Potter2" , "Beems" , 5454215 , "Magic" , 2000 , "3ami yessine" , 1 , "Eng" , 450);
        Book b4 = new Book ("Harry Potter3" , "Beems" , 5454216 , "Magic" , 2000 , "3ami yessine" , 3 , "Eng" , 400);
        ArrayList<Book> allBooks = new ArrayList<Book>();
        allBooks.add(b);
        allBooks.add(b1);
        allBooks.add(b2);
        allBooks.add(b3);
        allBooks.add(b4);
        return allBooks;
    }

    //-----------------------------------------to fill the provider's stock and manage it----------------------------------

    public static void providersAndStockManaging(Provider p){
        Provider.menuProvider(p , externalBooks());
    }


    public static void main(String[] args) throws ParseException {
        ArrayList<Book> externalBooks= externalBooks();
        Scanner sc=new Scanner(System.in);
        // ********** for providers :
        //if you want to test provider class :
        //providersAndStockManaging(prov1);
        prov1.booksToProvide.add( externalBooks.get(0) );
        prov1.booksToProvide.add( externalBooks.get(0) );
        prov1.booksToProvide.add( externalBooks.get(0) );
        prov1.booksToProvide.add( externalBooks.get(0) );
        prov1.booksToProvide.add( externalBooks.get(0) );

        prov1.booksToProvide.add( externalBooks.get(1) );
        prov1.booksToProvide.add( externalBooks.get(1) );
        prov1.booksToProvide.add( externalBooks.get(1) );
        prov1.booksToProvide.add( externalBooks.get(1) );
        prov1.booksToProvide.add( externalBooks.get(1) );

        prov1.booksToProvide.add( externalBooks.get(2) );
        prov1.booksToProvide.add( externalBooks.get(2) );
        prov1.booksToProvide.add( externalBooks.get(2) );
        prov1.booksToProvide.add( externalBooks.get(2) );
        prov1.booksToProvide.add( externalBooks.get(2) );

        prov1.booksToProvide.add( externalBooks.get(3) );
        prov1.booksToProvide.add( externalBooks.get(3) );
        prov1.booksToProvide.add( externalBooks.get(3) );
        prov1.booksToProvide.add( externalBooks.get(3) );
        prov1.booksToProvide.add( externalBooks.get(3) );
        // list of books to provide is filled automatically just easier for testing

        //************ libraries :
        Library L = new Library("Les jardins" , "Nabeul" , "24/24" , prov1 );
        //to add admins to the library :
        /*
        System.out.println("number of Admins you want to add to the library :\t");
        int numAdmins=sc.nextInt();
        sc.nextLine();
        while(numAdmins-- >0){
            L.addAdmins();
            System.out.println("----Admin added successfully----");
        }
        */

        Admin a=new Admin("adslo123098" , "Louey" , "Louey" , "nabel" , 29813522 , L);
        /*admin added directly for easier testing check
        ---- Notice : try to remmeber the username and password of the admin
                      (the password and username aren't the same as in the constructor for security reasons)
                      the constructor will display the admin info
                      so please remember the password and username to log in as admin
         */

        a.addBookFromProvider(prov1 ,245464435);
        a.addBookFromProvider(prov1, 2464435);
        a.addBookFromProvider(prov1 , 5454214);
        a.addBookFromProvider(prov1 ,5454215);
        // list of library books is filled automatically for easier testing
        //************** for users :
        System.out.println("Log in or Subscribe (L/S):\t");
        String input= sc.nextLine();
        if (input.equalsIgnoreCase("S")){
            L.subscribeInTheLibrary();
        }
        L.loginToLibrary();

    }
}