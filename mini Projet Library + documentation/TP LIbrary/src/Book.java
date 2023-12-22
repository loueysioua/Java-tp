public class Book {
    private String title;
    private String author;
    private long isbn ;
    private String genre;
    private int publicationYear;
    private String publisher;
    private int edition;
    private String language;
    private int nbPages;

    public Book(String title, String author, long isbn, String genre, int publicationYear, String publisher, int edition, String language, int nbPages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.edition = edition;
        this.language = language;
        this.nbPages = nbPages;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    @Override
    public String toString() {
        return "------------------------------------------------\n"+
                "Book :\n\t" +
                "title='" + title + "\'\n\t" +
                ", author='" + author + "\'\n\t" +
                ", isbn=" + isbn + "\n\t" +
                ", genre='" + genre + "\'\n\t" +
                ", publicationYear=" + publicationYear + "\n\t" +
                ", publisher='" + publisher + "\'\n\t" +
                ", edition=" + edition +"\n\t" +
                ", language='" + language + "\'\n\t" +
                ", nbPages=" + nbPages  ;
    }
}
