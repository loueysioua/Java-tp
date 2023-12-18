public class LibraryBook extends Book{
    private int copies;
    public Library L;

    public LibraryBook(String title, String author, long isbn, String genre, int publicationYear, String publisher, int edition, String language, int nbPages, Library L) {
        super(title, author, isbn, genre, publicationYear, publisher, edition, language, nbPages);
        copies=0;
        this.L=L;

    }



    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n\t, copies=" + copies ;
    }
}
