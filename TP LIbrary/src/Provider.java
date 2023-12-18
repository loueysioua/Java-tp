import java.util.ArrayList;

public class Provider {
    public ArrayList<Book> booksToProvide;
    public ArrayList<Book> stock;

    private String name ;
    private static long numProviders=0;
    private long providerID;

    public Provider(String name) {
        numProviders++;
        this.providerID=numProviders;
        this.name = name;
    }

    public Provider() {
    }

    public void addBookToStock(Book b){
        stock.add(b);
    }

    public void addBooksToProvide(Book b){
        boolean v=true;
        for(Book tmp : stock){
            if (tmp.getIsbn()==b.getIsbn()){
                v=false;
                booksToProvide.add(b);
                stock.remove(tmp);
            }
        }
        if(v)
            System.out.println("This book is out of stock");
    }
}
