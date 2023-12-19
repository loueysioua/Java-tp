import java.util.ArrayList;
import java.util.Scanner;

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
        this.stock = new ArrayList<Book>();
        this.booksToProvide = new ArrayList<Book>();
    }

    public Provider() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBooksToProvide(Book b){
        boolean v=true;
        for(int i=0 ; i< stock.size() ; i++){
            if (stock.get(i).getIsbn()==b.getIsbn()){
                v=false;
                booksToProvide.add(b);
                stock.remove( stock.get(i) );
                break;
            }
        }
        if(v)
            System.out.println("This book is out of stock");
    }

    public String showStock() {
        String bS = "--------------\n";
        if (stock.isEmpty()) {
            bS += "Stock is empty";
        } else {
            bS += "here is a list of '" + this.name + "' provider books in stock :\n";
            for (Book b : stock) {
                bS += "\t- '" + b.getTitle() + "' of ISBN : " + b.getIsbn() + " \n";
            }
        }
        return (bS);
    }

    public String showBooksToProvide() {
        String bS = "------------\n";
        if (booksToProvide.isEmpty()) {
            bS += "There are no books left to provide .";
        } else {
            bS += "here is a list of the books to provide by '" + this.name + "' provider :\n";
            for (Book b : booksToProvide) {
                bS += "\t- '" + b.getTitle() + "' of ISBN : " + b.getIsbn() + " \n";
            }
        }
        return (bS);
    }
    public static void menuProvider(Provider A , ArrayList<Book> exteriorBooks)  {
        System.out.println("------------------------Provider Menu------------------------");
        Scanner scanner = new Scanner(System.in);
        String ans;
        do {
            System.out.println("-------------------------------------------------------------");
            System.out.println("1- Change name .");
            System.out.println("2- See info about a book .");
            System.out.println("3- add a book to stock .");
            System.out.println("4- add a book to the list of books to provide .");
            System.out.println("5- See stock .");
            System.out.println("6- See list of books to provide .");
            System.out.println("Please choose an option :\t");
            ans=scanner.nextLine();
            switch (ans){
                case "1" :
                    System.out.println("Please enter your new name :\t");
                    String newName = scanner.nextLine();
                    A.setName(newName);
                    System.out.println("Name changed successfully .");
                    break;

                case "2" :
                    System.out.println("Please enter the book's title :\t");
                    String title = scanner.nextLine();
                    boolean v=true;
                    if(!A.stock.isEmpty()) {
                        for (Book b : A.stock) {
                            if (b.getTitle().equalsIgnoreCase(title)) {
                                v = false;
                                System.out.println(b.toString());
                                break;
                            }
                        }
                    }
                    if(v)
                        System.out.println("Book doesn't exist .");
                    break;

                case "3" :
                    System.out.println("Please enter the book's ISBN :\t");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    boolean v1=true;
                    for(Book b : exteriorBooks){
                        if ( b.getIsbn()==isbn ) {
                            v1=false;
                            A.stock.add(b);
                            break;
                        }
                    }
                    if(v1)
                        System.out.println("Book doesn't exist .");
                    break;

                case "4" :
                    System.out.println("Please enter the book's ISBN :\t");
                    int isbn1 = scanner.nextInt();
                    scanner.nextLine();
                    boolean v2=true;
                    for (int i=0 ; i<A.stock.size() ; i++){
                        if ( A.stock.get(i).getIsbn()== isbn1 ) {
                            v2=false;
                            A.booksToProvide.add( A.stock.get(i) );
                            A.stock.remove( A.stock.get(i) );
                            break;
                        }
                    }
                    if(v2)
                        System.out.println("Book doesn't exist .");
                    break;

                case "5" :
                    System.out.println(A.showStock());
                    break;

                case "6":
                    System.out.println(A.showBooksToProvide());
                    break;

            }
            System.out.println("Would you like to continue ? (YES/No)");
            ans = scanner.nextLine();
        }while( !( ans.equalsIgnoreCase("NO") ) );
    }
}
