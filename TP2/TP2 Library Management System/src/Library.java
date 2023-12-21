import java.util.*;
public class Library {
    public ArrayList<Book> books;
    public String name;

    public Library(String name){
        this.name = name;
        this.books = new ArrayList<Book>();
    }
    public Library(){
    }
    public void addBook(Book b){
        (this.books).add(b);
    }
    public void removeBook(Book b){
        if( !( (this.books).contains(b) ) )
            System.out.println("this book doesn't exist in the library");
        else
            (this.books).remove(b);
    }
    public void listAllBooks(){
        System.out.println("This Library contains :");
        for(Book b : this.books) {
            b.displayInformation();
            System.out.println("**************");
        }
    }
}
