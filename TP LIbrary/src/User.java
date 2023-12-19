import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public abstract class User {
    public String userType = null ;
    private static long numUsers=0;
    private long userID;
    protected String password;
    protected String username;
    public int delay;
    private String name;
    private String adress;
    private int phoneNum;
    public ArrayList<BorrowedBook> borrowedBooks;
    public ArrayList<BorrowedBook> historyOfUser;
    public Library L;

    public User(String password,String username,String name,String adress, int phoneNum , Library L ){
        this.L = L;
        if( !( this.existsUsername(username) ) ) {
            numUsers++;
            this.userID=numUsers;
            this.password = password;
            this.phoneNum = phoneNum;
            this.name = name;
            this.username = username;
            this.adress = adress;
            borrowedBooks = new ArrayList<BorrowedBook>(1);
            historyOfUser = new ArrayList<BorrowedBook>(1);
            this.delay = 0;
            (L.users).add(this);
        }
        else
            System.out.println("Username already exists");
    }

    public User() {
        //default cstr;
    }
//---------------getters----------------
    public long getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getDelay() {
        return delay;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public Library getLibrary() {
        return L;
    }

    //------------------User Setters :--------------------
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        if(!(existsUsername(username)) )
            this.username = username;
        else
            System.out.println("Username already exists !");
    }

//-----------to check if User Exists in Library before creating a new profile
    public boolean existsUsername(String username){
        if( L.searchUsername(username) != -1 ){
            System.out.println("Username already exists . Please choose a different username");
            return true;
        }
        return false;
    }
//--------------------login------------
    static public int login(String username , String password , Library L){
        if(L.searchUsername(username) != -1){
            User user = (L.users).get( L.searchUsername(username) );
            if ( user.getPassword().equals(password) ){
                System.out.println("Login successful. Welcome, " + username + "!");
                return L.searchUsername(username) ;
            }
            else {
                System.out.println("Incorrect password. Please try again.");
            }
        }
        else {
            System.out.println("Username not found. Please check your username.");
        }
        return -1;
    }
//------------------to borrow a book-------------------
    abstract public void borrowBook(Book b);
//---------------------to return a book---------------------
    public void returnBook(Book b) {
        BorrowedBook b1=null;
        for(BorrowedBook bB : borrowedBooks){
            if( (bB.getTitle()).equals( b.getTitle() ) ){
                b1 = bB;
            }
        }
        borrowedBooks.remove(b1);
        assert b1 != null;
        b1.setReturnDate(LocalDate.now());
        b1.setCopies( (b1.getCopies())+1 );
        int index = L.searchBook(b1.getIsbn());
        L.books.get(index).setCopies( L.books.get(index).getCopies() +1 );
        if(b1.getReturnDeadLine().isBefore(b1.getReturnDate()))
            delay++;
    }
//--------------------------to print User info --------------------------------------
    @Override
    public String toString() {
        return  "-------------------------------------------------\n"+
                "User :\n\t" +
                "UserID : " + userID +"\n\t"+
                ", Name : '" + name + "\'\n\t" +
                ", Adress : '" + adress + "\'\n\t" +
                ", PhoneNum : " + phoneNum +"\n\t" +
                ", Username : '" + username + "\'\n\t" +
                ", Password : '" + password + "\'\n\t" +
                ", UserType : '" + userType + "\'\n\t" +
                ", Library : " + L.getName()+"\n\t" +
                ", BorrowedBooks : " + showBorrowedBooksList() + "\n\t"+
                ", delay=" + delay +"\t";
    }

    public String showBorrowedBooksList() {
        String s = "";
        if(!(borrowedBooks.isEmpty())) {
            for (BorrowedBook b : borrowedBooks) {
                s+= (b.getTitle() + " borrowed on " + b.getBorrowDate() + " | ");
            }
        }
        else
            s += "you returned all your books !";
        return s;
    }

    public String showHistory(){
        String s="\nYour History is : \n\t";
        for(BorrowedBook b : historyOfUser){
            s += ( b.getTitle() + " borrowed on " + b.getBorrowDate() ) ;
            if(b.getReturnDate()!=null){
                s += ( " and returned on " + b.getReturnDate() + "\n\t");
            }
            else
                s += "\n\t" ;
        }
        return s;
    }

    public static void menuUser(User A) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String ans;
        do {
            System.out.println("------------------------User Menu------------------------");
            System.out.println("1- Change your username .");
            System.out.println("2- Change your password .");
            System.out.println("3- See Library books .");
            System.out.println("4- See info about a book from the library .");
            System.out.println("5- Borrow a book .");
            System.out.println("6- Return a book .");
            System.out.println("7- See borrowed books .");
            System.out.println("8- See activity history .");
            System.out.println("9- See User Info .");
            System.out.println("Please choose an option :\t");
            ans=scanner.nextLine();
            switch (ans){
                case "1" :
                    System.out.println("Please enter your new username :\t");
                    String newUsername = scanner.nextLine();
                    A.setUsername(newUsername);
                    break;

                case "2" :
                    System.out.println("Please enter your new password :\t");
                    String newPassword = scanner.nextLine();
                    A.setPassword(newPassword);
                    break;

                case "3" :
                    System.out.println(A.L.showBooks());
                    break;

                case "4" :
                    System.out.println("Please enter the book's Title :\t");
                    String title = scanner.nextLine();
                    int index = A.L.searchBook(title);
                    if(index!=-1){
                        System.out.println( A.L.books.get(index).toString() );
                    }
                    else
                        System.out.println("Sorry the book doesn't exist in the library .");
                    break;

                case "5" :
                    System.out.println("Please enter the book's title :\t");
                    String title1 = scanner.nextLine();
                    int indexBook = A.L.searchBook(title1);
                    if(indexBook !=-1){
                        A.borrowBook( A.L.books.get(indexBook) );
                    }
                    else
                        System.out.println("Sorry the book doesn't exist in the library .");
                    break;

                case "6":
                    System.out.println("Please enter the book's title :\t");
                    String titleReturn = scanner.nextLine();
                    for(Book b : A.borrowedBooks){
                        if(b.getTitle().equalsIgnoreCase(titleReturn)){
                            A.returnBook(b);
                            break;
                        }
                    }
                    break;

                case "7":
                    System.out.println(A.showBorrowedBooksList());
                    break;

                case "8":
                    System.out.println(A.showHistory());
                    break;

                case"9" :
                    System.out.println(A.toString());
                    break;
            }
            System.out.println("Would you like to continue ? (YES/No)");
            ans = scanner.nextLine();
        }while( !( ans.equalsIgnoreCase("NO") ) );
    }

}
