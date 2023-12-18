import java.time.LocalDate;
import java.util.ArrayList;


public abstract class User {
    public String userType = null ;
    private static int userID=0;
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
            User.userID++;
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
    }

    public User() {
        //default cstr;
    }
//---------------getters----------------
    public int getUserID() {
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
//------------------to see info about the book-----------------
    public void seeInfoAboutBook(Book b){
        System.out.println(b.toString());
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

    public void printHistory(){
        String s="\nYour History is : \n\t";
        for(BorrowedBook b : historyOfUser){
            s += ( b.getTitle() + " borrowed on " + b.getBorrowDate() ) ;
            if(b.getReturnDate()!=null){
                s += ( " and returned on " + b.getReturnDate() + "\n\t");
            }
            else
                s += "\n\t" ;
        }
        System.out.println(s);
    }

}
