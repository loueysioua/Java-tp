import java.time.LocalDate;

public class BorrowedBook extends LibraryBook {
    private LocalDate borrowDate;
    private LocalDate returnDeadLine;
    private LocalDate returnDate;

    public BorrowedBook(String title, String author, long isbn, String genre, int publicationYear, String publisher, int edition, String language, int nbPages, Library L) {
        super(title, author, isbn, genre, publicationYear, publisher, edition, language, nbPages, L);
        this.borrowDate = LocalDate.now();
        this.returnDeadLine = borrowDate.plusDays(10);
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDeadLine() {
        return returnDeadLine;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturnDeadLine(LocalDate returnDeadLine) {
        this.returnDeadLine = returnDeadLine;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\t, borrowDate=" + borrowDate +
                "\n\t, returnDeadLine=" + returnDeadLine +
                "\n\t, returnDate=" + returnDate ;
    }
}
