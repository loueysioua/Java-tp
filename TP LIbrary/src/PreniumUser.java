import java.time.LocalDate;

public class PreniumUser extends User {
    public PreniumUser(String password, String username, String name, String adress, int phoneNum , Library L) {
        super(password, username, name, adress, phoneNum , L);
        userType="Premium User";
    }
    public void borrowBook(Book b){
        int index=L.searchBook(b.getIsbn());
        if ( ( index!=-1) && ((this.getDelay()) <= 7) && ( L.books.get(index).getCopies()!=0 )) {
            BorrowedBook bB = new BorrowedBook(b.getTitle() , b.getAuthor() , b.getIsbn() ,b.getGenre() ,b.getPublicationYear(), b.getPublisher() ,b.getEdition() ,b.getLanguage() ,b.getNbPages() ,this.getLibrary());
            (this.borrowedBooks).add(bB);
            (this.historyOfUser).add(bB);
            bB.setCopies( bB.getCopies()-1 );
            L.books.get( index ).setCopies( (L.books.get(index)).getCopies() - 1 );
            bB.setBorrowDate(LocalDate.now());
            bB.setReturnDeadLine( bB.getBorrowDate().plusDays(13) );
            if (this.getDelay() >= 5) {
                System.out.println("You have more than 5 late books returned !! If you reach 7 you can't borrow anymore books please pay attention to the deadlines !");
            }
        }
        else if (this.getDelay() > 7) {
            System.out.println("You returned late more than 5 books !! You can't borrow anymore Books !");
        }
        else if (L.books.get(index).getCopies()==0){
            System.out.println("Sorry we have no more copies of this book :(");
        }
        else {
            System.out.println("Sorry but we don't have this book in our library .");
        }
    }

}
