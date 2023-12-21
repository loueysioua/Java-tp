public class Book {
    public String title;
    public String author;
    public int yearOfPublication;

    public Book(String title, String author, int yearOfPublication){
        this.title = "title";
        this.author = "author";
        this.yearOfPublication = yearOfPublication;
    }

    public Book(){
    }

    public String getTitle(){
        return(this.title);
    }
    public String getAuthor(){
        return(this.author);
    }
    public int getYearOfPublication(){
        return(this.yearOfPublication);
    }
    public void displayInformation(){
        System.out.println("book title : " + this.title);
        System.out.println("book author : " + this.author);
        System.out.print("book year of publication : ");
        System.out.println(this.yearOfPublication);
    }
}
